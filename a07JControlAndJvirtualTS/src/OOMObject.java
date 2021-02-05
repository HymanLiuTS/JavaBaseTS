import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/5 8:43
 * @description： 使用jcontrol观察内存的使用情况
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 * @modified By：
 * @version: $
 */
public class OOMObject {
    public byte[] palceHolder = new byte[64 * 1024];

    public static void fillHead(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHead(1000);
    }
}
