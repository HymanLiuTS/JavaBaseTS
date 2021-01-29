package cn.codenest;

/**
 * @author ：Hyman
 * @date ：Created in 2021/1/29 12:19
 * @description：
 * @modified By：
 * @version: $
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA = objB;
        objB = objA;
        objA = null;
        objB = null;
        System.out.println("begin gc");
        System.gc();
    }
}
