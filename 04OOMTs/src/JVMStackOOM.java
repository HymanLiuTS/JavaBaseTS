/**
 * @author ：Hyman
 * @date ：Created in 2021/1/27 18:54
 * @description：创建的线程过多，导致内存不足，抛出java.lang.OutOfMemoryError异常
 * run->edit configurations->vm options 设置： -Xss100M
 * @modified By：
 * @version: $
 */
public class JVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {

        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId());
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JVMStackOOM jvmStackOOM = new JVMStackOOM();
        jvmStackOOM.stackLeakByThread();
    }
}
