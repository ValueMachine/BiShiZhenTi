package 华为;

import java.util.*;

/*【编程题目 | 200分】考古问题 [ 200 / 中等 ]
        题目描述
        考古问题，假设以前的石碑被打碎成了很多块，每块上面都有一个或若干个字符，请你写个程序来把之前石碑上文字可能的组合全部写出来，按升序进行排列。
        示例
        输入
        3
        a b c
        输出  abc
                 acb
                bac
                bca
                cab
                cba
        */
public class 考古问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");
        Arrays.sort(arr);
        dfs(0, new boolean[n], arr);
        for (int i = 0; i < res.size(); i++) {  // 输出结果
            System.out.println(String.join("", res.get(i)));
        }
    }

    int n;
    static List<List<String>> res = new LinkedList();
    static LinkedList<String> path = new LinkedList();

    static void dfs(int index, boolean[] used, String[] arr) {
        if (path.size() == arr.length) {
            res.add(new LinkedList(path));
            return;
        }
        // Set<String> occ = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            ;
            if (i > 0 && arr[i].equals(arr[i - 1]) && !used[i - 1])
                continue;
            path.addLast(arr[i]);
            used[i] = true;
            dfs(index + 1, used, arr);
            path.removeLast();
            used[i] = false;
        }
    }
}

