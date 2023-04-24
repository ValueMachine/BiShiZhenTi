package 荣耀;

import java.util.Scanner;

public class 用dirs来解螺旋矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int x = 0, y = n - 1, dir = 0, cnt = 1;
        while (cnt <= n * n) {
            matrix[x][y] = cnt;
            cnt++;
            int nx = x + dirs[dir][0], ny = y + dirs[dir][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || matrix[nx][ny] != 0)
                dir = (dir + 1) % 4;
            x += dirs[dir][0];
            y += dirs[dir][1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = (matrix[i][j] < 10 ? "  " : " ") + matrix[i][j];
                System.out.print(s);
            }
            System.out.println();
    }

    }
}
