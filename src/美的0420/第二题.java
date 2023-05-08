package 美的0420;

import java.util.Scanner;

public class 第二题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] lines = input.split("],");
        int[][] grid = new int[lines.length][];
        int i = 0;
        for (String line : lines) {
            int j = 0;
            String[] elements = line.split(",");
            grid[i] = new int[elements.length];
            for (String element : elements) {
                grid[i][j++] = Integer.parseInt(element.replace("[", "").replace("]", ""));
            }
            i++;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 1; j < n; j++) grid[0][j] += grid[0][j - 1];
        for (int j = 1; j < m; j++) grid[j][0] += grid[j - 1][0];
        for (int j = 1; j < m; j++) {
            for (int k = 1; k < n; k++) {
                grid[j][k] += Math.min(grid[j - 1][k], grid[j][k - 1]);
            }
        }
        System.out.println(grid[m - 1][n - 1]);
    }
}
