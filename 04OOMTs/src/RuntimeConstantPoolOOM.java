import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Hyman
 * @date ：Created in 2021/1/27 19:07
 * @description：这段代码模拟方法区和运行时常量池溢出，发生java.lang.StackOverflowError，
 * 注意只会在jdk1.7之前的版本出现异常，1.7之后没有了永久代，-XX:MaxPermSize=10M无效，会一直执行下去。
 * -XX:PermSize=10M  -XX:MaxPermSize=10M
 * @modified By：
 * @version: $
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
