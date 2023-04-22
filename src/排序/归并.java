package paixu;

import java.util.Arrays;

public class 归并 {

   static void hebing(int[] nums, int L , int R , int mid){

        int []temp = new int[nums.length ];
        int i=L , j=mid ,p=L;    //p是指向temp数组
        while (i<mid&& j<=R){
            if (nums[i]<nums[j]){
                temp[p++]=nums[i++];
            }else  temp[p++]=nums[j++];
        }
        while (i<mid){
            temp[p++]=nums[i++];
        }
        while (j<=R){
            temp[p++]=nums[j++];
        }
        p=L;i=L;
        while (p<=R){
            nums[i++]=temp[p++];
        }
    }

  static  void  merge_sort(int[] nums , int L , int R) {
        if (L < R) {
            int mid = (L + R) / 2;
            merge_sort(nums,L, mid);
            merge_sort(nums,mid + 1, R);   //分
            hebing(nums,L, R, mid + 1);
        }

    }
    public static void main(String[] args) {
        int[]nums={1,8,2,5,7,15,9};
        merge_sort(nums,0, 6);
        System.out.println(Arrays.toString(nums));
    }

}
