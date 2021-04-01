package codenest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/1 11:25
 * @description： 研究java反射的代码
 * @modified By：
 * @version: $
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //printNameFromInstance();
        //printNameFromClassName();
        //pringNameFromBasicType();
        //getAllConstructors();
        //invokeMethodOfClass();
        //modifyFieldOfClass();
        modifyStaticField();
        return;
    }

    /**
     * create by: Hyman
     * description: 修改类中的静态变量
     * create time: 2021/4/1
     */
    private static void modifyStaticField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        String name = "codenest.Student";
        Class<?> c = Class.forName(name);
        Field field = c.getDeclaredField("TYPE");
        field.setAccessible(true);
        /*这里可以修改final类型的值*/
        field.set(c, 2);
        System.out.println(field.get(c));
    }

    /**
     * create by: Hyman
     * description: 修改实例中的私有字段
     * create time: 2021/4/1
     */
    private static void modifyFieldOfClass() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String name = "codenest.Student";
        Class<?> c = Class.forName(name);
        Constructor constructor = c.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Student s = (Student) constructor.newInstance("Hyman");
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(s, "jerry");
        System.out.println(s.getName());
    }

    /**
     * create by: Hyman
     * description: 通过反射的方式调用类中的方法
     * create time: 2021/4/1
     */
    private static void invokeMethodOfClass() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String name = "codenest.Student";
        Class<?> c = Class.forName(name);
        Constructor constructor = c.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Student s = (Student) constructor.newInstance("Hyman");
        Class[] p = {String.class};
        /*获取方法，getDeclaredMethod和getMethod的区别在于前者可以获取私有方法*/
        Method method = c.getDeclaredMethod("welcome", p);
        method.setAccessible(true);
        Object args1[] = {"Tom"};
        method.invoke(s, args1);
    }

    /**
     * create by: Hyman
     * description: 获取一个类的构造函数的方法，包括私有和共有的构造函数
     * create time: 2021/4/1
     */
    private static void getAllConstructors() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = "codenest.Student";
        Class<?> c = Class.forName(name);
        /*getConstructors可以获取全部的构造函数，不管是私有的，还是公有的*/
        Constructor<?>[] constructors = c.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.print(constructors[i] + " 参数：");
            Class[] parametertypes = constructors[i].getParameterTypes();
            for (int j = 0; j < parametertypes.length; j++) {
                System.out.println(parametertypes[j].getName() + " ");
            }
        }
        /*根据参数获取构造函数*/
        Constructor constructor = c.getDeclaredConstructor(String.class);
        /*这里要设置可访问属性为true，否则因为构造函数是私有的不会创建实例成功*/
        constructor.setAccessible(true);
        /*根据构造函数创建实例*/
        Student s = (Student) constructor.newInstance("Hyman");
        System.out.println(s.getName());
    }

    /**
     * create by: Hyman
     * description: 根据基本类型的封装类型获取class
     * create time: 2021/4/1
     */
    private static void pringNameFromBasicType() {
        Class c1 = Boolean.TYPE;
        System.out.println(c1.getName());
    }

    /**
     * create by: Hyman
     * description: 根据一个全类型名生成一个class对象，获取类型的名称
     * create time: 2021/4/1
     */
    private static void printNameFromClassName() throws ClassNotFoundException {
        String name = "java.lang.String";
        Class c1 = Class.forName(name);
        Constructor<?>[] constructors = c1.getConstructors();
        System.out.println(c1.getName());
    }

    /**
     * create by: Hyman
     * description: 根据一个字符串实例获取类class，并打印类的名称
     * create time: 2021/4/1
     */
    private static void printNameFromInstance() {
        String name = "zhangsan";
        Class c = name.getClass();
        System.out.println(c.getName());
    }

}
