package 方法静态解析演示;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/3 9:44
 * @description： 方法静态解析演示，使用javap -verbose StaticResolution.class查看字指令
 * @modified By：
 * @version: $
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
