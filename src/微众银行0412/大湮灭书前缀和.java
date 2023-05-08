package 微众银行0412;
/* 10
        -32 23 -93 -21 30 9 27 -88 93 61

        -32 -9 -102 -123 -93 -84 -57 -145 -52  9
          32  9   102   123  93   84  57   145  52 -9*/

import java.util.Arrays;
import java.util.Scanner;

public class 大湮灭书前缀和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 地域数量
        int[] energies = new int[n];
        for (int i = 0; i < n; i++) {
            energies[i] = scanner.nextInt();
        }
        int[] prefixSums = new int[n + 1]; // 前缀和数组
        int[] oppositePres = new int[n + 1]; //前缀和数组取反
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + energies[i - 1];
            oppositePres[i] = -prefixSums[i];
        }
        dp = new int[oppositePres.length][4];
        for (int i = 0; i < oppositePres.length; i++) Arrays.fill(dp[i], -1);
        int MaxNegetiveEngry = dfs(1, 0, oppositePres);
        System.out.println(prefixSums[n] + MaxNegetiveEngry);
    }

    static int[][] dp;

    static int dfs(int index, int s, int[] prices) {
        if (index == prices.length || s == 4) return 0;
        if (dp[index][s] != -1) return dp[index][s];
        if (s == 0 || s == 2)
            return dp[index][s] = Math.max(dfs(index + 1, s, prices), dfs(index + 1, s + 1, prices) - prices[index]);
        return dp[index][s] = Math.max(dfs(index + 1, s, prices), dfs(index + 1, s + 1, prices) + prices[index]);
    }

}



