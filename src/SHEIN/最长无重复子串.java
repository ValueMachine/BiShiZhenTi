package SHEIN;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 最长无重复子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  input = sc.nextLine();
        int count = getMax(input);
        boolean[] repeat = new boolean[128];
        List<String> list = new LinkedList<>();
            for (int i = 0; i <input.length() ; i++) {
                for (int j= i; j < input.length(); j++) {
                    if (!repeat[input.charAt(j)]){
                       list.add(String.valueOf(input.charAt(j)));
                        repeat[input.charAt(j)] = true;
                    }else  break;
                }
            }

       // String[] res = new String[count];
        /*for (int i = 0; i < count; i++) {
            res[i] = list.get(i);
        }*/
        String[] res =  list.toArray(new String[0]);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    static int getMax(String s){
        boolean[] occ = new boolean[128];
        int max = 0;
        for (int l=0,r=0;r<s.length();r++){
            while(l<=r&& occ[s.charAt(r)])  occ[s.charAt(l++)] = false;
            occ[s.charAt(r)] = true;
            max = Math.max(max,r-l+1);
        }
        return max;
    }

}
