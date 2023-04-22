package 美团;

import java.util.*;
import java.util.Scanner;

public class 小美地雷 { int n,m;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  m= sc.nextInt();
       int k = sc.nextInt();
       int[][] map = new int[n][m];
       for(int i=0;i<k;i++){
           map[sc.nextInt()][sc.nextInt()] =1 ;
       }
       int x1 = sc.nextInt();
       int y1 = sc.nextInt();
       int x2= sc.nextInt();
       int y2 = sc.nextInt();
          for (int i =0;i<n;i++){
              for(int j = 0;j<m;j++){
                  map[i][j] = map[j][i] = Math.abs(map[i][0]-map[j][0])+ Math.abs(map[i][1]-map[j][1]);
              }
          }
      /*    *//*int ans  = dfs(x1,x2,map);*//*
            System.out.println(ans);
        }
*/
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
       /* int[]  dis  = new int[n];
        Arrays.fill(dis,-1);
         static int dfs(int x, int y, int[][] map){
             if(x=x2,y=y2) return 0;
             for(int[] dir : dirs){
                   int nx = x+dir[0] , ny = y+dir[1];
                   if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==1) continue;
                  dfs(nx,ny,map);
        }
        return 0;*/
    }
}
