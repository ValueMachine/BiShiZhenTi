package 拼多多0418;

import java.util.Scanner;

public class 第二题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] cords = new int[n][2];
        for (int i = 0; i < n; i++) {
            cords[i][0] = sc.nextInt();
            cords[i][1] = sc.nextInt();
        }
        int resX1= -1;
        int resX2 = -1;
        int S  =0;
        for(int i=0;i<n;i++){
            for(int j= i;j<n;j++){
                if((cords[j][0]-cords[i][0]) *(cords[j][1]-cords[i][1]) >S ) {
                    S = (cords[j][0]-cords[i][0]) *(cords[j][1]-cords[i][1]);
                    resX1 = cords[i][0];
                    resX2 = cords[j][0];
                }
            }
        }
        System.out.println(resX1+" "+resX2);
    }
}
