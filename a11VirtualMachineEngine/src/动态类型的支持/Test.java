package 动态类型的支持;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/4 11:19
 * @description：
 * @modified By：
 * @version: $
 */
public class Test {

    class GrandFather {
        void thinking() throws Throwable {
            System.out.println("I am GrandFather");
        }
    }

    class Father extends GrandFather{
        @Override
        void thinking() throws Throwable {
            System.out.println("I am Fathor");
        }
    }

    class Son extends  Father{
        @Override
        void thinking() throws Throwable {
            MethodType mt=MethodType.methodType(void.class);
            /*java8之后，findSpecial做了调整，它只会从第4个参数的直接父类里面找方法，这点
            * 和书上不一致。*/
            MethodHandle mh=lookup().findSpecial(GrandFather.class,"thinking",mt,getClass());
            mh.invoke(this);
        }
    }

    public static void main(String[] args) throws Throwable {
        (new Test().new Son()).thinking();
    }
}
