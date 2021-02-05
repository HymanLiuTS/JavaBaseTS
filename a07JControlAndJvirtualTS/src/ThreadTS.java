import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/5 9:03
 * @description：使用jcontrol观察线程的使用情况
 * @modified By：
 * @version: $
 */
public class ThreadTS {

    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                }
            }
        }, "testBusyThread");
        //thread.setDaemon(true);
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        //wait()使得当前线程等待，并且释放掉对象锁
                        lock.wait();
                        System.out.println("createLockThread wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader.readLine();
            createBusyThread();
            bufferedReader.readLine();
            Object obj = new Object();
            createLockThread(obj);
            bufferedReader.readLine();
            synchronized (obj) {
                obj.notifyAll();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
