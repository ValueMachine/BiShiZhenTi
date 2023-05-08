package 草稿纸;

import java.util.Arrays;

public class 草稿纸三 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 2, 4};
        int[] B = new int[]{3, 1, 2, 4};
        int[] ans= findThePrefixCommonArray(A, B);
       Arrays.stream(ans).forEach(System.out::println);
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        //dp[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。
        int[] res = new int[A.length];
        int[][] dp = new int[A.length][B.length];
        int index =1;
        if (A[0] == B[0]){
            res[0] =1;
        }else res[0] = 0;
          while(index<A.length){
              for (int i = 1; i <= index; i++) {
                  for (int j = 1; j <= index; j++) {
                      if (A[i] == B[i]) dp[i][j] = dp[i - 1][j - 1] + 1;
                      else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                  }
              }
              res[index] = dp[index][index];
              index++;
          }
        return res;
    }
}
