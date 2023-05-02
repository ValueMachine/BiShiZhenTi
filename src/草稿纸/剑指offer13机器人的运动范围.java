package 草稿纸;

public class 剑指offer13机器人的运动范围 {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, 0, 0, k);
    }

    public static int dfs(boolean[][] visited, int m, int n, int i, int j, int k) {
        if (i >= m || j >= n || bitsum(i) + bitsum(j) > k || visited[i][j]) return 0;
        visited[i][j] = true;
        return dfs(visited, m, n, i + 1, j, k) + dfs(visited, m, n, i, j + 1, k) + 1;
    }

    public static int bitsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
