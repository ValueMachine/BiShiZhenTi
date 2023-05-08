package 招商银行0428;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class 第一题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] matrix = new char[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = sc.next().charAt(0);
            matrix[i][1] = sc.next().charAt(0);
        }
        List<Integer> smaller = new ArrayList<>();
        List<Integer> bigger = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 'G') {
                bigger.add(Integer.parseInt(new StringBuilder().append(matrix[i][1]).toString()));
            } else {
                smaller.add(Integer.parseInt(new StringBuilder().append(matrix[i][1]).toString()));
            }
        }
        int Smax = 0, Smin = 0;
        for (int i = 0; i < smaller.size(); i++) {
            Smax = Math.max(Smax, smaller.get(i));
            Smin = Math.min(Smin, smaller.get(i));
        }
        int Bmax = 0, Bmin = 0;
        for (int i = 0; i < bigger.size(); i++) {
            Bmax = Math.max(Bmax, smaller.get(i));
            Bmin = Math.min(Bmin, smaller.get(i));
        }
        int Srange = Smax - Smin;
        int Brange = Bmax - Bmin;
        if (Bmin > Smax) {
            System.out.println(Math.min(Srange, Brange));
        }

    }
}
