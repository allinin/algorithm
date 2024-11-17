package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.区间dp.hard;

import java.util.Arrays;

/**
 * 扰乱字符串 hard
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 * 示例 2：
 * <p>
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 *
 * @author: ZBL
 * @date: 2024-11-15  20:41
 */
public class Code87_done {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int[] help = new int[26];
        for (char c : s1.toCharArray()) {
            help[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            //存在不相等的字符，直接返回false
            if (--help[c - 'a'] < 0) {
                return false;
            }
        }
        if (len == 1) {
            return true;
        }
        Arrays.fill(help, 0);
        boolean[][][] dp = new boolean[len][len][len + 1];//从s1 i位置开始的m个字符与从s2 j位置开始的m个字符能否扰乱
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j][1] = true;
                }
            }
        }
        //区间长度
        for (int range = 2; range <= len; range++) {
            for (int i = 0; i < len - range + 1; i++) {
                for (int j = 0; j < len - range + 1; j++) {
                    for (int k = 1; k < range; k++) {
                        //不交换
                        if (dp[i][j][k] && dp[i + k][j + k][range - k]) {
                            dp[i][j][range] = true;
                            break;
                        }
                        //交换
                        if(dp[i][j + range - k][k] && dp[i + k][j][range - k]) {
                            dp[i][j][range] = true;
                            break;
                        }

                    }
                }
            }

        }


        return dp[0][0][len];
    }

    public static void main(String[] args) {
        System.out.println(new Code87_done().isScramble("tgrea", "rgaet"));
    }
}
