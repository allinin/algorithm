package 公司笔面试真题.虾皮面试;

/**
 * @author zbl
 * @version 1.0
 * @content: 求两个字符串的最长公共子串
 * @date 2020/8/17 18:39
 */
public class 两个字符串的最长公共子串 {

    public static String process(String str1,String str2){
        if(str1==null || str1.length()==0 || str2==null || str2.length()==0)
            return "";
        int n=str1.length();
        int m=str2.length();
        char[] chs1=str1.toCharArray();
        char[] chs2=str2.toCharArray();
        int[][] dp=new int[str1.length()][str2.length()];//以i,j结尾的最长公共子串的长度
        int end=0,length=0;
        for(int i=0;i<m;i++){
            if(chs1[0]==chs2[i]) dp[0][i]=1;
        }
        for(int i=0;i<n;i++){
            if(chs2[0]==chs1[i]) dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(chs1[i]==chs2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>length){
                        length=dp[i][j];
                        end=j;
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }
        int start=end-length+1;
        return str2.substring(start,end);



    }

    public static void main(String[] args) {
        String res=process("abractyeyt","dgdsaeactyey");
        System.out.println(res);
    }
}
