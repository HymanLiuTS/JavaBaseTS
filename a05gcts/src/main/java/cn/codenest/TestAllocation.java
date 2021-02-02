package cn.codenest;


public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    /**
     * @author ：Hyman
     * @date ：Created in 2021/2/2 14:04
     * @description： -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @modified By：
     * @version: $
     */
    public static void testAllocation() throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
        Thread.sleep(10000);
    }

    /**
     * @author ：Hyman
     * @date ：Created in 2021/2/2 14:04
     * @description： -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * @modified By：
     * @version: $
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * @author ：Hyman
     * @date ：Created in 2021/2/2 14:04
     * @description： -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1
     * @modified By：
     * @version: $
     */
    public static void testTenuringThrehold() throws InterruptedException {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
        Thread.sleep(10000);
    }

    public static void main(String[] args) throws InterruptedException {
        /*新建对象一般先在Eden分配*/
        //testAllocation();
        /*通过-XX:PretenureSizeThreshold可以控制大于多少就是大对象，需要在老年代直接分配*/
        //testPretenureSizeThreshold();
        /*MaxTenuringThreshold参数控制进入老年代前的gc次数*/
        testTenuringThrehold();
    }
}
