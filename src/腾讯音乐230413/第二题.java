package 腾讯音乐230413;
/*## 小红的好数组
        小红定义一个数组为"好数组”，当且仅当该数组满足以下条件
        1.数组仅由0、1、2三种元素组成
        2.数组相邻的元素不相等。
        例如:121.2.0.1是好数组。
        小红定义一个数组的“陡峭值"”为该数组相邻元素的差的绝对值之和。例如，[2,1,2,0,1]的陡峭值为|2-1|+|1-2|+|2-0|+|0-1| = 5." +
        "小红想知道，长度为n的所有好数组的陡峭值之和是多少? 由于答案过大，请对10^7取模，数据汇围:2<=n<=10^9
        **示例1**
        **输入**
        2
        **输出**
        8
        **说明**
        共有[0,1],[1,0],[0,2],[2,0],[1,2],[2,1]这六个好数组。陡峭值之和为1+1+2+2+1+1=8*/

import java.util.Scanner;

/*```python
        def fastMi(x, n, m):
        res = 1
        while n > 0:
        if n % 2 == 1:
        res = res * x % m
        x = x * x % m
        n //= 2
        return res

        n = int(input())
        mod = 10**9 +7
        ans = ((n-1) * fastMi(2, n + 1, mod)) % (mod)
        print(ans)*/
public class 第二题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long ans = ((n-1)*fastMi(2,n+1,mod))%mod;
        System.out.println(ans);
    }
    static int n;
    static int mod = (int) 1e9+7;
    static long fastMi(long x, int n, int m) {
        long res = 1;
        while(n>0){
            if (n%2==1){
                res =( res*x)%m;
            }
            x = (x * x )% m;
           n >>=1;
        }
        return res;
    }
}
