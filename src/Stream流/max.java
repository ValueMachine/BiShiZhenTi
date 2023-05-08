package Stream流;

import java.util.Arrays;

public class max {
    public static void main(String[] args) {
        int[] res = new int[]{1,5,9,7,4,6,3,11};
        System.out.println(Arrays.stream(res).max().getAsInt()- Arrays.stream(res).min().getAsInt());
    }
}
