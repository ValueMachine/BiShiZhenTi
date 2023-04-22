package 爆刷leetcode;
import  java.util.*;
public class 水域大小 {

        int []fa , cnts;
        void init(int n){
            fa = new int[n];
            cnts = new int[n];
            for(int i=0;i<n;i++) {
                fa[i] = i;
                cnts[i] =1;
            }
        }
        int find(int x){
            return x==fa[x]? x :(fa[x] = find(fa[x]));
        }
        void union(int x, int y){
            int xp  = find(x), yp = find(y);
            fa[xp] = yp;
            cnts[yp] +=  cnts[xp];
        }
        int getId (int x,int y, int col){return x*col+y;}
        public int[] pondSizes(int[][] land) {
            int[][] dirs ={{0,1},{0,-1},{1,0},{1,-1},{-1,0},{-1,1},{1,1},{-1,-1}};
            int n = land.length , m = land[0].length;
            init(n*m);
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    if(land[i][j]==0){
                        for(int[]dir :dirs){
                            int nx = i+dir[0] , ny = j+dir[1];
                            if(nx<0||ny<0||nx>=n||ny>=m||land[nx][ny]!=0) continue;
                            int id1= getId(i,j,m),id2 = getId(nx,ny,m);
                            if(find(id1)!=find(id2))union(id1,id2);
                        }
                    }
                }
            }
            List<Integer> res = new LinkedList();
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    int id = getId(i,j,m);
                    if(fa[id] == id && land[i][j]==0){
                        res.add(cnts[id]);
                    }
                }
            }
            res.sort((a,b)->a-b);
            int[] ans = new int[res.size()];
            int index =0;
            for(int i : res)ans[index++] = i;
            return ans;

        }

}
