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
                "/.platform.app.yaml"
            ),
            BuiltInJsonSchemaFileProvider(
                "Platform.sh routes configuration",
                "/schema/routes.schema.json",
                "/.platform/routes.yaml"
            ),
            BuiltInJsonSchemaFileProvider(
                "Platform.sh services configuration",
                "/schema/services.schema.json",
                "/.platform/services.yaml"
            )
        )
    }
}