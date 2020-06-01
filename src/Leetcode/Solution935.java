package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:国际象棋中的骑士可以按下图所示进行移动：

.


这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。

每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。

你能用这种方式拨出多少个不同的号码？

因为答案可能很大，所以输出答案模 10^9 + 7。



示例 1：

输入：1
输出：10

示例 2：

输入：2
输出：20

示例 3：

输入：3
输出：46

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/knight-dialer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/5/16 21:27
 */
public class Solution935 {
    private static int M=1000000007;
    public static  int knightDialer(int N) {
        int[][][] dp=new int[8][7][N];
        for(int i=2;i<6;i++){
            for(int j=2;j<5;j++){
                if(!((i==5 && j==2) || (i==5 && j==4)))
                    dp[i][j][0]=1;
            }
        }
        for(int k=1;k<N;k++){
            for(int i=2;i<6;i++){
                for(int j=2;j<5;j++){
                    if(!((i==5 && j==2) || (i==5 && j==4)))
                        dp[i][j][k] = (((dp[i - 2][j - 1][k - 1]%M + dp[i - 2][j + 1][k - 1]%M)%M +
                                (dp[i - 1][j - 2][k - 1]%M + dp[i - 1][j + 2][k - 1]%M)%M)%M +
                                ((dp[i + 1][j - 2][k - 1]%M + dp[i + 1][j + 2][k - 1]%M)%M +
                                        (dp[i + 2][j - 1][k - 1]%M + dp[i + 2][j + 1][k - 1]%M)%M)%M)%M;
                }
            }
        }
        int sum=0;
        sum=((((dp[2][2][N-1]+dp[2][3][N-1])%M+(dp[5][3][N-1]+dp[2][4][N-1])%M)%M+((dp[3][2][N-1]
                +dp[3][3][N-1])%M+(dp[3][4][N-1]+dp[4][2][N-1])%M)%M)%M+(dp[4][3][N-1]+dp[4][4][N-1])%M)%M;
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(knightDialer(3));
    }
}
