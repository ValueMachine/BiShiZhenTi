package 华为20230426;

import java.util.*;

public class 第一题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] indegree = new int[n+1];
        List<List<Integer>> nxs = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) {
            nxs.add(new ArrayList<>());
        }
        for (int i = 1; i <=n ; i++) {
            int count = sc.nextInt();
            if (count==0) continue;
            for (int j = 0; j < count; j++) {
                int temp = sc.nextInt();
                nxs.get(temp).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        int res1 = 0, res2 = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res1++;

            for (int i = 0; i < size; i++) {
                int node = q.poll();
                res2++;
                for (int nx : nxs.get(node)) {
                    indegree[nx]--;
                    if (indegree[nx] == 0) q.offer(nx);
                }
            }
        }
         System.out.println(res2 == n ? res1 : -1);
    }
}
