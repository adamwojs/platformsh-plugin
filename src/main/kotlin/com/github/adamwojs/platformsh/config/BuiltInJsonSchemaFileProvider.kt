package com.github.adamwojs.platformsh.config

import com.intellij.openapi.vfs.VirtualFile
import com.jetbrains.jsonSchema.extension.JsonSchemaFileProvider
import com.jetbrains.jsonSchema.extension.JsonSchemaProviderFactory.getResourceFile
import com.jetbrains.jsonSchema.extension.SchemaType
import com.jetbrains.jsonSchema.impl.JsonSchemaVersion

class BuiltInJsonSchemaFileProvider(private val schemaName: String, private val resourcePath: String, private val filePathSuffix: String) : JsonSchemaFileProvider {

    override fun isAvailable(file: VirtualFile): Boolean {
        return file.path.endsWith(filePathSuffix)
    }

    override fun getName(): String {
        return schemaName
    }

    override fun getSchemaFile(): VirtualFile? {
        return getResourceFile(javaClass, resourcePath)
    }

    override fun getSchemaType(): SchemaType {
        return SchemaType.embeddedSchema
    }

    override fun getSchemaVersion(): JsonSchemaVersion {
        return JsonSchemaVersion.SCHEMA_7
    }
}