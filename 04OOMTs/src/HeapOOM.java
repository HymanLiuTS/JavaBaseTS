import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Hyman
 * @date ：Created in 2021/1/27 18:15
 * @description：Java堆内存不足，发生溢出，抛出java.lang.OutOfMemoryError异常
 * run->edit configurations->vm options 设置：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @modified By：
 * @version: $
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            System.out.println(System.currentTimeMillis());
        }
    }
}
