package 草稿纸;

import java.util.Arrays;

public class 草稿纸2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(maximizeSum(nums, 3));
    }
    public static int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int last  = nums[nums.length-1];
        int res = 0;
        while(k>0){
            res += last++;
            k--;
        }
        return  res;
    }
}
