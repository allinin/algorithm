package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 * 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class Code72_DONE {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp1 = new int[n + 1];//代表前一轮的操作
        //用word1的前0个字符匹配word2的前i个字符的操作数
        for (int i = 1; i <= n; i++) {
            dp1[i] = i;
        }
        int[] dp2 = new int[n + 1];//代表当前轮的操作
        for (int i = 1; i <= m; i++) {
            //当前轮操作时将dp2置0
            Arrays.fill(dp2,0);
            dp2[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //忽略该位置的值或者删除word1 i位置的值或者删除word2 j 位置的值(刪除等价与插入)
                    dp2[j] = Math.min(dp1[j - 1],Math.min(dp1[j],dp2[j - 1]) + 1);
                } else {
                    //替换或者删除
                    dp2[j] = Math.min(dp1[j - 1],Math.min(dp1[j],dp2[j - 1])) + 1;
                }
            }
            //下一轮操作之前，将dp2的值赋值给dp1
            for(int j = 0;j <= n;j++) {
                dp1[j] = dp2[j];
            }
        }
        return dp1[n];
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length(),n = word2.length();
        int[][] dp = new int[m + 1][n + 1];//word1的前i个字符组成的单词转化成word2的前j个字符组成的字符所需要的最少操作数
        for(int i = 1;i <= n;i++) {
            dp[0][i] = i;
        }
        for(int i = 1;i <= m;i++) {
            dp[i][0] = i;
        }
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <=n;j++) {
                //不管该位置的值是否相等，都可以替换或者插入，删除使得该位置的值相等
                dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1])) + 1;
                //如果相等，则是可以不考虑i,j位置的值，或者是替换删除操作
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Code72_DONE().minDistance("intention","execution"));
    }
}
