package 招商银行0428;

import java.util.*;

public class 第三题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(0,new boolean[nums.length],nums);
        System.out.println(res);
        int count = res.size();
        for (int i = 0; i < res.size(); i++) {
            for (int j = i+1; j < res.size(); j++) {
               if (res.get(i).get(0)==res.get(j).get(1)&&res.get(i).get(1)==res.get(j).get(0)||res.get(j).get(0)==res.get(j).get(1)) {
                   count--;
                   res.remove(j);
               }
            }
        }
        System.out.println(res);
        System.out.println(count+1);
    }
    static Set<Integer> set = new HashSet<>();
    static List<List<Integer>> res = new ArrayList<>();

    static LinkedList<Integer> path = new LinkedList<>();

    static void dfs(int index, boolean[] used, int[] nums) {
        if (path.size() == 2) {
            res.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> occ = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && !occ.contains(nums[i])) {
                used[i] = true;
                occ.add(nums[i]);
                path.add(nums[i]);
                dfs(i,used,nums);
                path.removeLast();
                used[i]= false;
            }
        }
    }
}
