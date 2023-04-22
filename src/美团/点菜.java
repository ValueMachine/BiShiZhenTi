package 美团;

import java.util.Scanner;

/*题目描述：点菜
        小美现在在厨房做饭。小美发现食材现在只够每种菜做一份。
        现在同一时刻（即不分先后顺序）来了n个顾客，每个顾客都有想两份要点的菜。只有当顾客吃到全部自己想要的菜的时候，顾客才会满意。
        现在你的任务是，合理地接取顾客的订单请求，尽可能让更多的顾客满意，并输出最多有多少顾客可以满意。
输入描述：
第一行两个正整数n,m
n表明有多少顾客前来点菜，m表示小美现在能做的菜的编号范围在【1，m】，
接下来的n行，每行两个数字，表明一名顾客的所点的两道菜的编号。
前80%数据保证2<=n<=10,2<=m<=20
剩余的80%数据保证2<=n<=20,2<=m<=40
输出描述：
一行一个正整数表示最多有多少顾客可以满意
样例输入：
3 4
1 2
2 3
3 4
样例输出：
2
解释：最佳方案满足第一个和第三个顾客
        */
public class 点菜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] orders = new int[n][2];
        for (int i=0;i<n;i++){
            orders[i][0] = sc.nextInt();
            orders[i][1] = sc.nextInt();
        }
        int menu[] = new int[m+1];
        System.out.println(dfs(0,orders,menu,n));
    }
    static int dfs(int index, int[][] orders, int[] menu, int n){
        if(index == n ) return  0;
        //不做
        int ans = dfs(index+1,orders,menu,n);
        //做
        if (menu[orders[index][0]] == 0 &&menu[orders[index][1]]==0){
            menu[orders[index][0]] = menu[orders[index][1]]=1;
            ans = Math.max(ans,dfs(index+1,orders,menu,n)+1);
            menu[orders[index][0]] = menu[orders[index][1]]=0;
        }
        return ans;
    }
}
