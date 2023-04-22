package 美团;

import java.util.Arrays;
import java.util.Scanner;

/*第四题：拟合
        题目描述
        小团生日收到妈妈送的两个一模一样的数列作为礼物！他很开心的把玩，不过不小心没拿稳将数列摔坏了！现在他手上的两个数列分别为A和B， 长度分别为n和m。
        小团很想再次让这两个数列变得一样。他现在能做两种操作，操作一是将一个选定数列中的某一个数a改成数b， 这会花费|b-a|的时间，操作二是选择一个数列中某个数a，
        将它从数列中丢掉，花费|a|的时间。
        小团想知道，他最少能以多少时间将这两个数列变得再次相同！
        输入描述
        第一行两个空格隔开的正整数n和m，分别表示数列A和B的长度。
        接下来一行n个整数，分别为A1 A2...An
        接下来一行m个整数，分别为B1 B2...Bm
        对于所有数据，1≤n,m≤2000， |Ai|,|Bi|≤10000
        输出描述
        输出一行一个整数，表示最少花费时间，来使得两个数列相同。
        思路
        让两个数列变得一样。可以消去一个数a，代价是abs(a)，或者这个数a改成b，代价是abs(a-b)。最小的代价是多少（类似编辑距离）*/
public class 拟合 {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(A, B, 0, 0);
        System.out.println(res);
    }

    static int[][] dp;

    public static int dfs(int[] A, int[] B, int indexA, int indexB) {
        if (indexA == A.length && indexB == B.length) return 0;
        if (dp[indexA][indexB] != -1) return dp[indexA][indexB];
        int ans = 0;
        if (indexA != A.length && indexB == B.length) {
            ans = A[indexA] + dfs(A, B, indexA + 1, indexB);
        } else if (indexA == A.length && indexB != B.length) {
            ans = B[indexB] + dfs(A, B, indexA, indexB + 1);
        } else {
            //可能性1 删掉Ai
            int p1 = A[indexA] + dfs(A, B, indexA + 1, indexB);
            //可能性2 删掉Bi
            int p2 = B[indexB] + dfs(A, B, indexA, indexB + 1);
            //可能性3 同时删掉
            // int p3 = A[indexA] + B[indexB] + dfs(A,B,indexA+1,indexB+1);
            //可能性4  改掉
            int p4 = Math.abs(A[indexA] - B[indexB]) + dfs(A, B, indexA + 1, indexB + 1);
            //可能性5 两个相等 包含在可能性4中
            ans = Math.min(p1, Math.min(p2, p4));
        }
        return dp[indexA][indexB] = ans;
    }
}
