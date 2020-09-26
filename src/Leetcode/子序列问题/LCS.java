package Leetcode.子序列问题;

/**
 * @author zbl
 * @version 1.0
 * @content:要求：给定字符串1和字符串2，要求找出两个字符串的最长公共子序列。
 * 例如，字符串1=“helloworld”，字符串2=“hwewegallgeo”,那么两者的最长公共子序列为“hello”
 * @date 2020/9/18 21:37
 */
public class LCS {


    public static String getLCS(String str1,String str2){
        if(str1==null || str1.length()==0 || str2==null || str2.length()==0)
            return "";
        int m=str1.length(),n=str2.length();
        int[][] dp=new int[m+1][n+1];//str1的前i个字符跟str2的前j个字符的lcs的最大长度
        String[][] paths=new String[m+1][n+1];//用来记录最大长度从前一步到这一步的路径
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int lefttop=dp[i-1][j-1];
                int left=dp[i][j-1];
                int top=dp[i-1][j];
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    lefttop++;
                }
                int maxtmp=Math.max(left,lefttop);
                dp[i][j]=Math.max(maxtmp,top);
                //填写标记数组
                if(dp[i][j]==lefttop){
                    paths[i][j]="lefttop";
                }else if(dp[i][j]==left){
                    paths[i][j]="left";
                }else{
                    paths[i][j]="top";
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        int maxlen=dp[m][n];//表示公共的最长公共子序列的长度
        int i=m,j=n;
        String indexStr="";//记录paths中的转换方式
        char currentCh=' ';//记录当前位置的字符
        int currentlen=0;//记录前i,j个字符的最长公共子串
        while(i>0 && j>0){
            currentlen=dp[i][j];
            indexStr=paths[i][j];
            currentCh=str1.charAt(i-1);//这里必须是str1，即：行所在的字符串
            if(indexStr.equals("lefttop")){
                i--;
                j--;
            }else if(indexStr.equals("left")){
                j--;
            }else{
                i--;
            }
            if(currentlen>dp[i][j]){//说明添加了一个字符
                sb.insert(0,currentCh);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String str1 = "cbagaewagb";
        String str2 = "cagewageba";
        System.out.println(getLCS(str1,str2));
    }

}
