package 父子类的初始化顺序;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/26 17:09
 * @description：
 * @modified By：
 * @version: $
 */
public class Parent {
    public static int A = 1;

    static {
        A = 2;
    }
}
