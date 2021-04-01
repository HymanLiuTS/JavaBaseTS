package codenest;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/1 11:36
 * @description：
 * @modified By：
 * @version: $
 */
public class Student {

    private static int TYPE = 1;

    private String name;
    private int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    private Student(String name) {
        this.name = name;
    }

    public Student() {

    }

    public String getName() {
        return this.name;
    }

    private void welcome(String world) {
        System.out.println("Hello " + world);
    }

}
