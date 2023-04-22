package 草稿纸;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class 草稿纸1 {
    public static void main(String[] args) {
       int[] nums = {1, 5, 6, 7, 3, 4};
        Integer newNums[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);
   Arrays.sort(newNums,(a,b)->b-a);

   /*     Arrays.sort(newNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/
        for(int i:newNums){
            System.out.print(i + " ");
        }
    }
}
