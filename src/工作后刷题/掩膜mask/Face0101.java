package 工作后刷题.掩膜mask;

/**
 * @Author:zbl
 * @Date:2024/1/3 21:39
 * <p>
 * 判断字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 */
public class Face0101 {

    public boolean isUnique(String astr) {
        //因为字符仅包含26个小写字符，可以使用一个int类型的掩膜的各个位来表示字符是否出现过
        int mask = 0;
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            int bit = 1 << (c - 'a');
            if ((mask & bit) != 0) {
                return false;
            }
            mask |= bit;
        }
        return true;
    }
}
