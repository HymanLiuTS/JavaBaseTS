package cn.codenest;

import lombok.Data;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author ：Hyman
 * @date ：Created in 2021/2/1 9:05
 * @description：
 * @modified By：
 * @version: $
 */
public class ReferenceTS {

    @Data
    public static class Person {
        private String name;
    }

    public static void main(String[] args) {

        Person a = new Person();
        a.name = "强引用";
        System.out.println(a.name);

        SoftReference<Person> b = new SoftReference<Person>(a);
        b.get().name = "软引用";
        System.out.println(b.get().name);

        WeakReference<Person> c = new WeakReference<Person>(a);
        b.get().name = "弱引用";
        System.out.println(c.get().name);

        ReferenceQueue<Person> rq = new ReferenceQueue<>();
        PhantomReference<Person> d = new PhantomReference<Person>(a, rq);
        /*这里会报异常，虚引用无法获取对象*/
        d.get().name = "虚引用";
        System.out.println(d.get().name);

        System.out.println("begin gc");
        System.gc();
    }

}
