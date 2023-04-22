package 携程0415;

import java.util.Scanner;

public class 第一题 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            chars[i] = s.toCharArray();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean y = false, o = false, u = false;
                for (int k = i; k < Math.min(i + 2, n); k++) {
                    for (int l = j; l < Math.min(j + 2, m); l++) {
                        if (chars[k][l] == 'y') {
                            y = true;
                        } else if (chars[k][l] == 'o') {
                            o = true;
                        } else if (chars[k][l] == 'u') {
                            u = true;
                        }
                    }
                }
                if (y && o && u) res++;
            }
        }
        System.out.println(res);

    }
}
