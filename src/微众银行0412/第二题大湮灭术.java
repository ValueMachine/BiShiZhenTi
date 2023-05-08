package 微众银行0412;

import java.util.Scanner;

/*
大湮灭术
        时间限制： 3000MS
        内存限制： 589824KB
        题目描述：
        禁忌魔法书中有一道威力强大的禁咒，名为大湮灭术。该禁咒所到之处寸草不生，万物归0。 世间充斥着正负两种能量，正能量对人体有益，而负能量对人体是有害的。
        已知地图上有n个排成一列的地域，每个地域的能量都不一样，
        可以用一个数字来代表某个地域中正负能量的总数，正数代表正能量比负能量多，反之亦然。
        现在大湮灭术的卷轴只剩下了两个，你可以对任何一个连续的区域使用大湮灭术，使用之后，无论该连续区域中能量有多少，都会清0。你希望天地间的正能量最多，
        请问能使得正能量最多为多少。（如果天地间都是正能量，不使用卷轴也是可以的）
         输入描述
        输入第一行仅包含一个正整数n(1<=n<=100000)，表示地域数量。
        输入第二行包含n个整数，每个整数代表一个地域的能量总和,保证这个数值的绝对值不大于100000。
        输出描述
        输出仅包含一个整数，即正能量最多为多少。
        样例输入
        10
        -32 23 -93 -21 30 9 27 -88 93 61
        30 9 27 93 61

        -32 -9 -102 -123 -93 -84 -57 -145 -52  9
          32  9   102   123  93   84  57   145  52 -9
        样例输出
        220
        提示
        数据范围和说明
        显然把{-32 23 -93 -21}和{-88}删掉之后，余下的和为220。
*/
public class 第二题大湮灭术 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count1 =0;
        int ans1 = 0;
            for (int i = 0; i <n/2; i++) {
                count1+= nums[i];
                ans1 = Math.min(count1,Math.min(Math.min(nums[i],Math.min(nums[i]+nums[i+1],nums[i]+nums[i+1]+nums[i+2])),ans1));
                }
        int count2 =0;
        int ans2 = 0;
        for (int i =n/2;i<n;i++){
            count2 += nums[i];
            ans2 = Math.min(count2,Math.min(nums[i],ans2));
        }
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int res = sum-ans2-ans1;
        int count3 =0;
        int ans3 = 0;
        for (int i = 0; i <n; i++) {
            count3+= nums[i];
            ans3 = Math.min(count3,Math.min(nums[i],ans3));
        }
        int res1 = sum-ans3;
        int result = Math.max(res1,res);
        System.out.println(result);

    }
}
