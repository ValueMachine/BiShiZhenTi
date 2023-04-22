package paixu;

import java.util.Arrays;

public class 插排 {
    void insertsort (int[]nums , int n ){
            int i = 1;
            int temp = nums[i];
            for (i=1; i<n;i++){
                int j = i-1;
                for ( ; j >0 ; j--){
                    if (nums[j]>temp);
                    nums[j+1]=nums[j];
                }
                nums[j+1]=temp;
            }

    }
    public static void main(String[] args) {
        int[] question = {1,8,2,5,7,15,9};
        插排 Resqult = new 插排();
       Resqult.insertsort(question, question.length-1);
        System.out.println(Arrays.toString(question));
    }

}
