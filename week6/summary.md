# 第六周总结
> 这一周主要学习的内容有jvm，zookeeper，dubbo，项目中如何使用tracker服务器以及配合的storage，还有就是Nginx整合FastDFS，再比如对于spu和sku的分析与区别，以及如何创建保存修改这些内容。

## 关于项目
> 这周进度正常进行，完成了spu和sku的增删改查部分，完成日期依然在四月十五左右。

## jvm
一、 JVM的生命周期
> 1. JVM实例对应了一个独立运行的java程序它是进程级别
>
> a) 启动。启动一个Java程序时，一个JVM实例就产生了，任何一个拥有public static void main(String[] args)函数的class都可以作为JVM实例运行的起点
>
> b) 运行。main()作为该程序初始线程的起点，任何其他线程均由该线程启动。JVM内部有两种线程：守护线程和非守护线程，main()属于非守护线程，守护线程通常由JVM自己使用，java程序也可以标明自己创建的线程是守护线程
> 
> c) 消亡。当程序中的所有非守护线程都终止时，JVM才退出；若安全管理器允许，程序也可以使用Runtime类或者System.exit()来退出

> 2. JVM执行引擎实例则对应了属于用户运行程序的线程它是线程级别的

二、 JVM的体系结构

> 类装载器、执行引擎、运行时数据区

三、JVM类加载器

> JVM整个类加载过程的步骤：装载、链接、初始化

五、JVM运行时数据区

> 第一块：PC寄存器
>
> 第二块：JVM栈
>
> 第三块：堆
>
> 第四块：方法区域
>
> 第五块：运行时常量池
>
> 第六块：本地方法堆栈

六、JVM垃圾回收

GC的基本原理：将内存中不再被使用的对象进行回收，GC中用于回收的方法称为收集器，由于GC需要消耗一些资源和时间，Java在对对象的生命周期特征进行分析后，按照新生代、旧生代的方式来对对象进行收集，以尽可能的缩短GC对应用造成的暂停
>（1）对新生代的对象的收集称为minor GC；
>
>（2）对旧生代的对象的收集称为Full GC；
>
>（3）程序中主动调用System.gc()强制执行的GC为Full GC。

## zookeeper
一、Zookeeper是什么
> Zookeeper是一个分布式，开放源码的分布式应用程序协调服务，是Google的Chubby一个开源的实现，它是集群的管理者，监视着集群中各个节点的状态，根据节点提交的反馈进行下一步的合理操作。最终将简单易用的接口和性能高效、功能稳定的系统提供给用户。

二、Zookeeper提供了什么
> 文件系统、通知机制

三、文件系统
> 每个子目录项如 NameService 都被称作为znode，和文件系统一样，我们能够自由的增加、删除znode，在一个znode下增加、删除子znode，唯一的不同在于znode是可以存储数据的。

PERSISTENT-持久化目录节点，EPHEMERAL-临时目录节点

四、Zookeeper的通知机制
> 客户端注册监听它关心的目录节点，当目录节点发生变化（数据改变、被删除、子目录节点增加删除）时，Zookeeper会通知客户端。

五、Zookeeper作用
> 命名服务（创建目录，唯一的path）、配置管理、集群管理、分布式锁、队列管理

六、配置管理
> 程序总是需要配置的，如果程序分散部署在多台机器上，要逐个改变配置就变得困难。现在把这些配置全部放到zookeeper上去，保存在 Zookeeper 的某个目录节点中，然后所有相关应用程序对这个目录节点进行监听，一旦配置信息发生变化，每个应用程序就会收到 Zookeeper 的通知，然后从 Zookeeper 获取新的配置信息应用到系统中。

七、集群管理
> 是否有机器退出和加入、选举master。

八、目的
> 最终一致性、可靠性、实时性、等待无关（wait-free）、原子性、顺序性。
