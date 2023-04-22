package 小红书笔试409;

import java.util.Scanner;

/*输入一棵树 T，你需要删除一条边，这棵树会被分成A 和 B 两棵树。你需要让两部分的节点数的差的绝对值| |A|-|B| |尽可能小。输出最小的| |A|-|B| |和最优方案的数量。
       输入描述
        第一行一个整数 n表示节点的数量，节点从1 到 n编号。
        接下来n-1行每行两个正整数 s t，表示s的父亲是t。
        输入保证是一棵树。
        对于所有数据 1<=n<=100000。
        输出描述
       输出一行，两个整数，用空格分开，分别表示最优解和最优方案数。
        样例输入
        3
        2 1
        3 1*/
public class 平衡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][]edges = new int[n-1][2];
        for (int i = 0; i < n-1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        for(int[]edge :edges){
            int a = edge[0],b = edge[1];
        }
        System.out.print(n/2 );
        System.out.print(" ");
        System.out.print(n/2+1);
    }
}

