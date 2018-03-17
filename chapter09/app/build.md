##Android Gradle：
    1，Android工程相对与Java工程复杂的多，它有很多相同的任务，而这些相同的任务都是通过BuildType和ProductFlavor一起生成的，
    是动态创建和生成的，而且这些任务的生成时间比较靠后
    
    2，需要控制Android Gradle打包的输出可以通过Android对象的三个属性：
        applicationVariants（仅仅适用于Android应用Gradle插件）
        LibraryVariants(Android库Gradle插件)
        TestVariants（以上两种Gradle插件都适用）
        
    3，上面三个属性返回都是DomainObjectSet对象的集合，集合中的元素是Android构建的产物
    
    4，特别需要注意的时候，访问以上这三种集合都会触发创建所有的任务。
    即我们通过访问这些集合修改生成apk的输出文件名，那么就会自动触发创建所有的任务;
    
    5，每一个ApplicationVariant至少有一个输出，也可以有多个
    
    6，基本上所有的gradle和shell的命令的配合都是一个套路：
        通过实例化收集到Android对象中的一个AdbOptions类型的变量adbOptions{}类型的变量来进行配置。
        最后AndroidGradle调用adb命令的时候，将这些配置作为adb命令的参数传递给adb；
        adb install [-lrtsdg] <file> :     -push this package file to the device and install it
                                            (-l: forward loca application)
                                            (-r: replace existing application)
                                            (-t: allow test package)
                                            (-s: install application to sdcard)
                                            (-d: allow version code downgrade)
                                            (-g: grant all runtime permissons)
                                
                                    