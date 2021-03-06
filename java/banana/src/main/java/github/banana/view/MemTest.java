package github.banana.view;

/**
 * 内存模型
 * <p>
 * 1. 程序计数器
 * 是一个数据结构, 用于保存当前正常执行的程序的内存地址
 * 虚拟机的多线程就是通过线程轮流切换并分配处理器时间来实现的, 为了线程切换后能恢复到正确的位置, 每条线程都需要一个独立的程序计数器, 互不影响
 * 该区域为线程私有
 * <p>
 * 2. 虚拟机栈
 * 线程私有, 与线程生命周期相同, 用于存储局部表量表, 操作栈, 方法返回值
 * 局部变量表存放基本数据类型, 还有对象的引用
 * <p>
 * 3. 本地方法栈
 * 为虚拟机使用 Native 方法服务
 * <p>
 * 4. 堆
 * 所有线程共享的区域, 储存虚拟机加载的类信息, 常量, 静态变量, 编译后的代码
 * <p>
 * 5. 运行时常量池
 * 代表运行时每个 Class 文件中的常量表, 包括几种常量: 编译时数字常量, 方法或者域的引用
 */
public class MemTest {

    public static void main(String[] args) {
        System.out.println("返回输出: " + test());
    }

    private static int test() {
        System.out.println("方法执行...");
        int b = 10;
        try {
            System.out.println("马上返回...");
            return b += 10;
        } finally {
            System.out.println("最后");
            if (b != 10) {
                System.out.println("有这个输出, 说明 finally 是在 return 之后方法返回前执行, b= " + b);
            }
        }
    }
}
