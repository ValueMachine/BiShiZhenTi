package 华为;
import java.util.*;
 /*       输入数据有多组, 每行表示一组输入数据。
        每行的第一个整数为整数的个数n(1 <= n <= 100)。
        接下来n个正整数, 即需要求和的每个正整数。
        输出描述:
        每组数据输出求和的结果
        示例1
        输入
        复制
        4 1 2 3 4
        5 1 2 3 4 5
        输出
        复制
        10
        15*/
public class 输入输出3 {

        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextLine()){
                String[] s = sc.nextLine().split(" ");
                int sum = 0;
                for(int i = 1;i<s.length;i++){
                    sum += Integer.parseInt(s[i]);
                }
                System.out.println(sum);
            }
        }
}
