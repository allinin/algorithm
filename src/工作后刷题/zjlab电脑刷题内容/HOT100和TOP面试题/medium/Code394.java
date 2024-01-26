package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class Code394 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        int num = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            //数字
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c >= 'a' && c <= 'z') {
                res.append(c);
            } else {
                //遇到了括号
                String[] tmp = process(index, num, s);
                index = Integer.valueOf(tmp[0]);
                res.append(tmp[1]);
                num = 0;
            }
        }
        return res.toString();
    }

    private String[] process(int index, int num, String s) {
        String[] res = new String[2];
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int tmpNum = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            //数字
            if (c >= '0' && c <= '9') {
                tmpNum = tmpNum * 10 + c - '0';
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '[') {
                //遇到了括号
                String[] tmp = process(index, tmpNum, s);
                index = Integer.valueOf(tmp[0]);
                sb.append(tmp[1]);
                tmpNum = 0;
            } else if (c == ']') {
                for (int i = 0; i < num; i++) {
                    ans.append(sb);
                }
                res[0] = index+"";
                res[1] = ans.toString();
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code394().decodeString("3[a]2[bc]"));
    }
}
