package 爆刷leetcode;
import java.util.*;

public class 复原IP {
    public static void main(String[] args) {
        String s= "0000";
        System.out.println(restoreIpAddresses(s));
    }
        public static List<String> restoreIpAddresses(String s) {
            dfs(0,0,new String[4],s);
            return res;
        }
        static String to_String(String[] segments){
            StringBuilder sb = new StringBuilder();
         for(int i =0;i<3;i++)sb.append(segments[i]+".");
         sb.append(segments[3]);
            return sb.toString();
        }
        static Boolean check(String s){
            return(s.charAt(0)!='0'||s.equals("0") )&& Integer.parseInt(s)<256;
        }
        static List<String> res = new LinkedList();
        static void dfs(int index, int segmengId, String[]segments , String s) {
            if (segmengId == 4 || index == s.length()) {
                if (segmengId == 4 && index == s.length()) {
                    res.add(to_String(segments));
                }
                return;
            }
            for (int i = 1; i <= 3; i++) {
                if (index + i > s.length()) return ;
                String sub = s.substring(index, index + i);
                if (check(sub)) {
                    segments[segmengId] = sub;
                    dfs(index + i, segmengId + 1, segments, s);
                }
            }
        }
}

