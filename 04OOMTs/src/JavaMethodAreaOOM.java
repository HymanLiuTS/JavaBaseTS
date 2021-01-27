//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ：Hyman
 * @date ：Created in 2021/1/27 19:23
 * @description：本示例利用cglib动态生成大量的代理类，模拟方法区抛出java.lang.OutOfMemoryError异常
 * @modified By：
 * @version: $
 */
public class JavaMethodAreaOOM {
    public static void main(final String[] args) {
        while (true) {
            //todo 这里利用CGLib演示方法区outofmerrory,但是没有引入相关jar，先注释掉
            //Enhancer enhancer = new Enhancer();
            //enhancer.setSuperclass(OOMObject.class);
            //enhancer.setUseCache(false);
            //enhancer.setCallback(new MethodInterceptor() {
                //@Override
                //public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    //return methodProxy.invokeSuper(o, args);
                //}
            //});
            //enhancer.create();
        }
    }

    static class OOMObject {

    }
}
