package 爆刷leetcode;

import java.util.*;

public class 组合总和2 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(0,target,0,candidates);
            return res;
        }
        List<List<Integer>> res = new LinkedList();
        LinkedList<Integer> path = new LinkedList();
        int sum =0;
        void dfs(int index, int target ,int sum, int[]candidates){
            if(sum>=target){
                if(sum == target) res.add(new LinkedList(path));
                return;
            }
            Set<Integer> occ = new HashSet();
            for(int i = index ; i<candidates.length;i++){
                if(occ.contains(candidates[i])) continue;
                occ.add(candidates[i]);
                path.add(candidates[i]);
                dfs(i+1 ,target , sum+candidates[i],candidates);
                path.removeLast();
            }
        }
    }
}
