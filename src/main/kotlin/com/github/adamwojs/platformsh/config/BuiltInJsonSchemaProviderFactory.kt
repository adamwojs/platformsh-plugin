package com.github.adamwojs.platformsh.config

import com.intellij.openapi.project.Project
import com.jetbrains.jsonSchema.extension.JsonSchemaFileProvider
import com.jetbrains.jsonSchema.extension.JsonSchemaProviderFactory

class BuiltInJsonSchemaProviderFactory : JsonSchemaProviderFactory {
    override fun getProviders(project: Project): MutableList<JsonSchemaFileProvider> {
        return mutableListOf(
            BuiltInJsonSchemaFileProvider(
                "Platform.sh routes configuration",
                "/schema/routes.schema.json",
                "/.platform/routes.yaml"
            )
        )
    }
}