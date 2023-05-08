package 华为真题;

import java.util.*;

public class 字符串排列 {

    List<String> list = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();
    boolean[] used;

    public String[] permutation(String s) {
        char[] arr = s.toCharArray(); //一行搞定 自动装拆箱
        Arrays.sort(arr);
        used = new boolean[arr.length];
        backtracking(arr);
        //对list进行处理,变成String数组
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
        //return list.toArray(new String[0]); //一行搞定
    }

    public void backtracking(char[] vals) {
        //终止
        if (path.size() == vals.length) {
            //把path放入StringBuidler再变成String,再放入list
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c);
            }
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < vals.length; i++) {
            if (i > 0 && vals[i] == vals[i - 1] && !used[i - 1] || used[i]) {
                continue;
            }
            path.add(vals[i]);
            used[i] = true;
            backtracking(vals);
            used[i] = false;
            path.removeLast();
        }
    }
}

