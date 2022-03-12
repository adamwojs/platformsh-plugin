package com.github.adamwojs.platformsh.config

import com.intellij.openapi.project.Project
import com.jetbrains.jsonSchema.extension.JsonSchemaFileProvider
import com.jetbrains.jsonSchema.extension.JsonSchemaProviderFactory

class BuiltInJsonSchemaProviderFactory : JsonSchemaProviderFactory {
    override fun getProviders(project: Project): MutableList<JsonSchemaFileProvider> {
        return mutableListOf(
            BuiltInJsonSchemaFileProvider(
                "Platform.sh application configuration",
                "/schema/app.schema.json",
                Regex("^.*/\\.platform\\.app\\.(yaml|yml)$")
            ),
            BuiltInJsonSchemaFileProvider(
                "Platform.sh routes configuration",
                "/schema/routes.schema.json",
                Regex("^.*/\\.platform/routes\\.(yaml|yml)$")
            ),
            BuiltInJsonSchemaFileProvider(
                "Platform.sh services configuration",
                "/schema/services.schema.json",
                Regex("^.*/\\.platform/services\\.(yaml|yml)$")
            )
        )
    }
}