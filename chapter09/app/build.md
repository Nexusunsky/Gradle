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
                                
    7，Android的java源代码被编译成class字节码以后打包成apk的时候又使用dx命令优化成Android虚拟机可执行的DEX文件；
       对于这些生成DEX文件的过程和处理，AndroidGradle插件会调用SDK的dx命令进行处理，
       其实dx命令是一个shell脚本，调用的是Java编写的dx.jar库，是java程序处理的；
       Android Gradle 通过 dexOptions{}闭包，提供给我们对dx操作进行一些配置；
       dexOptions{}是一个DexOptions类型的闭包：
       提供了五个可供配置项：
               incremental属性，这是一个boolean类型的属性，用来配置是否需要dx的增量模式，默认false表示不启用；     
               javaMaxHeapSize属性，配置dx命令时为其分配的最大堆内存，主要解决执行dx时内存不够用的情况；
               jumboMode属性，用来配置是否启用jumbo模式，程序项目工程庞大，代码太多，方法数超过65535，需要开启jumbo才能构建成功；                 
               preDexLibraries，用来配置是否预执行dexLibraries库工程，开启后大大提高增量构建的速度，不过却可能影响clean的速度；
               threadCount，配置Android Gradle运行dx命令使用的线程数量；
                                
    8，Android Gradle 提供了在构件打包时自动清理未使用资源的方法Resource Sharingking，这是一种在构建打包时，
     因为androidGradle在构建时会拿到所有资源检测所有资源是否被引用，如果没有便不会打包到apk中，这个时机点可以控制打包的资源；                      
     Resource Sharinking要结合Code Sharingking一起使用，也就是我们经常使用的ProGuard；
     当编写代码中使用反射的方式去引用资源文件，针对这样的情况，AndroidGradle提供了keep方法来配置哪些资源不被清理；
     keep 文件是res/raw/keep.xml，然后通过tools:keep属性来配置；
     tools:shrinkMode，用来配置自动清理资源清理的模式，默认是false，安全的；
     
     9，除了Shrink Resources外，Android Gradle还为我们提供resConfigs，属于ProductFlavor的一个方法，
     配置哪些类型的资源才被打包的apk中，resConfig使用非常广泛，其参数是Android开发时的资源限定符，还包括Api Level，分辨率等，
     可以参考Android Doc.
        
                                
                                    