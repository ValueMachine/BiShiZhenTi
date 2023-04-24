package 荣耀;

import java.util.Scanner;

public class 第二题螺旋矩阵右上角出发 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = n*n;
        int[][] matrix = new int[n][n];
        int num = 1;
        int loop = n/2;
        int startx =0,straty = n-1;
        int offset = 1;
        while(loop-- >0){
            for (int i = startx; i <n-offset ; i++) {
                  matrix[i][n-offset] = num++;
            }
            for (int j = n-offset; j>startx ; j--) {
                    matrix[n-offset][j] = num++;
            }
            for (int i = n-offset; i>startx ; i--) {
                matrix[i][startx] = num++;
            }
            for (int j = startx; j < n-offset; j++) {
                matrix[startx][j] = num++;
            }
            startx++;
            straty--;
            offset++;
        }
    if (n%2==1) matrix[startx][straty] = num;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = (matrix[i][j] < 10 ? "  " : " ") + matrix[i][j];
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
