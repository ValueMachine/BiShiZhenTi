package baoshualicode;

import java.util.*;

public class 递增子序列 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7,};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, nums);
        return res;
    }

    static List<List<Integer>> res = new LinkedList();
    static LinkedList<Integer> path = new LinkedList();

    static void dfs(int index, int[] nums) {
        if (path.size() >= 2) res.add(new LinkedList(path));
        Set<Integer> occ = new HashSet();
        for (int i = index; i < nums.length; i++) {
            if (path.size() > 0 && nums[i] < path.getLast() || occ.contains(nums[i])) continue;
            occ.add(nums[i]);
            path.add(nums[i]);
            dfs(i + 1, nums);
            path.removeLast();
        }
    }
}
