package 华为真题;

import java.util.Scanner;

/*1、服务器能耗统计
        服务器有三种运行状态:空载、单任务、多任务，每个时间片的能耗的分别为1、3、4;
        每个任务由起始时间片和结束时间片定义运行时间:
        如果一个时间片只有一个任务需要执行，则服务器处于单任务状态；
        如果一个时间片有多个任务需要执行，则服务器处于多任务状态；
        给定一个任务列表，请计算出从第一个任务开始，到所有任务结束，服务器的总能耗。
        解答要求
        时间限制: C/C++ 100ms,其他语言: 200ms
        内存限制: C/C++ 128MB,其他语言: 256MB
        输入
        一个只包含整数的二维数组:
        1. num
        2. start0 end0
        3. start1 end1
        4. ...
        第一行的数字表示一共有多少个任务
        后续每行包含由空格分割的两个整数，用于确定每一个任务的起始时间片和结束时间片;
        任务执行时间包含起始和结束时间片，即任务执行时间是左闭右闭的;
        结束时间片一定大于等于起始时间片;时间片范围: [0，1000000]: 任务数范围: [1,10000];
        输出
        一个整数，代表服务器的总能耗。
        样例1
        输入: 2
        25
        89
        输出: 20
        解释: [01] 没有任务需要执行，能耗为0
        [2.5]处于单任务状态，能耗为3*4 = 12
        [6,7] 处于空载状态，能耗为1*2 = 2
        [8,9]处于单任务状态，能耗为3*2 =6
        共计能耗为12 + 2 + 6 = 20
        样例2
        输入: 3
        4 8
        1 6
        2 9
        输出: 3 4
        解释:
        [1,1] 处于单任务状态,能耗为3*1= 3
        [2,8] 处于多任务状态，能耗为4*7=28
        [9,9]处于单任务状态，能耗为3*1 = 3
        共计能耗为3 + 28 + 3 = 34*/
public class CPU时间片0419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] diff = new int[1000001];
        int end = 0;
        int start = 1000002;

        // 计算差分数组
        for (int i = 0; i < num; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            end = Math.max(end, r);
            start = Math.min(start, l);
            diff[l] += 1;
            diff[r + 1] -= 1;
        }

        // 计算前缀和
        int[] res = new int[end + 1];
        res[0] = diff[0];
        for (int i = 1; i <= end; i++) {
            res[i] += res[i - 1] + diff[i];
        }

        // 计算答案
        int ans = 0;
        for (int i = start; i <= end; i++) {
            int r = res[i];
            if (r == 0) {
                ans += 1;
            } else if (r == 1) {
                ans += 3;
            } else {
                ans += 4;
            }
        }
        // 输出答案
        System.out.println(ans);
    }
}

