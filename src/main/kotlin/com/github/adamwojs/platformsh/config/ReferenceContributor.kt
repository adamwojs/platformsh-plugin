package com.github.adamwojs.platformsh.config

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.jetbrains.yaml.psi.YAMLMapping
import org.jetbrains.yaml.psi.YAMLScalar

class ReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        // relationships:
        //      search: <"searchelastic:elasticsearch">
        registrar.registerReferenceProvider(
            PlatformPatterns
                .psiElement(YAMLScalar::class.java)
                .withParent(
                    PlatformPatterns
                        .psiElement(YAMLKeyValue::class.java)
                        .withParent(
                            PlatformPatterns
                                .psiElement(YAMLMapping::class.java)
                                .withParent(
                                    PlatformPatterns
                                        .psiElement(YAMLKeyValue::class.java)
                                        .withName("relationships")
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element is YAMLScalar) {
                        val serviceName = element.text.substringBefore(":")

                        return arrayOf(
                            ServiceReference(
                                element,
                                TextRange(0, serviceName.length),
                                serviceName
                            )
                        )
                    }

                    return emptyArray()
                }
            }
        )
    }
}