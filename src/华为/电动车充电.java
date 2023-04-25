package 华为;
        /*张三购买了一辆续航里程数达1000公里的某自动驾驶新能源车。 某一天车辆充满电后，需从甲城出发前往距离D公里远的乙城，全程走高速。
        车载导航提示沿途有N个休息站均可提供充电服务，各休息站均可实时提供当前充电排队时间(小时)。
        请协助规划时间最优的休息站充电方案，返回最短的旅行用时。
        为方便计算，高速上的行驶速度固定为100公里/小时。 规划时可不必考虑保留安全续航里程数，汽车可以将电完全用光，
        1000公里续航的汽车按100公里/小时，可以开10个小时。每次充电时间固定为1小时，完成后电量充满。各站点充电排队时间不会变化，充电排队过程不耗电。
        输入描述
        第一行表示甲乙两城的距离D，单位为公里;
        第二行表示沿途的休息站数量N;
        第三行起，每行2个数据，分别表示休息站距离甲城的距离，以及充电排队所需时间(小时)，(各休息站按离从近到远排序)
        0<=D<=1000000，D是100的整数倍
        0<=N<=10000
        1500
        4
        300 2
        600 1
        1000 0
        1200 0
        输出描述
        旅程总计花费的最短时间(小时)
        若无法到达终点，则返回-1
        16
        解释:
        最佳方案：只在第3个休息站(位置1000)进行充电
        1500公里的行程耗时:15小时
        充电排队0小时，充电1小时
        最快旅程总计花费16小时
        其他方案:在第2个休息站(位置600)进行充电，总计花费17小时
        其他方案:在第2个休息站(位置600)和第4个休息站(位置1200)进行充电，总计花费19小时*/

import java.util.Scanner;

//dp[i][j]  位于第i个充电桩，剩余续航是j公里，到达D的最少时间
           /* 充了：dp[i+1][1000-diff(下一个充电桩的距离)] +1+wait[i]+diff/100;
            不充电：dp[i+1][j-diff] +diff/100*/
public class 电动车充电 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int n = sc.nextInt();
        int[] dis = new int[n + 1];
        int[] wait = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = sc.nextInt();
            wait[i] = sc.nextInt();
            if (dis[i] - dis[i - 1] > 1000) {
                System.out.println(-1);
                return;
            }
        }
        if (D - dis[n] > 1000) {
            System.out.println(-1);
            return;
        }
        int[][] dp = new int[n + 1][1001];
        for (int j = 0; j <= 1000; j++) {
            int diff = D - dis[n];
            dp[n][j] = j >= diff ? diff / 100 : (diff / 100 + 1 + wait[n]);
        }
        for (int i = n - 1; i >= 0; i--) {
            int diff = dis[i + 1] - dis[i];
            for (int j = 0; j <= 1000; j++) {
                if (j >= diff) {
                    dp[i][j] = Math.min(dp[i + 1][j - diff], dp[i + 1][1000 - diff] + 1 + wait[i]) + diff / 100;   //续航够 可以充和不充
                } else
                    dp[i][j] = dp[i + 1][1000 - diff] + 1 + wait[i] + diff / 100;                                               //续航不够 只能充
            }
        }
        System.out.println(dp[0][1000]);

    }

}
