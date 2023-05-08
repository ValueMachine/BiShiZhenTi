package 单例;

import java.lang.reflect.Constructor;

public class 反射破坏 {
    public static void main(String[] args) throws Exception {
        //  取singleton的字节码对象
        Class clazz = Singleton.class;
        //获取无参构造方法的对象
        Constructor cons = clazz.getDeclaredConstructor();
        //取向访问检查
        cons.setAccessible(true);
        //创建对象
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();
        //false表示单例模式被破坏
        System.out.println(s1 == s2);

    }
}
