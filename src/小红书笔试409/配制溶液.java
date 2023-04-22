package 小红书笔试409;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*配制溶液
        时间限制： 3000MS
        内存限制： 589824KB
        题目描述：
        实验室需要配制一种溶液。现在，研究员面前有n种该物质的溶液，每一种有无限多瓶，第i种的溶液体积为xi，里面含有yi单位的该物质。研究员每次可以选择一瓶溶液，将其倒入另外一瓶（假设瓶子的容量无限），即可以看作将两个瓶子内的溶液合并。此时合并的溶液体积和物质含量都等于之前两个瓶子内的之和。
        特别地，如果瓶子A与B的溶液体积相同，那么A与B合并之后该物质的含量会产生化学反应，使得该物质含量增加X单位。
        研究员的任务是配制溶液体积恰好等于C的，且尽量浓的溶液（即物质含量尽量多）。研究员想要知道物质含量最多是多少。
        输入描述
        第一行三个正整数n,X,C；
        第二行n个正整数x1,x2,...,xn，中间用空格隔开；
        第三行n个正整数y1,y2,...,yn，中间用空格隔开。
        对于所有数据，1≤n,X,C,yi≤1000,1≤xi≤C
        数据保证至少存在一种方案能够配制溶液体积恰好等于C的溶液。
        输出描述
        输出一行一个整数，表示答案。
        样例输入
        3 4 16
        5 3 4
        2 4 1
        样例输出
        29*/
public  class 配制溶液 {
    static  int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
        int X = sc.nextInt();
        int C = sc.nextInt();
        int[] xi = new int[n];
        for (int i = 0; i < n; i++) {
            xi[i] = sc.nextInt();
        }
        int[] yi = new int[n];
        for (int i = 0; i < n; i++) {
            yi[i] = sc.nextInt();
        }

         n1 = n;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(xi[i], yi[i]);
        }
        int max = 0;
        int vol = 0, m = 0;
        for (int i = 0; i < n; i++) {
            if (yi[i] - xi[i] > max) {
                max = yi[i] - xi[i];
                vol = xi[i];
                m = yi[i];
            }
        }
        int count = C / vol;
        int left = C % vol;
        int res = 0;
        int round = count / 2;
        if (count % 2 != 0) {
            res += (count - 1) * m + (round + 1) * X;
            left += vol;
            if (left != 0) {
                if (map.containsKey(left)) res += map.get(left);
            } else if (left != 0) {
                if (left != 0) {
                    if (map.containsKey(left)) res += map.get(left);
                }
            } else {
                res = count * m + count / 2 * X;
            }
            /*System.out.println(res);*/
        }
        int  res1 = dfs(0);
        System.out.println(res1);

    }
    static int n1;
    static int  dfs(int indes){
        n1 = 0;
        return n1;
    }

}