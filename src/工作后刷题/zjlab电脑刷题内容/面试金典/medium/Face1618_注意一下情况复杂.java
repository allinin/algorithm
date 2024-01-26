package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-15  10:13
 * 模式匹配
 * 你有两个字符串，即pattern和value。
 * pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），
 * 该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。
 * 编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 * <p>
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 * <p>
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 * <p>
 * 1 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class Face1618_注意一下情况复杂 {
    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 1) {
            return true;
        }
        int aNum = 0, bNum = 0, firstAIndex = -1, firstBIndex = -1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                aNum++;
                if (firstAIndex == -1) {
                    firstAIndex = i;
                }
            } else {
                bNum++;
                if (firstBIndex == -1) {
                    firstBIndex = i;
                }
            }
        }
        int len = value.length();
        if (bNum == 0 && (len / aNum) * aNum != len) {
            return false;
        }
        if (aNum == 0 && (len / bNum) * bNum != len) {
            return false;
        }
        //保证a先出现
        if ((firstAIndex > firstBIndex && firstBIndex != -1) || firstAIndex == -1) {
            int tmp = firstAIndex;
            firstAIndex = firstBIndex;
            firstBIndex = tmp;

            int tmp2 = aNum;
            aNum = bNum;
            bNum = tmp2;
            //将原pattern的a与b互换
            char[] chs = pattern.toCharArray();
            for(int i = 0;i < pattern.length();i++) {
                if(chs[i] == 'a') {
                    chs[i] = 'b';
                } else {
                    chs[i] = 'a';
                }
            }
            pattern = new String(chs);
        }
        //因为已经保证了a一定先出现，并且可能对pattern做了变换，所以只需要判断b是否出现即可
        if (bNum == 0) {
            String matchStr = value.substring(0, len / aNum);
            for (int i = len / aNum; i < len; i += len / aNum) {
                if (!value.substring(i, i + len / aNum).equals(matchStr)) {
                    return false;
                }
            }
            return true;
        }

        int aMatchMax = len / aNum;

        for (int i = 0; i <= aMatchMax; i++) {
            int bMatchNum = len - i * aNum;
            int bMathchLen = bMatchNum / bNum;
            if (bMathchLen * bNum != bMatchNum) {
                continue;
            }
            String aMathchStr = i == 0 ? "" : value.substring(0, i);
            String bMathchStr = bMathchLen == 0 ? "" : value.substring((firstBIndex - firstAIndex) * i,
                    (firstBIndex - firstAIndex) * i + bMathchLen);
            if (aMathchStr.equals(bMathchStr)) {
                continue;
            }

            boolean match = true;
            if (aMathchStr.equals("")) {
                for (int j = 0; j < len; j += bMathchLen) {
                    if (!value.substring(j, j + bMathchLen).equals(bMathchStr)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }

            } else if (bMathchStr.equals("")) {
                for (int j = 0; j < len; j += i) {
                    if (!value.substring(j, j + i).equals(aMathchStr)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }

            } else {
                int idx = 0;
                for (int j = 0; j < pattern.length() && idx < value.length(); j++) {
                    if (pattern.charAt(j) == 'a') {
                        if (!value.substring(idx, idx + i).equals(aMathchStr)) {
                            match = false;
                            break;
                        }
                        idx += i;
                    }
                    if (pattern.charAt(j) == 'b') {
                        if (!value.substring(idx, idx + bMathchLen).equals(bMathchStr)) {
                            match = false;
                            break;
                        }
                        idx += bMathchLen;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String patter = "baabab";
        String value = "eimmieimmieeimmiee";
        System.out.println(new Face1618_注意一下情况复杂().patternMatching(patter,value));
    }

}
