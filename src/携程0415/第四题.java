package 携程0415;

import java.util.Scanner;

public class 第四题 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < nums[i]; j++) {
                    sb.append("1");
                }
            } else {
                for (int j = 0; j < nums[i]; j++) {
                    sb.append("0");
                }
            }
        }
        String s = sb.toString();
        String[] subs = new String[1000];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j);
                subs[count++] = sub;

            }
        }
        int res = 0;

        for (String sub : subs) {
            System.out.println(sub);
            if (check(sub)) res++;
        }
        System.out.println(res);

    }

    static boolean check(String s) {
        if (s == null) return false;
        int i = 0;
        int j = s.length() - 1;
        boolean flag = true;
        while (j >= 0 && i < s.length())
            if (s.charAt(i++) != s.charAt(j--)) {
                flag = false;
                break;
            }
        return flag;
    }
}
