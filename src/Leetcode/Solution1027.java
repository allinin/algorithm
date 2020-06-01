package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/5/15 17:50
 */
public class Solution1027 {

    //
    public static int longestArithSeqLength(int[] A) {
        int len=A.length;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            min=Math.min(min,A[i]);
            max=Math.max(max,A[i]);
        }
        int[][] dp1=new int[max-min+1][len+1];//差为i,前j个元素的等差数列的长度
        int[][] dp2=new int[max-min+1][len+1];
        for(int i=0;i<=max-min;i++){
            for(int j=1;j<=len;j++){
                dp1[i][j]=1;
                dp2[i][j]=1;
            }

        }

        int res=1;
        for(int i=0;i<=max-min;i++){
            for(int j=2;j<=len;j++ ){
                for(int k=1;k<j;k++){
                    if(A[j-1]-A[k-1]==i){
                        dp1[i][j]=dp1[i][k]+1;
                        res=Math.max(res,dp1[i][j]);
                    }
                    if(A[j-1]-A[k-1]==-i){
                        dp2[i][j]=dp2[i][k]+1;
                        res=Math.max(res,dp2[i][j]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{9,4,7,2,10};
        System.out.println(longestArithSeqLength(arr));
    }
}
