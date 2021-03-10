package debugtool;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/10 17:29
 * @description： 为了多次载入执行类而加入的加载器<br>
 * @modified By：
 * @version: $
 */
public class HostSwapClassLoader extends ClassLoader {
    public HostSwapClassLoader() {
        super(HostSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
