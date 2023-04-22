package 美的;

import java.util.Scanner;

public class 第三题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        long count = 1;
        while (count <= n) {
            int a = (int) (n / count);
            int b = (int) (n % count);
            int cur = a % 10;
            a /=10;
            if (cur > 1) {
                res += (a + 1) * count;
            } else if (cur == 1) {
                res +=(a * count + b + 1);
            } else {res += a * count;}
            count *= 10;
        }
        System.out.println(res);
    }
}
