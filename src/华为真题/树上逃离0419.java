package 华为真题;

import java.util.*;

/* 给定一棵树，这个树有n个节点，节点编号从0开始依次递增，0固定为根节点。在这棵树上有一个小猴子，初始时该猴子位于根节点(0号) 上，
         小猴子一次可以沿着树上的边从一个节点挪到另一个节点，但这棵树上有一些节点设置有障碍物，如果某个节点上设置了障碍物，
         小猴子就不能通过连接该节点的边挪动到该节点上。问小猴子是否能跑到树的叶子节点(叶子节点定义为只有一条边连接的节点)，
         如果可以，请输出小猴子跑到叶子节点的最短路径(通过的边最少)，否则输出字符串NULL。
         解答要求
         时间限制: C/C++ 1000ms,其他语言: 2000ms
         内存限制: C/C++ 256MB,其他语言: 512MB
         输入
         第一行给出数字n，表示这个树有n个节点，节点编号从0开始依次递增，0固定为根节点，1<=n<10000
        第二行给出数字edge，表示接下来有edge行，每行是一条边
        接下来的edge行是边: x y，表示x和y节点有一条边连接
        边信息结束后接下来的一行给出数字block，表示接下来有block行，每行是个障碍物
        接下来的block行是障碍物: X，表示节点x上存在障碍物
        输出
        如果小猴子能跑到树的叶子节点，请输出小猴子跑到叶子节点的最短路径(通过的边最少)，比如小猴子从0经过1到达2 (叶子节点) ，那么输出“0->1->2”，
        否则输出“NULL”。注意如果存在多条最短路径，请按照节点序号排序输出，比如0->1和0->3两条路径，第一个节点0一样，则比较第二个节点1和3，1比3小，
        因此输出0->1这条路径。再如 0->5->2->3 和0->5->1->4，则输出 0->5-31->4
        样例1
        输入: 4
        3
        0 1
        0 2
        0 3
        2
        2
        3
        输出: 0->1*/
public class 树上逃离0419 {
    static List<List<Integer>> nxs;
    //  static boolean[] visited;
    static int n;

    public static void main(String[] args) {
        nxs = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            nxs.add(new LinkedList<>());
        }
        int m = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nxs.get(a).add(b);
            nxs.get(b).add(a);
        }
        int blockLength = sc.nextInt();
        Set<Integer> blocks = new HashSet<>();
        for (int i = 0; i < blockLength; i++) {
            blocks.add(sc.nextInt());
        }
        Set<Integer> vsted = new HashSet<>();
        Deque<Node> q = new LinkedList<>();
        LinkedList<Integer> pa = new LinkedList();
        pa.add(0);
        if (!blocks.contains(0)) q.addLast(new Node(0, 0, pa));
        vsted.add(0);
        while (!q.isEmpty()) {
            Node cur = q.pollFirst();
            if (cur.node != 0 && nxs.get(cur.node).size() == 1) {
                System.out.println(cur.get_Path());
                return;
            }
            for (int nx : nxs.get(cur.node)) {
                if (!blocks.contains(nx) && !vsted.contains(nx)) {
                    vsted.add(nx);
                    List<Integer> path = new LinkedList<>(cur.path);
                    path.add(nx);
                    q.addLast(new Node(nx, cur.weight + 1, path));
                }
            }
        }
    }
    static class Node {
        int node;
        int weight;
        List<Integer> path;
        public Node(int node, int weight, List path) {
            this.node = node;
            this.weight = weight;
            this.path = path;
        }
        public String get_Path() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i != path.size() - 1) {
                    sb.append("->");
                }
            }
            return sb.toString();
        }
    }
}
