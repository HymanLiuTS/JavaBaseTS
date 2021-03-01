package 类的初始化时机;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/25 11:37
 * @description：
 * @modified By：
 * @version: $
 */
public class SuperClass {
    static {
        System.out.println("类的初始化时机.SuperClass init");
    }

    public static int value = 123;
}


