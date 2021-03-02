package 本地变量表slot占用导致不gc;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/2 9:14
 * @description：
 * @modified By：
 * @version: $
 */
public class App {
    public static void main(String[] args) {
        {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
        }
        /*加入了int a=0之后，placeHolder在局部变量表中的slot被复用，
        * 这个变量才无效，才能被回收。*/
        int a=0;
        System.gc();
    }
}
