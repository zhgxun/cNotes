package github.banana.view;

/**
 * Redis持久化方式
 * <p>
 * 也被看成是一个数据结构服务器
 * <p>
 * 数据都存放在内存中, 如果没有配置持久化, 重启后数据就丢失了
 * 于是需要开启持久化功能, 将数据保存到磁盘上, 重启时可从磁盘中恢复数据
 * <p>
 * 2种持久化
 * 1. RDB
 * 将内存中的数据记录定时dump到磁盘上
 * 在指定的时间间隔内将内存中的数据集快照写入磁盘, 实际操作过程是 fork 一个子进程, 先将数据写入临时文件, 写入成功后, 再替换之前的文件, 用
 * 二进制压缩存储
 * <p>
 * 2. AOF
 * 将操作日志以追加的方式写入文件
 * 以日志的形式记录服务器所处理的每一个写, 删除操作, 查询操作不会记录, 以文本的方式记录, 可以打开文件看到详细的操作记录
 * <p>
 * RDB
 * 一旦采用该方式, 整个数据库将指包含一个文件, 这对于文件备份而言是非常完美的, 一旦系统需要恢复, 直接恢复文件即可
 * 可能会丢失一些数据, 由于采用子进程的方式, 当数据集较大时, 可能导致服务短暂暂停
 * <p>
 * AOF
 * 可以带来更高的数据安全性, 系统提供了三种同步方式: 每秒同步, 每修改同步和不同步
 * 事实上每秒同步也是异步完成的，效率非常高, 缺点是一旦该秒出现故障, 此时数据会丢失
 * 每修改同步可以视为同步持久化, 每次发生的数据变化都会立即记录到磁盘中, 效率是最低的
 * <p>
 * 由于该机制是对日志文件的写入操作, 写入过程中即是宕机也不会破坏日志文件已经存在的内容
 * 如果日志文件过大, 可以自动启用 rewrite 机制, 即以 append 模式不断的将修改数据写入到老的磁盘文件中, 同时还会创建一个新的文件用于记录
 * 此期间有哪些修改命令被执行, 更好的保护数据安全
 * <p>
 * 包含了一个格式清晰, 易于理解的日志文件用于记录所有的修改操作, 也可以使用该文件完成数据的重建
 * <p>
 * 但是对于相同数量的数据而言, AOF 文件通常要比 RDB 文件要大, 且恢复数据要相对慢一些
 * 运行效率也会慢一些
 * <p>
 * 选择
 * 看系统是愿意牺牲一些性能换取更高的缓存一致性 AOF
 * 还是愿意写操作频繁的时候不启用备份来换取更高的性能, 待手动运行save的时候在做备份 RDB
 * <p>
 * 配置
 * RDB
 * 将数据快照dump到dump.rdb文件中, 我们也可以修改配置文件来控制dump快照的频率
 * save 900 1  # 在900秒之后, 如果至少有1个key发生变化, 则dump内存快照
 * save 300 10 # 在300秒之后, 如果治得好有10个key发生变化, 则dump内存快照
 * ......
 * <p>
 * AOF
 * 三种同步方式
 * appendfsync always   # 每次有数据修改发生时都会写入文件
 * appendfsync everysec # 每秒钟同步一次, 默认配置
 * appendsync no        # 从不同步, 高效但数据不会持久化
 * <p>
 * sds
 * 字符串是 Redis 中最为常见的数据存储类型, 其底层实现是简单动态字符串sds(simple dynamic string), 是可修改的字符串
 * 类似 ArrayList 采用预分配冗余空间的方式来减少内存的频繁分配
 * <p>
 * 当字符串长度小于1m时扩容都是加倍现有的空间, 如果超过1m扩容时一次只会多扩容1m的空间, 字符串最大长度是512m
 * <p>
 * sds本质上就是 char* 因为有了表头 sdshdr 结构的存在所以 sds 比传统的 c 字符在某些方面更加优秀, 并且能够兼容传统 c 字符串
 * <p>
 * sds 在 Redis 中是实现字符串对象的工具, 并且完全取代 char* , 是二进制安全的, 它可以存储任意二进制数据, 不像 C 语言那样字符串以 '\0'
 * 来标识字符串结束
 * <p>
 * 传统c字符串符合 ASCII 编码, 这种编码的操作特点是遇零则止, 当读一个字符串时只要遇到'\0'结尾就认为达到末尾, 就忽略'\0'结尾以后的所有字符
 * 因此传统的字符串保存图片, 视频等二进制文件操作文件时就被截断
 * <p>
 * sds 表头的 buf 被定义为字节数组, 因为判断是否达到字符串结尾的依据则是表头的 len 成员, 这意味着它可以放任何二进制的数据和文本数据, 包括 '\0'
 * <p>
 * sds 和传统的c字符串获得的做法不同, 传统c字符串遍历字符串长度时遇零则止, 复杂度为O(n) 而sds 表头的 len 成员就保存着字符串的长度, 所以
 * 获得字符串长度的操作复杂度是 O(1)
 * <p>
 * 总结下 sds 的特点是: 可动态扩容, 二进制安全, 快速遍历字符串和传统c字符兼容
 */
public class RedisTest {

    public static void main(String[] args) {

    }
}
