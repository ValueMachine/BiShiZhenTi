package 华为20230426;

import java.util.*;

public class 第二题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int count = sc.nextInt();
        int[][] options = new int[count][2];
        for (int i = 0; i < count; i++) {
            options[i][0] = sc.nextInt();
            options[i][1] =sc.nextInt();
        }
        int n = end-start+1;
        Deque<Integer> q= new LinkedList<>();
        for (int i=start;i<=n;i++){
            q.addLast(i);
        }

        Map<Integer,Integer>map = new HashMap<>();
        List wq = new LinkedList<>();
        int index=0;
        for (int i = 0; i < count; i++) {
            if (options[i][0]==1)  {
                int  wqlength = options[i][1];
                while(index<wqlength){
                    wq.add(index++,options[i][1]);
                    q.pollFirst();
                }
            }
               else if (options[i][0]==2) {
                wq.add(index++,options[i][1]);


                }
                    else if (options[i][0]==3)  {

                    }
        }
        System.out.println(q.peekFirst());
    }






}
