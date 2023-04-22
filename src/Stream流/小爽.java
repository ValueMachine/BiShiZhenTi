package Stream流;

import java.util.ArrayList;
import java.util.List;

public class 小爽 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("王源");
        list.add("王八蛋");
        list.add("丁真");
        list.add("丁毅");
        list.add("丁真珍珠");
        list.add("欧猪");
        list.add("欧线泳");

        list.stream().filter(name -> name.startsWith("欧")).filter(name -> name.length() == 3).forEach(name -> System.out.println(name));


    }
}
