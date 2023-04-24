package 荣耀;

import java.util.*;

public class 第一题最短路 {
    static List<Integer> R = new ArrayList<>();
    static int[] nums;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Deque<int[]> q = new LinkedList<>();
        //boolean[] vst = new boolean[nums.length + 10010];    // T vst的数组长度怎么优化，因为状态可能超出数组长度 用个set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length / 2; i++) {
            q.addLast(new int[]{i, 1});
        //    vst[i] = true;
            set.add(i);
        }
        while (!q.isEmpty()) {
            int[] a = q.pollFirst();
            int node = a[0], w = a[1];
            if (node == nums.length - 1) System.out.println(w);
            if (nums[node] + node <= nums.length - 1 && !set.contains(nums[node] + node))                //!vst[nums[node] + node]
                q.addLast(new int[]{node + nums[node], w + 1});
                 set.add(node + nums[node]);                                                                                                      //  vst[node + nums[node]] = true;
        }
    }
}
