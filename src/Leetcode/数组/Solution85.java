package Leetcode.数组;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
["1","0","1","0","0"],
["1","0","1","1","1"],
["1","1","1","1","1"],
["1","0","0","1","0"]
]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-rectangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/8/31 20:06
 */
public class Solution85 {

    public static int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int res=0;
        for(int i=0;i<m;i++){//从第i行开始
            int[] help=new int[n];
            Arrays.fill(help,-1);
            for(int j=i;j<m;j++){//计算i-m行的矩形面积
                for(int k=0;k<n;k++){
                    if(matrix[j][k]=='0' || help[k]==0){
                        help[k]=0;
                    }else{
                        help[k]=help[k]==-1 ? 0: help[k];
                        help[k]+=matrix[j][k]-'0';
                    }
                }
                int ans=process(help);
                res=Math.max(res,ans);
            }
        }
        return res;

    }
    //返回数组arr中最大矩形的面积
    private static int process(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                continue;
            if(i>=1){
                dp[i]=arr[i]+dp[i-1];
                res=Math.max(res,dp[i]);
            }else{
                dp[i]=arr[i];
                res=Math.max(res,dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
