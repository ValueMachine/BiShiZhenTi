package 华为真题;
import java.util.*;
public class 王子救公主0506 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] lines = new int[k * 2];
            for (int i = 0; i < k * 2; i++) {
                lines[i] = scanner.nextInt();
            }
            Set<Pair<Integer, Integer>> monster = new HashSet<>();   // List<List<Integer>> map = new ArrayList<>();
            int i = 0;
            for (int j = 0; j < k; j++) {
                monster.add(new Pair<>(lines[i], lines[i + 1]));
                i += 2;
            }
            int ex = scanner.nextInt();
            int ey = scanner.nextInt();
            int sx = scanner.nextInt();
            int sy = scanner.nextInt();
            String[][][] grid = new String[n][n][3];
            for (int j = 0; j < n; j++) {
                String[] row = scanner.next().split("");
                for (int k1 = 0; k1 < n; k1++) {
                    for (int l = 0; l < 3; l++) {
                        grid[j][k1][l] = row[k1].substring(l, l + 1);
                    }
                }
            }
            int result = bfs(ex, ey, sx, sy, n, monster, grid);
            System.out.println(result);
        }

    public static int bfs(int ex, int ey, int sx, int sy, int n, Set<Pair<Integer, Integer>> monster, String[][][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0, 0});
        boolean[][] vst = new boolean[n][n];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int time = node[2];
            int waitTime = node[3];
            if (x == ex && y == ey) {
                return time;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || vst[nx][ny] || monster.contains(new Pair<>(nx, ny)) || grid[nx][ny][(time + 1) % 3].equals("1")) {
                    continue;
                }
                vst[nx][ny] = true;
                queue.add(new int[]{nx, ny, time + 1, 1});
            }
            if (waitTime <= 3 && grid[x][y][(time + 1) % 3].equals("0")) {
                queue.add(new int[]{x, y, time + 1, waitTime + 1});
            }
        }
        return -1;
    }

    static class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
        }
    }


