package 排序;

import java.util.Arrays;
import java.util.Scanner;

public class 快排 {

    private static int[] kuaipai(int[] nums) {
        if (nums.length <= 1) return nums;
        int pivot = nums[0];
        int[] small = new int[nums.length];
        int[] equal = new int[nums.length];
        int[] large = new int[nums.length];
        int smallerIndex = 0;
        int equalIndex = 0;
        int largeIndex = 0;
        for (int num : nums) {
            if (num < pivot) {
                small[smallerIndex++] = num;
            } else if (num == pivot) equal[equalIndex++] = num;
            else large[largeIndex++] = num;
        }
        small = kuaipai(Arrays.copyOf(small, smallerIndex));
        large = kuaipai(Arrays.copyOf(large, largeIndex));
        System.arraycopy(small, 0, nums, 0, smallerIndex);               // 这个版本递归开销很大 每次都要创建新数组然后合并  但是可以学习这个System.arraycopy
        System.arraycopy(equal, 0, nums, smallerIndex, equalIndex);
        System.arraycopy(large, 0, nums, smallerIndex + equalIndex, largeIndex);
        return nums;
    }

    public static void main(String[] args) {
        int[] question = {3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
        int[] sorts = Arrays.copyOfRange(question, 0, question.length - 1);
        Arrays.sort(sorts);
        System.out.println(Arrays.toString(sorts));
        System.out.println(sorts[sorts.length - 20]);
        /*--------------------------------------------------------------*/
        kuaipai(question);
        System.out.println(Arrays.toString(question));
        System.out.println(question.length);
        int k = 20;
        System.out.println(question[question.length - k]);
    }
}


