##插件的应用

###二进制插件的应用
    二进制插件就是实现了org.gradle.api.Plugin接口的插件，它们可以有plugin id并且是唯一的；
例子：
    应用一个java插件：
方式一：apply plugin:'java'
该语句把Java插件应用到我们的项目中了，'java'就是plugin id；对于Gradle自带的核心插件都有一个容易记的短名；
'java'对应的类型是org.gradle.api.plugins.JavaPlugin
方式二：
apply plugin:org.gradle.api.plugins.JavaPlugin
又由于包org.gradle.api.plugins是默认导入的，因此可以：
apply plugin:JavaPlugin

总结：二进制插件一般都是被打包在独立的jar里，比如自定义的插件，在发布的时候可以为其
指定plugin id，这个plugin id最好是一个全限定名称保证插件的plugin id不会重复
