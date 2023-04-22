package 爆刷leetcode;

public class 最大回文数 {

        public String largestPalindromic(String num) {
            int[] count = new int[10];
            for(int i=0;i<num.length();i++){
                count[num.charAt(i)-'0']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=9;i>=0;i--){
                if((count[i]%2 ==0 &&i!=0 && count[i]>0) ||
                (i==0 && count[i] %2 ==0  && count[i] >0 )){
                    while(count[i]>1){
                        sb.append(i);
                        count[i] -= 2;
                    }
                }
                if((count[i] %2 ==1 &&i!=0 && count[i]>0)  ||
                (i==0 && count[i] %2 ==1 && count[i] >0 )){
                    while(count[i]>0){
                        sb.append(i);
                        count[i] -= 2;
                    }
                }
            }
            StringBuilder sb2 = sb.reverse();
            for (int i = 9; i >=0 ; i--) {
                if (count[i]==1){
                    sb.append(i);
                    break;
                }
            }
            sb.append(sb2);
            return sb.length()==0? "0" :sb.toString();
        }

}
