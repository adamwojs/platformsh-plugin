package com.github.adamwojs.platformsh.config

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class ServiceReference(psiElement: PsiElement, rage: TextRange, name : String) : PsiPolyVariantReferenceBase<PsiElement>(psiElement, rage) {

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        // TODO: Resolve references
        return emptyArray()
    }
}