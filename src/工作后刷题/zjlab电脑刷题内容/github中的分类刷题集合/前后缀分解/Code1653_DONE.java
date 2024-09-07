package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.前后缀分解;

/**
 * @Author: ZBL
 * @Date: 2024-02-01  17:12
 * 使字符串平衡的最少删除次数(medium)
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。
 * <p>
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，
 * 此时认为 s 是 平衡 的。
 * <p>
 * 请你返回使 s 平衡 的 最少 删除次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * <p>
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 要么是 'a' 要么是 'b'
 */
public class Code1653_DONE {

    //b不能出现在a的左侧，a不能出现在b的右侧。相当于不断的从s的某个位置画根线，线左边不能有b,右边不能有a
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = s.charAt(0) == 'b' ? 1 : 0;
        right[n - 1] = s.charAt(n - 1) == 'a' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1];
            if (s.charAt(i) == 'b') {
                left[i]++;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            if (s.charAt(i) == 'a') {
                right[i]++;
            }
        }
        int ans = n;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(left[i] + right[i + 1], ans);
        }
        ans = Math.min(ans, Math.min(left[n - 1], right[0]));
        return ans;
    }

    public int minimumDeletions2(String s) {
        int n = s.length(), rightA = 0, leftB = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }
        int ans = rightA;
        //从i处跟线，i位置的元素判为左边元素
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            ans = Math.min(ans, leftB + rightA);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Code1653_DONE().minimumDeletions("aababbab"));
    }
}
