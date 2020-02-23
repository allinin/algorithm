
package 左神算法.进阶班二.第一章;

/**
 * @author zbl
 * @version 1.0
 * @content:给一个字符串str,代表一个整数，找到除了这个数之外，绝对值和这个数相差最小的回文数。假设字符串str
 * 一定能变成long类型。
 * @date 2020/2/13 16:44
 */
public class Problem07_FindTheClosestPalindrome {


    public static String nearestPalindromic(String n) {
        Long num = Long.valueOf(n);
        Long raw = getRawPalindrome(n);
        Long big = raw > num ? raw : getBigPalindrome(raw);
        Long small = raw < num ? raw : getSmallPalindrome(raw);
        return String.valueOf(big - num >= num - small ? small : big);
    }

    public static Long getRawPalindrome(String n) {
        char[] chs = n.toCharArray();
        int len = chs.length;
        for (int i = 0; i < len / 2; i++) {
            chs[len - 1 - i] = chs[i];
        }
        return Long.valueOf(String.valueOf(chs));
    }

    public static Long getBigPalindrome(Long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length + 1];
        res[0] = '0';
        for (int i = 0; i < chs.length; i++) {
            res[i + 1] = chs[i];
        }
        int size = chs.length;
        for (int j = (size - 1) / 2 + 1; j >= 0; j--) {
            if (++res[j] > '9') {
                res[j] = '0';
            } else {
                break;
            }
        }
        int offset = res[0] == '1' ? 1 : 0;
        size = res.length;
        for (int i = size - 1; i >= (size + offset) / 2; i--) {
            res[i] = res[size - i - offset];
        }
        return Long.valueOf(String.valueOf(res));
    }

    public static Long getSmallPalindrome(Long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length];
        int size = res.length;
        for (int i = 0; i < size; i++) {
            res[i] = chs[i];
        }
        for (int j = (size - 1) / 2; j >= 0; j--) {
            if (--res[j] < '0') {
                res[j] = '9';
            } else {
                break;
            }
        }
        if (res[0] == '0') {
            res = new char[size - 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = '9';
            }
            return size == 1 ? 0 : Long.parseLong(String.valueOf(res));
        }
        for (int k = 0; k < size / 2; k++) {
            res[size - 1 - k] = res[k];
        }
        return Long.valueOf(String.valueOf(res));
    }

}
