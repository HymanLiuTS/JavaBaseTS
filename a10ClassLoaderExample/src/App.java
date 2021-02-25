/**
 * @author ：Hyman
 * @date ：Created in 2021/2/25 12:21
 * @description：
 * @modified By：
 * @version: $
 */
public class App {
    
    public static void main(String[] args) {
        /**
         *对于静态字段，只有直接定义了该字段的类才会初始化。通过子类
         * 引用父类的静态字段，只会触发父类的初始化，不会触发子类的初始化
         * */
        System.out.println(SubClass.value);
    }
}
