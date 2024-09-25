package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

/**
 * 找到最长的半重复子字符串 medium
 * 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
 * <p>
 * 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，"0010" 、"002020" 、"0123" 、"2002" 和 "54944" 是半重复字符串，而 "00101022"
 * （相邻的相同数字对是 00 和 22）和 "1101234883" （相邻的相同数字对是 11 和 88）不是半重复字符串。
 * <p>
 * 请你返回 s 中最长 半重复
 * 子字符串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "52233"
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 最长的半重复子字符串是 "5223"。整个字符串 "52233" 有两个相邻的相同数字对 22 和 33，但最多只能选取一个。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "5494"
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * s 是一个半重复字符串。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "1111111"
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 最长的半重复子字符串是 "11"。子字符串 "111" 有两个相邻的相同数字对，但最多允许选取一个。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '9'
 *
 * @author: ZBL
 * @date: 2024-09-20  20:00
 */
public class Code2730 {


    public static int longestSemiRepetitiveSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length(), left = 0, right = 0,ans = 0;
        char now = ' ', pre = 'a';
        int same = 0;
        while (right < len) {
            now = s.charAt(right++);
            if(now == pre) {
                same++;
                if(same > 1) {
                    while(s.charAt(left) != s.charAt(++left));
                    same--;
                }
            }
            pre = now;
            ans = Math.max(right - left,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "24489929009";
        System.out.println(longestSemiRepetitiveSubstring(s));
    }
}
