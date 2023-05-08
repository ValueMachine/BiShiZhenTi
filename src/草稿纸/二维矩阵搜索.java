package 草稿纸;

public class 二维矩阵搜索 {
    public static void main(String[] args) {


    }
    public static boolean halfFind(int l, int r, int[] nums,int target) {
        while(l<r){
            int mid = (l+r)>>1;
            if ((nums[mid]>=target)) r= mid;
            else  l = mid+1;
        }
        return nums[r]==target;
    }
}
