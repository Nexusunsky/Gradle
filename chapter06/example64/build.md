##发布构件：
    Gradle 构件的产物，称之为构件（jar,zip,war等）
    1，定义发布的构件类型:
        发布的构件通过
            artifacts{}配置
            可以使用一个Task来为发布提供构件还可以直接发布一个文件对象；

    2，配置好需要发布的构件就需要发布了：
        将配置好的构件上传到指定的目录，指定的Maven库，一个指定Ivy


    3，uploadArchives 是一个Upload Task ，用于发布我们的构件