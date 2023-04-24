package 草稿纸;
import java.util.*;
public class GPTdemo {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1));
        graph.add(Arrays.asList(0, 2, 4));
        graph.add(Arrays.asList(1, 3, 4));
        graph.add(Arrays.asList(2));
        graph.add(Arrays.asList(1, 2));
        List<Integer> shortestPath = getShortestPath(graph);
        System.out.println(shortestPath);
    }

    public static List<Integer> getShortestPath(List<List<Integer>> graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[] visited = new boolean[graph.size()];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curr = node[0];
            int depth = node[1];
            if (graph.get(curr).size() == 1 && curr != 0) {
                List<Integer> path = new ArrayList<>();
                while (curr != 0) {
                    path.add(0, curr);
                    if (!queue.isEmpty()) {  // 检查队列是否为空
                        int[] nextNode = queue.poll();
                        curr = nextNode[0];
                    } else {
                        break;
                    }
                }
                path.add(0, 0);
                System.out.print("路径：");
                for (int i = 0; i < path.size(); i++) {
                    if (i == path.size() - 1) {
                        System.out.print(path.get(i));
                    } else {
                        System.out.print(path.get(i) + "->");
                    }
                }
                System.out.println();
                return path;
            }
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }
        return null;
    }

}


