package baoshualicode;

import java.util.*;

/*4 4 2
4 3 2 1*/
public class 百度笔试 {
    static int n;
    static int m;
    static int k;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //int ans =  dfs(0,0,0,nums);
        dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = dfs(0, 0, 0, 0, nums);
        System.out.println(ans);
    }

    static int[] dp;

    static int dfs(int index, int flag, int sum, int cur, int[] nums) {
        if (cur >= m || index >= nums.length) return sum;
        for (int i = 0; i < n; i++) {
            if (dp[index] != -1) return dp[i];
            if (flag >= k) {
                flag = 0;
                continue;
            }
            sum = Math.max(dfs(index, flag + 1, sum + nums[i], cur + 1, nums), dfs(index + 1, flag, sum, cur + 1, nums));
        }
        return dp[index] = sum;
    }
}
