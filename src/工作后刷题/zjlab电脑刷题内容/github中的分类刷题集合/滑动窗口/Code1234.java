package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

/**
 * @Author: ZBL
 * @Date: 2024-01-30  09:06
 * 替换字串得到平衡字符串(medium)
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 * <p>
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 * <p>
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 * <p>
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 */
public class Code1234 {
    public int balancedString(String s) {
        int n = s.length();
        int targetNum = n / 4;
        int[] help = new int[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            help[c - 'A']++;
        }
        if (check(help, targetNum)) {
            return 0;
        }
        int right = 0, left = 0, ans = n;
        //整个字符串分为移除替换部分与剩余部分，剩余的部分满足:各个字符出现的次数<=targetNum
        while (right < n) {
            char c = chs[right++];
            help[c - 'A']--;
            while (check(help, targetNum)) {
                ans = Math.min(ans, right - left);
                help[chs[left++] - 'A']++;
            }
        }
        return ans == n ? 0 : ans;
    }

    private boolean check(int[] help, int target) {
        return help['W' - 'A'] <= target && help['Q' - 'A'] <= target
                && help['R' - 'A'] <= target && help['E' - 'A'] <= target;
    }

    public static void main(String[] args) {
        String s = "WQWRQQQW";
        System.out.println(new Code1234().balancedString(s));
    }
}
