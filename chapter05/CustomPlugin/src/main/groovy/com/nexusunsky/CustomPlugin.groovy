package com.nexusunsky

import com.nexusunsky.ext.CustomExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('ex55GroovyProject') << {
            //在build.gradle apply时调用
            println('Custom Plugin by Groovy Project.')
        }
        // 这段代码将CustomExtension添加到project的extensions中，
        // 于是task就可以通过project.hello.message来获取。
        project.extensions.add('hello', CustomExtension)
        project.task('hello') << {
            println project.hello.message
        }
    }
}