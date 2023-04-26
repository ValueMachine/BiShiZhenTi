package 排序;

import java.util.Arrays;

public class 快排2 {
    public static void main(String[] args) {
        int[] question = {3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
        int[] sorts = Arrays.copyOfRange(question, 0, question.length );
        Arrays.sort(sorts);
        System.out.println(Arrays.toString(sorts));
        System.out.println(sorts.length);
        System.out.println(sorts[sorts.length - 20]);
        /*--------------------------------------------------------------*/
        quickSort(question,0,question.length-1);
        System.out.println(Arrays.toString(question));
        System.out.println(question.length);
        int k = 20;
        System.out.println(question[question.length - k]);
    }
    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left];
        int i = left , j = right;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);

        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
