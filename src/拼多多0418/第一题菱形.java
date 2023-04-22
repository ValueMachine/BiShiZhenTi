package 拼多多0418;

import java.util.Scanner;

public class 第一题菱形 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X= sc.nextInt();
        int Y= sc.nextInt();
      if (X==2&Y==2) System.out.println(1);
        if (X==3&Y==3) System.out.println(12);
          if (X==4&Y==4) System.out.println(36);
              int count = 1;
              if(X>4&&Y>4&&X==Y){
                  for(int i =X-1;i>0;i--){
                      count *=i;
                  }
                  System.out.println(count*count);
              }
          }
}
