/**
 * @author ：Hyman
 * @date ：Created in 2021/1/27 18:42
 * @description：超过jvm最大的栈深度，抛出java.lang.StackOverflowError异常
 * run->edit configurations->vm options 设置： -Xss10M
 * @modified By：
 * @version: $
 */
public class JVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JVMStackSOF oom = new JVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}
