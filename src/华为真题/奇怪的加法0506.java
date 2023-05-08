package 华为真题;

import java.util.*;
public class 奇怪的加法0506 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String str = scanner.next();
        String[] split = str.split("\\+");
     //   System.out.println(split[0]);
        String str1 = split[0], str2 = split[1];
        a = str.length();
        int len1 = str1.length(), len2 = a - 1 - len1;
        int len_f1 = str1.split("\\.")[0].length();
        int len_f2 = str2.split("\\.")[0].length();                                     //整数部分长度
        int len_a1 = len1 - 1 - len_f1, len_a2 = len2 - 1 - len_f2;                     //小数部分长度

        System.out.println(len_f1 + " " + len_f2 + " " + len_a1 + " " + len_a2);

        StringBuilder sb1 = new StringBuilder(str1), sb2 = new StringBuilder(str2);

        if (len_a1 == -1) {
            len_f1++;
            len_a1++;
            sb1.append(".");
        }

        if (len_a2 == -1) {
            len_f2++;
            len_a2++;
            sb2.append(".");
        }

        while (len_a1 != len_a2) {
            while (len_a1 < len_a2) {
                sb1.append(0);
                len_a1++;
            }
            while (len_a1 > len_a2) {
                sb2.append(0);
                len_a2++;
            }
        }

        while (len_f1 != len_f2) {
            while (len_f1 < len_f2) {
                sb1.insert(0, "0");
                len_f1++;
            }
            while (len_f1 > len_f2) {
                sb2.insert(0, "0");
                len_f2++;
            }
        }
//        System.out.println(sb1+" "+sb2);
        StringBuilder sb = new StringBuilder();
        sb1 = sb1.reverse();
        sb2 = sb2.reverse();

        int flag = 0;
        int cur = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("!!", 0);
        map.put("!@", 13);
        map.put("!#", 4);
        map.put("@@", 7);
        map.put("@#", 20);
        map.put("##", 5);

        for (int i = 0; i < sb1.length(); i++) {
            char ch = sb1.charAt(i);
            if (ch == '.') {
                sb.append(".");
            } else {
                if (ch == '!' || ch == '@' || ch == '#') {
                    String s = ch + "" + sb2.charAt(i);
                    String s1 = sb2.charAt(i) + "" + ch;
                    if (map.containsKey(s)) {
                        cur = map.get(s);
                    } else {
                        cur = map.get(s1);
                    }
                } else {
                    cur = ch - '0' + sb2.charAt(i) - '0';
                }
//                System.out.println(cur);
                cur = cur + flag;
                flag = cur / 10;
                cur = cur % 10;
                sb.append(cur);
            }
        }
        if (flag != 0) {
            sb.append(flag);
        }
        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.reverse());
    }
// !+! =0 !+@=13 !+#=4  @+@=7 @ +# =20 #+#=5
}

