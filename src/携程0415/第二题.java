package 携程0415;

import java.util.Scanner;

public class 第二题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = Long.parseLong(sc.nextLine());
        long[] nums = new long[(int) t];
        for (int i = 0; i < t; i++) {
            nums[(int) i] = Long.parseLong(sc.nextLine());
        }
        long[][] res = new long[(int) t][2];
        for (int i = 0; i < t; i++) {
            if (nums[i]  % 2 == 0) {
                res[i][0] =(nums[i] >>1) - 1;
                res[i][1] = (nums[i] >>1)+ 1;
            } else {
                res[i][0] = nums[i] >> 1;
                res[i][1] = (nums[i] >> 1) + 1;
            }
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
