package paixu;

import java.util.Arrays;

public class 选择排序 {
    public static class Solution {


        private  int[] xuanzepaixu(int[]nums){
            for (int i =0 ; i < nums.length ; i++){
                int minId = i;
                for (int j = i+1; j < nums.length  ; j++){
                        if (nums[j]<nums[minId]){
                                minId = j ;
                        }
                }
                swap(nums,minId,i);
            }
            return nums;
        }

        private  void swap(int[]nums, int fact1,int fact2){
                int temp = nums[fact1];
                nums[fact1] = nums[fact2];
                nums[fact2]=temp;
        }

        public static void main(String[] args) {
            int[] question = {1,8,2,5,7,15,9};
            Solution solution = new Solution();
            solution.xuanzepaixu(question);
            System.out.println(Arrays.toString(question));
        }
    }
}
