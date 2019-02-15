package github.banana.view;

/**
 * 垃圾回收
 * <p>
 * 在什么时候
 * 1. 新生代有一个 Eden 区和两个 Survivor 区, 首先将对象放入 Eden 区, 如果空间不足就向其中的一个 Survivor 区上放
 * 如果仍然放不下就会发生一次新生代 Minor GC, 将存活的对象放入另一个 Survivor 区中, 然后清空 Eden和之前的那个 Survivor
 * 区内的内存, 在某次 GC 过程中, 如果发现仍然又放不下对象, 就将这些对象放入老年代内存中
 * <p>
 * 2. 大对象和长期存活的对象直接进入老年代
 * <p>
 * 3. 当每次执行 Minor GC 的时候应该对要晋升到老年代的对象进行分析, 如果这些马上要到老年代的老年对象的大小超过了老年代空间的剩余大小
 * 那么执行一次 Full GC 以尽可能地获取老年代空间
 * <p>
 * 对什么东西
 * 从 GC Roots 搜索不到, 而且经过一次标记清理后仍没有复活的对象
 * <p>
 * 做什么
 * 新生代复制整理, 老年代标记清除, 标记整理算法
 * 永久代类和类加载器
 * <p>
 * GC Roots
 * 1. 虚拟机栈的引用对象
 * 2. 方法区中静态属性引用的对象, 常量引用的对象
 * 3. 本地方法栈中 JNI 引用的对象
 */
public class GcTest {

    public static void main(String[] args) {

    }
}
