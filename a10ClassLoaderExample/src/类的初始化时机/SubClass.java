package 类的初始化时机;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/25 11:40
 * @description：
 * @modified By：
 * @version: $
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("类的初始化时机.SubClass init!");
    }


}
