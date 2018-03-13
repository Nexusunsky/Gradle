##配置第三方依赖：

    1，指明使用的仓库类型，仓库位置；
    可配置的仓库包含有：Maven中心库，jcenter库，ivy库，本地maven库mavenLocal，
    自己搭建的maven私服
    2，依赖配置，dependencies 使用compile（依赖名称，表明编译java源文件时需要依赖）
    Maven中的（groupid，artifactid，version）三条信息标记一个唯一的构件；