package Leetcode.LongestCommonSubString;

public class LongestCommonSubstring {
    public static void main(String[] args) {
       String s="fgvb";
       String t="vb";
        String s1 = longestCommonSubstring(s, t);
        System.out.println(s1);

    }

    public static String longestCommonSubstring(String s,String t)
    {
        int m=s.length();
        int n=t.length();
        int[][]arr=new int[m][n];
        int len=0;
        int maxEnd=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s.charAt(i)==t.charAt(j))
                {
                    if(i==0||j==0)
                    {
                        arr[i][j]=1;
                    }
                    else {
                        arr[i][j]=arr[i-1][j-1]+1;//记录了公共子串的长度
                    }
                }

                if(arr[i][j]>len)
                {
                    len=arr[i][j];
                    maxEnd=i;//以i位置结尾的字符
                }
            }
        }
        return s.substring(maxEnd-len+1,maxEnd+1);

    }
}
