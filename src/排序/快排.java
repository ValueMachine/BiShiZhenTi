package 排序;
import java.util.Arrays;
public class 快排 {
    public static class Solution2 {
       private   int[] kuaipai (int[]nums,int L,int R) {
           if (L >= R) return nums;
           int left = L, right = R;
           int pivot = nums[left];
           while (left < right) {
               while (left < right && nums[right] >= pivot) {
                   right--;
               }
             //  if (left < right) {
                   nums[left] = nums[right];
             //  }
               while (left < right && nums[left] <= pivot) {
                   left++;
               }
              // if (left < right) {
                   nums[right] = nums[left];
             //  }
               //if (left >= right) {
                   nums[left] = pivot;
             //  }
               kuaipai(nums, L, right - 1);
               kuaipai(nums, right + 1, R);

           }
           return nums;
       }
              public static void main(String[] args) {
            int[] question = {1,8,2,5,7,15,9};
            Solution2 res = new Solution2();
           res.kuaipai(question,0, question.length-1);
            System.out.println(Arrays.toString(question));
        }
    }

}
