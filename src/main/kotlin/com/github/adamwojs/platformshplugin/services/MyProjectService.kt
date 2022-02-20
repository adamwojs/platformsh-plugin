package com.github.adamwojs.platformshplugin.services

import com.intellij.openapi.project.Project
import com.github.adamwojs.platformshplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
