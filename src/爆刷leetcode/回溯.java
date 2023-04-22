package baoshualicode;

import java.util.*;

public class 回溯 {
    public static void main(String[] args) {
        combine(4,2);
    }
        public static List<List<Integer>> combine(int n, int k) {
            backtracing(4,2,1);
            return res;
        }
        static List<List<Integer>> res = new LinkedList();
        static LinkedList <Integer> path = new LinkedList();
        static  void backtracing(int n ,int k ,int index ){
            if(path.size()==k){
                res.add(new LinkedList(path));
                return;
            }
            for(int i = index ;i<=n;i++){
                path.add(i);
                backtracing(n , k ,i+1);
                path.removeLast();
            }
        }


    }

