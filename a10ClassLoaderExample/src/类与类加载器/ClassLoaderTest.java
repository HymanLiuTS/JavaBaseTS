package 类与类加载器;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/1 9:09
 * @description：
 * @modified By：
 * @version: $
 */
public class ClassLoaderTest {

    public static void main(String[] arges) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myClassLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fieldName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fieldName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj=myClassLoader.loadClass("类与类加载器.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof 类与类加载器.ClassLoaderTest);
    }
}
