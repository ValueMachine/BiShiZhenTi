package 排序;

public class 二分查找 {
    public static void main(String[] args) {
        int [] question = {2,4,6,7,8,15,35};
        int target = 7;
        System.out.println(half(question,target));
    }
    static  int half(int[]nums,int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int middle = left+(right-left)/2;
            if( nums[middle] <target ){
                left  = middle +1;
            }
            else if ( nums[middle] >target ){
                right = middle-1;
            } else
                return middle;
        }
        return -1;
    }
}
