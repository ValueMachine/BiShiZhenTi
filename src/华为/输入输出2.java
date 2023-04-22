package 华为;
import java.util.Scanner;
       /* 输入描述:
        输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
        接下来t行, 每行一组数据。
        每行的第一个整数为整数的个数n(1 <= n <= 100)。
        接下来n个正整数, 即需要求和的每个正整数。
        输出描述:
        每组数据输出求和的结果
        示例1
        输入
        复制
        2
        4 1 2 3 4
        5 1 2 3 4 5
        输出
        10
        15
        */
public class 输入输出2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n=in.nextInt();
            int[] sums=new int[n];
            for (int i = 0; i < n; i++) {
                int n1=in.nextInt();
                for(int j=0;j<n1;j++){
                    sums[i]+=in.nextInt();
                }
                System.out.println(sums[i]);
            }
        }
    }

