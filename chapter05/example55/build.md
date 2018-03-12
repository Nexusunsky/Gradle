###开发独立工程插件步骤
1，创建一个Groovy工程，然后配置插件开发所需依赖；
2，然后实现插件类
3，前面讲过，每个插件都有一个唯一的plugin id，定义方法如下：

Gradle 通过META-INF 里的properties 文件来发现对应插件的实现类

    a,首先确定plugin id

    b,便在src/main/resources/META-INF/gradle-plugins/目录下
    新建一个名字为[plugin id].properties的文件

    c,在文件中添加一行内容：
    implementation-class=[plugin id]
    key为implementation-class固定不变，value就是我们自定义的插件实现类

    d,配置好以后，生成jar包 用于 dependenies classpath

    f,使用gradle 打包 Groovy 工程
        gradle clean assemble