package 美团;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/*题目描述：
        有一棵 n 个节点的树，有一条边被选定。小美想知道对于所有经过这条选定边的所有树上简单路径，最长的那条有多长。
        一条简单的路径的长度指这条简单路径上的边的个数。
        输入描述
        第一行一个整数 n，表示树的节点个数。
        第二行 n-1 个整数，第 i 个整数 pi 表示节点 i+1 和 pi 之间有一条边相连。
        第三行两个整数 x, y，表示这条选定的边。保证这条边一定是树上的一条边。
        对于全部数据，2 ≤ n ≤ 105, 1 ≤ pi ≤ n, 1 ≤ x, y ≤ n, x ≠ y。保证输入数据正确描述一棵树，并且 (x, y) 是树上的一条边。
        输出描述
        输出一行，一个整数，表示所有经过选定边的树上简单路径中，最长的那条的长度。
        样例输入
        7
        1 2 3 4 5 3
        3 7
        样例输出
        4*/
public class 必经之路 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree = new ArrayList<>();
        n = sc.nextInt();
        for (int i = 1; i <=n+1; i++) {
            Tree.add(new ArrayList<>());
        }
        int[] pi = new int[n ];
        for (int i = 1; i <n; i++) {
            pi[i] = sc.nextInt();
        }
        int i=1;
        for (int j = 1; j < n; j++) {
            Tree.get(i + 1).add(pi[i]);    //注意数组越界的处理
            Tree.get(pi[i]).add(i + 1);
            i++;
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(dfs(x,y)+dfs(y,x)-1);
    }
    static int n;
    static List<List<Integer>> Tree;
    static  int dfs(int node, int pre){
        int count= 1;
        for (int nx :Tree.get(node)){
            if (nx!=pre){
                count = Math.max(count,dfs(nx,node)+1);
            }
        }
        return  count;
    }

}
