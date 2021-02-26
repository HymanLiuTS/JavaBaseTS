package 静态变量或者静态块的加载顺序;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/26 17:02
 * @description： 静态语句块只能访问定义在静态语句块之前的变量，定义在它之后的
 * 变量，前面的静态语句块可以复制，但是不能访问
 * @modified By：
 * @version: $
 */
public class StaticTest {
    static {
        i = 0; //给变量赋值可以正常编译通过
        //System.out.println(i);//访问在后面定义的类变量（静态变量），编译器会报错
    }

    static int i = 1;
}
