package 方法静态分派演示;

import java.io.Serializable;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/3 12:04
 * @description：
 * @modified By：
 * @version: $
 */
public class Overload {

    public static void sayHello(Object arg) {
        System.out.println("Hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("Hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("Hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("Hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("Hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("Hello char...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("Hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
