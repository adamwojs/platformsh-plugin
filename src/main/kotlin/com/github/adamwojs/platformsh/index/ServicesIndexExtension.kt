package com.github.adamwojs.platformsh.index

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.indexing.*
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import org.jetbrains.yaml.YAMLFileType

class ServicesIndexExtension : ScalarIndexExtension<String>() {
    val NAME = ID.create<String, Void>("com.github.adamwojs.platformsh.index.services")

    override fun getName(): ID<String, Void> = NAME

    override fun getKeyDescriptor(): KeyDescriptor<String?> {
        return EnumeratorStringDescriptor.INSTANCE
    }

    override fun getIndexer(): DataIndexer<String, Void?, FileContent> = ServicesIndexer()

    override fun getVersion(): Int = 1

    override fun getInputFilter(): FileBasedIndex.InputFilter {
        return object : DefaultFileTypeSpecificInputFilter(YAMLFileType.YML) {
            override fun acceptInput(file: VirtualFile): Boolean {
                return file.path.endsWith("/.platform/services.yaml")
            }
        }
    }

    override fun dependsOnFileContent(): Boolean = true
}