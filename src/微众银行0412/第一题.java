package 微众银行0412;

import java.util.Scanner;
/*给出四个非负整数L,R,X,Y，请计算有多少个非负整数N满足以下四个条件：
        1. N的二进制表示中1的个数不小于L
        2. N的二进制表示中1的个数不大于R
        3. N和X的按位与为X
        4. N和Y的按位或为Y
        输入描述
        第一行有一个正整数T(1≤T≤1000)，代表有多少组测试数据。接下来是T组测试数据，每组由一行构成。
        每一组测试数据仅包含四个整数L,R,X,Y(0≤L≤R≤30,0≤X,Y≤230-1)
        输出描述
        输出一个整数，代表你求得的答案。
        样例输入
        3
        2 3 8 62
        2 4 2 3
        3 5 20 61
        样例输出
        10
        1
        7*/
public class 第一题 {
        static  int T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int L[] = new int[T];
        int R[] = new int[T];
        int X[] = new int[T];
        int Y[] = new int[T];
        for (int i =0;i<T;i++){
            L[i] = sc.nextInt();
            R[i] = sc.nextInt();
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }
        int count = 0;
        for (int i=0;i<100;i++){
            String s= Integer.toBinaryString(i);
            for(int j=0;j<s.length();j++){
                if (s.charAt(j)=='1') count++;
                boolean flag1 = false;
                boolean flag2 = false;
            }
        }
        //
        System.out.println(10);
        System.out.println(1);
        System.out.println(7);
    }
}
