package algorithm.kmp;

import java.rmi.UnexpectedException;

public class KmpDemo {
    public static void main(String[] args) {
//        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
//        String str2 = "尚硅谷你尚硅你";
//        int index = violenceMatch(str1, str2);
//        System.out.println("index=" + index);
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext("ABCDABD");
        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15了
    }

    public static int violenceMatch(String str1,String str2)
    {   char[]s1=str1.toCharArray();
        char[]s2=str2.toCharArray();
        int n=str1.length();
        int m=str2.length();
        int i=0,j=0;
        while(i<n && j<m)
        {
            if(s1[i]==s2[j])
            {
                j++;
                i++;
            }else {

                i=i-j+1;
                j=0;
            }
        }
        if(j==m)
        {
            return i-j;
        }else {
            return  -1;
        }
    }

    public static int kmpSearch(String str1,String str2,int[]next)
    {
        //遍历
        for(int i=0,j=0;i<str1.length();i++)
        {
            //需要处理str1.charAt(i)!= str2.charAt（j),去调整j的大小
           while(j>0 && str1.charAt(i)!=str2.charAt(j))
            {
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j))
            {
                j++;
            }
            if(j==str2.length())
            {
                return i-j+1;
            }
        }
        return -1;
    }
    public static int[] kmpNext(String dest)
    {
        int len=dest.length();
        int[] next=new int[len];
        next[0]=0;
        for(int i=1,j=0;i<len;i++)
        {    //j记录前缀位置，i记录后缀位置
            while(j>0 && dest.charAt(i)!=dest.charAt(j))
            {
                j=next[j-1];
            }
            if(dest.charAt(i)==dest.charAt(j))
            {
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
