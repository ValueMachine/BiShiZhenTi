package 荣耀;

import java.util.Arrays;
import java.util.Scanner;

/*一张NxM的地图上每个点的海拔高度不同；从当前点只能访问上、下、左、右四个点中还没有到达过的点，且下一步选择的点的海拔高度必须高于当前点;
求从地图中的点A到点B总的路径条数除以10^9的余数。地图左上角坐标为(0,0),右下角坐标为(N-1,M-1) 输入描述
        第一行输入两个整数N,M(O<N≤600，0<M≤600)用空格隔开；
        接下来N行输入，每行M个整数用空格隔开，代表对应位置的海拔高度(0<海拔高度≤360000);
        最后一行四个整数x,y,z,w，前两个代表A的坐标为(x,y);后两个代表B的坐标为 (z,w);
        输入保证A、B坐标不同，且坐标合法 输出描述
        输出一个整数并换行，整数表示从A到B总的路径条数除以10^9的余数
        示例1
        输入
        4 5
        0 1 0 0 0
        0 2 3 0 0
        0 0 4 5 0
        0 0 7 6 0
        0 1 3 2
        输出
        2*/
public class 第三题海拔坐标 {

    static int N;
    static int M;
    static int[][] matrix;
    static int x, y, z, w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix  = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        w = sc.nextInt();
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(x,y));
    }

    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int[][] dp;

    static int dfs(int i, int j) {
        if (i == z && j == w) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= N || nj >= M || matrix[ni][nj] <= matrix[i][j]) continue;
            ans += dfs(ni, nj);
        }
        return dp[i][j] = ans;
    }

}
