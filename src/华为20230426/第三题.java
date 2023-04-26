package 华为20230426;

import java.util.*;

public class 第三题 {

        static int M, n;
        static List<Integer> xs = new ArrayList<>(), ys = new ArrayList<>();
        static int[][][] matrix;
        static int row, col;

        public static boolean check(int x, int y) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][x][y] == 1) cnt++;
            }
            return cnt >= M;
        }

        public static int solv() {
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int x = xs.get(i), y = ys.get(i);
                matrix[i][x][y] = 1;
                q.offer(new int[]{x,y,i});
                if (check(x,y)) return 0;
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                cnt++;
                for (int i = 0; i < size; i++) {
                    int[] front = q.poll();
                    assert front != null;
                    int x = front[0], y = front[1], type = front[2];
                    for (int[] dir : dirs) {
                        int nx = x + dir[0], ny = y + dir[1];
                        if (nx < 0 || ny < 0 || nx >= row || ny >= col || matrix[type][nx][ny] != 0) continue;
                        matrix[type][nx][ny] = 1;
                        q.offer(new int[]{nx,ny,type});
                        if (check(nx,ny)) return cnt;
                    }
                }
            }
            return 0;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            M = sc.nextInt();
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int x,y;
                x = sc.nextInt();
                y = sc.nextInt();
                xs.add(x);
                ys.add(y);
            }

            row = Collections.max(xs);
            col = Collections.max(ys);

            matrix = new int[n][row + 1][col + 1];

            System.out.println(solv());
        }
    }

