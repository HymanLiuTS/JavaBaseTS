import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/9 14:00
 * @description：
 * @modified By：
 * @version: $
 */
public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("Hello Wolrd");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome ");
            return method.invoke(originalObj, args);
        }
    }

    public static void main(String[] args){
        IHello hello=(IHello)new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}
