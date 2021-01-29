package cn.codenest;

/**
 * @author ：Hyman
 * @date ：Created in 2021/1/29 19:42
 * @description：
 * @modified By：
 * @version: $
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,im still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功自救
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法的优先级很低，这里暂停0.5秒来等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,im dead");
        }

        //第二次，因为对象在上一次已经执行过finalize，因此它不会再被放入F-QUEUE队列,会自救失败
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法的优先级很低，这里暂停0.5秒来等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,im dead");
        }
    }

}
