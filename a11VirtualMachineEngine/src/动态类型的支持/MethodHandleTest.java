package 动态类型的支持;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/4 10:46
 * @description：
 * @modified By：
 * @version: $
 */
public class MethodHandleTest {
    static class classA{
        public void println(String s){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj=System.currentTimeMillis()%2==0?System.out:new classA();
        getPrintlnMH(obj).invokeExact("hello world");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable{
        /* MethodType代表“方法类型”，包含了方法的返回值和参数 */
        MethodType mt=MethodType.methodType(void.class,String.class);
        /* lookup()方法来自于MethodHandles，这句的作用是在执行类中查找符合给定的方法名称、方法类型，
        * 并且符合调用权限的方法句柄*/
        /* 因为调用的是虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表方法的接收者
        * ，也就是this，这个参数之前在参数表中隐式传递，现在提供了bindTo方法*/
        return lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);
    }
}
