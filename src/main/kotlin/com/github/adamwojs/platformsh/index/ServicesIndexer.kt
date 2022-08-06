package com.github.adamwojs.platformsh.index

import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLFile

class ServicesIndexer : DataIndexer<String, Void?, FileContent> {
    override fun map(data: FileContent): Map<String, Void?> {
        val file = data.psiFile
        if (file is YAMLFile) {
            return YAMLUtil.getTopLevelKeys(file).map { it.keyText }.associateWith { null };
        }

        return emptyMap()
    }
}