import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/1 11:25
 * @description： 研究java反射的代码
 * @modified By：
 * @version: $
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        //printNameFromInstance();
        //printNameFromClassName();
        //pringNameFromBasicType();

        String name = "Test";
        Class c = Class.forName(name);
        System.out.println(c.getName());

        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
           System.out.print(Modifier.toString(constructor.getModifiers()) + "参数：");
        }
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
