package 爆刷leetcode;
import  java.util.*;
public class 课程表 {

        public boolean findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> nxs = new ArrayList();
            for(int i = 0;i<numCourses;i++) nxs.add(new LinkedList());
            int[] indegre = new int[numCourses];
            for(int[] pre: prerequisites){
                int a = pre[0] ,b = pre[1];
                indegre[a]++;
                nxs.get(b).add(a);
            }
            Deque<Integer> q = new LinkedList();
            //找到入度为0的点，加入队列
            for(int i =0;i<numCourses;i++){
                if(indegre[i]==0) q.addLast(i);
            }
            //迭代，更新入度
            int count = 0;
            while(!q.isEmpty()){
                int node = q.pollFirst();
                count++;
                for(int nx: nxs.get(node)){
                    indegre[nx]--;
                    if(indegre[nx]==0) q.addLast(nx);
                }
            }
            return count == numCourses;
        }
    }

