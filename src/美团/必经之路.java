package 美团;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class 美团笔试 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] edges = new int[n - 1][2];
        for (int i = 1; i < n-1 ; i++) {
            edges[i][0] =nums[i];
            edges[i][1] =i+2;
        }
        int []degree = new int[n];
        List<List<Integer>> nxs = new ArrayList<>();
        for(int i =0;i<n;i++) nxs.add(new ArrayList<>());
        for(int[] edge: edges){
            int a = edge[0] , b =edge[1];
            degree[a]++;
            degree[b]++;
            nxs.get(b).add(a);
            nxs.get(a).add(b);
        }
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(degree[i]==1) q.addLast(i);
        }
        List<Integer> res = new LinkedList<>();
        while(!q.isEmpty()){
            res = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.pollFirst();
                res . add((node));
                for(int nx:nxs.get(node)){
                    degree[nx]--;
                    if(degree[nx]==1)q.addLast(nx);
                }
            }
        }
            int count = res.size();
        System.out.println(count);


    }
}
