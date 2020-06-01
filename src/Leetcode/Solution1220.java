package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/5/16 22:51
 */
public class Solution1220 {

    private static int M=1000000007;
    private static int[][] dp;
    private static String[] strs={"a","e","i","o","u"};
    public static int countVowelPermutation(int n) {
        if(n==1)
            return 5;
        return process("",n,0);
    }
    //递归的方式
    private static int process(String s,int n,int position){
        if(position==n)
            return 1;
        int count=0;
        if(position==0){
            for(int i=0;i<5;i++){
                count=(count+process(strs[i],n,1)%M)%M;
            }
            return count;
        }else{
            if(s.charAt(position-1)=='a'){
                count=(count+process(s+"e",n,position+1)%M)%M;
            }
            if(s.charAt(position-1)=='e'){
                count=((count+process(s+"a",n,position+1)%M)%M+process(s+"i",n,position+1)%M)%M;
            }
            if(s.charAt(position-1)=='i'){
                count=((count+process(s+"a",n,position+1)%M)%M+((process(s+"e",n,position+1)%M+process(s+"o",n,position+1)%M)%M+process(s+"u",n,position+1)%M)%M)%M;
            }
            if(s.charAt(position-1)=='o'){
                count=((count+process(s+"i",n,position+1)%M)%M+process(s+"u",n,position+1)%M)%M;
            }
            if(s.charAt(position-1)=='u'){
                count=(count+process(s+"a",n,position+1)%M)%M;
            }
        }
        return count;
    }

    //动态规划
    public static int countVowelPermutation2(int n) {
        if(n==1)
            return 5;
        dp=new int[n+1][5];//表示长度为i,以a,e,i,o,u结尾的字符串的种类
        //dp[i][0]:表示长度为i,已a结尾的字符串的种类数，以此类推
        dp[1][0]=1;
        dp[1][1]=1;
        dp[1][2]=1;
        dp[1][3]=1;
        dp[1][4]=1;
        for(int i=2;i<=n;i++){
            dp[i][0]=((dp[i-1][1]+dp[i-1][2])%M+dp[i-1][4])%M;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%M;
            dp[i][2]=(dp[i-1][1]+dp[i-1][3])%M;
            dp[i][3]=dp[i-1][2];
            dp[i][4]=(dp[i-1][2]+dp[i-1][3])%M;
        }
        return ((dp[n][0]+dp[n][1])%M+((dp[n][2]+dp[n][3])%M+dp[n][4])%M)%M;
    }

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(80));
        System.out.println(countVowelPermutation2(80));
    }
}
