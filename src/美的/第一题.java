package 美的;

import java.util.Scanner;

public class 第一题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       long n = sc.nextInt();
        String s = "" + n;
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        long n1 = Long.parseLong(s1);
        if(n==1||n==2||n==5||n==7) System.out.println(false);
       else if (check(n) && check(n1)) {
            System.out.println(true);
        } else System.out.println(false);
    }

    static boolean check(long n) {
        for (long i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
