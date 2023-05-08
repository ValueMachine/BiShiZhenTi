package 华为真题;

import java.util.Scanner;

public class 考试得分 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8};
        dfs(0, 0, 0, nums);
        System.out.println(res);
    }

    static int N;
    static int res = 0;

    static void dfs(int index, int flag, int sum, int[] nums) {
        if (index == nums.length || sum == N || flag == 3) {
            if (sum == N) res++;
            return;
        }
        dfs(index + 1, flag + 1, sum, nums);
        dfs(index + 1, flag, sum + nums[index], nums);
    }
}
