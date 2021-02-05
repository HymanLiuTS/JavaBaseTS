import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/5 9:39
 * @description：使用jcontrol观察线程的死锁
 * @modified By：
 * @version: $
 */
public class DeadLockTSRunnalbe implements Runnable {

    int a, b;

    public DeadLockTSRunnalbe(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        //Integer.valueOf()方法基于减少对象创建次数和节省内存空间额考虑，[-128,127]之间的数字会被
        //缓存，当该方法传入的参数在这个方法之内，将直接返回缓存中的对象，所以这里可能会出现死锁
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void createDeadThread() {
        for (int i = 0; i < 100; i++) {
            new Thread(new DeadLockTSRunnalbe(1, 2)).start();
            new Thread(new DeadLockTSRunnalbe(2, 1)).start();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("t1 block");
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //当t1持有锁时，t2等待锁的状态显示为block
                synchronized (lock) {
                    System.out.println("t2 block");
                }
            }
        }, "t2");
        t2.start();
        bf.readLine();
        createDeadThread();
    }
}
