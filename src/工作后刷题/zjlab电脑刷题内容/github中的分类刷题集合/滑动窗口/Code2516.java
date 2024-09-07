package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

/**
 * @Author: ZBL
 * @Date: 2024-01-26  12:30
 * 每种字符最少取k个(medium)
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，
 * 你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * <p>
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabaaaacaabc", k = 2
 * 输出：8
 * 解释：
 * 从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
 * 从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
 * 共需要 3 + 5 = 8 分钟。
 * 可以证明需要的最少分钟数是 8 。
 * 示例 2：
 * <p>
 * 输入：s = "a", k = 1
 * 输出：-1
 * 解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由字母 'a'、'b'、'c' 组成
 * 0 <= k <= s.length
 */
public class Code2516 {

    //与1658类似
    public int takeCharacters(String s, int k) {
        if (s.length() < 3 * k) {
            return -1;
        }
        int n = s.length();
        int[] numHelp = new int[3];
        for (char c : s.toCharArray()) {
            numHelp[c - 'a']++;
        }
        //取走左右字符后剩下的满足字符满足的最大数量
        for (int i = 0; i < numHelp.length; i++) {
            numHelp[i] -= k;
            if (numHelp[i] < 0) {
                return -1;
            }
        }
        int left = 0, right = 0, ans = 0;
        boolean match = true;
        while (right < n) {
            char c = s.charAt(right++);
            if (--numHelp[c - 'a'] < 0) {
                match = false;
            }

            while (!match) {
                char leftCh = s.charAt(left++);
                if (++numHelp[leftCh - 'a'] == 0) {
                    match = true;
                }
            }

            ans = Math.max(ans, right - left);
        }
        return n - ans;
    }
}
