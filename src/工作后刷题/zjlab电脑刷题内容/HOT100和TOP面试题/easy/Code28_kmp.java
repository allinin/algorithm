package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class Code28_kmp {

    // TODO KMP算法，快速查找匹配字符串：如何在原字符串中快速匹配查找目标字符串 o(m+n)
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0, j = 0;
        for (; j < needle.length() && i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }
            }
        }
        return i == haystack.length() && j != needle.length() ? -1 : i - needle.length();
    }

    /**
     * 获取kmp算法的next数组，表示当haystack[i]!=needle[j]时，j的移动坐标。
     * todo getNext的结果也可以看做是字符串的前0个，前1个，前2个.....前n - 1个字符组成的子串的相同前后缀的长度
     *
     * @param needle
     * @return
     */
    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int k = -1;//表示当前j应该移动到的索引
        next[0] = k;
        int j = 0;
        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                next[++j] = ++k;
            } else {
                //此时k位置的值与j位置的值不相等，再次跳转
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Code28_kmp().strStr("leetcode", "leeto"));
    }
}
