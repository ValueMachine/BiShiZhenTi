package 华为真题;

import java.util.*;

public class 王子救公主0506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] monsters = new boolean[n][n];
        for (int i = 0; i < k * 2; i += 2) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            monsters[a][b] = true;
        }
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        String[][] grid = new String[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] lines = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = lines[j];
            }
        }
        int result = bfs(ex, ey, sx, sy, n, monsters, grid);
        System.out.println(result);
    }

    public static int bfs(int ex, int ey, int sx, int sy, int n, boolean[][] monsters, String[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0, 0});
        boolean[][][] vst = new boolean[n][n][3];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int x = node[0];
            int y = node[1];
            int time = node[2];
            if (x == ex && y == ey) {
                return time;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || monsters[nx][ny] || vst[nx][ny][(time + 1) % 3] || grid[nx][ny].charAt((time + 1) % 3) == '1') {
                    continue;
                }
                vst[nx][ny][(time + 1) % 3] = true;
                queue.addLast(new int[]{nx, ny, time + 1, 1});
            }
            if (!vst[x][y][(time + 1) % 3] && grid[x][y].charAt((time + 1) % 3) == '0') {
                queue.addLast(new int[]{x, y, time + 1});
            }
        }
        return -1;
    }
}


