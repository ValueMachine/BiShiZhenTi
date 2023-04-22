package baoshualicode;
import  java.util.*;
public class N皇后 {
            public List<List<String>> solveNQueens(int n) {
            dfs(0, new boolean[n], new boolean[20],new boolean[20],new int[n], n);
            return res;
        }
        List<List<String>> res = new LinkedList();
        void dfs(int index,boolean[]col ,boolean[]diag1,boolean[]diag2,int[]queens,int n){
            if(index==n){
                res.add(generate(queens,n));
                return;
            }
            for(int i=0;i<n;i++){
                if(col[i] || diag1[index+i]||diag2[index-i+9]) continue;
                queens[index] = i;
                col[i] = diag1[index+i] = diag2[index-i+9] =true;
                dfs(index+1,col,diag1,diag2,queens,n);
                col[i] = diag1[index+i] = diag2[index-i+9] = false;
            }
        }
        List<String> generate(int[]queens,int n){
            List<String> board = new LinkedList();
            for(int i=0;i<n;i++){
                char[]row = new char[n];
                Arrays.fill(row,'.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }


