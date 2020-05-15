package 公司真题;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:链接：https://www.nowcoder.com/questionTerminal/2e2510b2e41e4d3b922416e51afc077b
来源：牛客网

给出两个字符串，分别是模式串P和目标串T，判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0。
模式串中‘？’可以匹配目标串中的任何字符，模式串中的 ’*’可以匹配目标串中的任何长度的串，
模式串的其它字符必须和目标串的字符匹配。例如P=a?b，T=acb，则P 和 T 匹配。
 * @date 2020/4/2 17:25
 */
public class Test3 {

    public static int process(String s,String p){
        int m=s.length();//匹配数组长度
        int n=p.length();//模式数组长度
        boolean[] [] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++) dp[0][i]=dp[0][i-1] && p.charAt(i)=='*';

        for(int i=1;i<=m;i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i-1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }


//        int m = s.length(), n = p.length();
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        dp[0][0] = true;
//        for(int i = 1; i <= n; i++) dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
//        for(int i = 1; i <= m; i++){
//            for(int j = 1; j <= n; j++){
//                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
//                    dp[i][j] = dp[i - 1][j - 1];
//                }
//                if(p.charAt(j - 1) == '*'){
//                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//                }
//            }
//        }
        return dp[m][n] ? 1:0;
    }

    public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);
            String p = sc.next();
            String s = sc.next();
            // System.out.println(s + " - " + p);
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for(int i = 1; i <= n; i++) dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    if(p.charAt(j - 1) == '*'){
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
            System.out.println((dp[m][n] ? 1 : 0));
        System.out.println(process(s,p));
    }
}
