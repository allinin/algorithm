package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 最长回文字串
 *
 * @author zbl
 * @create 2023-11-27 17:30
 */
public class Code5_manacher {

    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        String ans = "";
        for (int i = 0; i < len; i++) {
            //i为中心的情况
            int left = i, right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            String tmp = s.substring(left + 1, right);
            if (tmp.length() > ans.length()) {
                ans = tmp;
            }
            //无中心的情况
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            tmp = s.substring(left + 1, right);
            if (tmp.length() > ans.length()) {
                ans = tmp;
            }
        }
        return ans;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        String ans = "";
        boolean[][] dp = new boolean[len][len];//i-j位置的字串是否是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //以第i个字符结尾
        for (int i = 0; i < len; i++) {
            //从第i个字符开始往左遍历
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 3 || (i - j >= 3 && dp[j + 1][i - 1]))) {
                    dp[j][i] = true;
                    if (i - j + 1 > ans.length()) {
                        ans = s.substring(j, i + 1);
                    }
                }
            }
        }
        return ans;
    }

    //TODO manacher algorithm

    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] manaArr = new char[s.length() * 2 + 1];//构建manacher数组
        for (int i = 0; i < manaArr.length; i++) {
            manaArr[i] = i % 2 == 0 ? '#' : s.charAt(i / 2);
        }
        int[] ptArr = new int[manaArr.length];//回文半径数组
        int index = -1;//最右回文有边界对应的回文中心
        int pR = -1;//最右回文有边界
        int max = 1, startIndex = 0;
        for (int i = 0; i < manaArr.length; i++) {
            ptArr[i] = pR > i ? Math.min(ptArr[2 * index - i], pR - i) : 1;
            while (i - ptArr[i] >= 0 && i + ptArr[i] < manaArr.length) {
                if (manaArr[i - ptArr[i]] == manaArr[i + ptArr[i]]) {
                    ptArr[i]++;
                } else {
                    break;
                }
            }
            if (i + ptArr[i] > pR) {
                pR = i + ptArr[i];
                index = i;
            }
            if (max < ptArr[i]) {
                max = ptArr[i];
                //在字符串中的起点，原字符串中回文串的长度为max - 1
                startIndex = (i - max + 1) / 2;
            }

        }

        return s.substring(startIndex,startIndex + max - 1);
    }

}
