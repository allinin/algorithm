package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  09:31
 * <p>
 * 字符串轮转
 * <p>
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * 提示：
 * <p>
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 */
public class Face0109_pay_attention {

    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len2 != len1) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        //如果s2是s1的轮转，则一定是二者长度相等，并且将s1添加到s1末尾组成的新字符串一定包含s2
        return (s1 + s1).contains(s2);
    }
}
