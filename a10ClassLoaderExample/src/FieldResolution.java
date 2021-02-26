/**
 * @author ：Hyman
 * @date ：Created in 2021/2/26 16:39
 * @description：
 * @modified By：
 * @version: $
 */
public class FieldResolution {

    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        /*如果有一个同名字段出现在类的接口和父类中，编译器会拒绝编译。如下面把A注释
        * 掉就会拒绝编译*/
        //public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
