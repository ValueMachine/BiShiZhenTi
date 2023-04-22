package 华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*1.交易系统的降级策略
        有一个核心交易系统接口被N个上游系统调用，每个上游系统的调用量R=[R1,R2.....,RN].由于核心交易系统集群故障，需要暂时系统降级限制调用，
        核心交易系统能接受的最大调用量为cnt。设置降级规则如下;如果sum(R1.R2..RN)小于等于cnt，则全部可以正常调用，返回-1;如果sum(R1.R2....RN)大于cnt，
        设置一个闻值limil，如果某个上游系统发起的调用量超过limt，就将该上游系统的调用量限制为limit，
        其余未达到limit的系统可以正常发起调用。求出这个最大的lmit (mit可以为0)此题目对效率有要求，请选择高效的方式。
        解答要求
        时间限制:C/C++ 1000ms,其他语言: 2000ms 内存限制:C/C++200MB其他语言:400MB
        输入描述
        第一行:每个上游系统的调用量(整型数组) 第二行:核心交易系统的最大调用量 0<R.length<=10^5，0<R[i]<105，0<cnt <= 10^9
        输出描述
        调用量的阈值Iimit
        样例1输入:
        1 4 2 5 5 1 6
        13
        输出:
        2
        解释:
        因为1+4+2+5+5+1+6>13;将limit设置为2，则1+2+2+2+2+1+2=12<13。所以imit为2
        样例2输入:
        1 7 8 8 1 0 2 4 9
        7
        输出:
        0
        解释:因为即使imil设置为1,1+1+1+1+1+1+1+1=8>7也不满足，所以limit只能为0*/
public class 交易系统的降级策略230412 {
    static List<Integer> R = new ArrayList<>();

    static int count;

    static boolean check(int x) {
        int res = 0;
        for (int r : R) {
            if (r <= x) res += r;
            else res += x;
        }
        return res <= count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        for (String s : input) {
            R.add(Integer.parseInt(s));
        }
        count = sc.nextInt();
        int l = 0, r = (int) 1e5;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        System.out.println(r);
    }
}
