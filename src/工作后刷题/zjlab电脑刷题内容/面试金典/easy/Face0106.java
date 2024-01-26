package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  09:00
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 */
public class Face0106 {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = S.length(), idx = 1, preIdx = 0;
        char pre = S.charAt(0), now = pre;
        while (idx < len) {
            now = S.charAt(idx);
            if (now != pre) {
                sb.append(pre).append((idx - preIdx));
                preIdx = idx;
                pre = now;
            }
            idx++;
        }
        sb.append(now).append(idx - preIdx);
        String res = sb.toString();
        return res.length() >= len ? S : res;
    }
}
;