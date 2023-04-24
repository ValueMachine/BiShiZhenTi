package 爆刷leetcode;

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
        Arrays.sort(nums);
        int sum = 0;
        int max = nums[n - 1];
        int sec_max = nums[n - 2];
        int round = m / (k + 1);
        int left_round = m % (k + 1);
        sum += round * (max * k + sec_max);
        if (left_round != 0) {
            sum += max * left_round;
        }
        System.out.println(sum);
    }
}
