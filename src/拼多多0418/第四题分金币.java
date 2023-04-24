package 拼多多0418;

import java.util.Scanner;

public class 第四题分金币 {
    static int T;
    static  long[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        nums = new long[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextInt();
        }
        long[][] ans = new long[T][2];
        for (int i = 0; i < T; i++) {
            if (nums[i] % 2 == 1) {                      //先手为奇数
                ans[i][1] = dfs(nums[i] - 1);    //皮皮虾-1用偶数递归
                ans[i][0] = nums[i] - ans[i][1];
            } else {
                ans[i][0] = dfs(nums[i]);           //先手为偶数用递归
                ans[i][1] = nums[i] - ans[i][0];
            }
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    static long sum = 0;

    static long dfs(long n) {
        if (n == 0) return 0;
        if (n == 4) return dfs(2) + 2;      //确保不会出现1 3  1 1 让对面多拿一个
        if (n % 2 == 0) {                    //偶数
            if ((n / 2) % 2 == 1) return sum = dfs(n / 2 - 1) + n / 2;  //如果偶数除二是奇数，就可以直接拿一半，然后对面只能拿一个了
            else return sum = dfs(n - 2) + 1;                         //如果偶数除二还是偶数，先拿一个，让对面只能拿一个。
        } else {
            return sum = dfs(n - 1 - n / 2) + 1;              //奇数情况  只能拿一个
        }
    }
}
