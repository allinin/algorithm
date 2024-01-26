package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Code17 {
    private String[] helpArray = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        process(digits,helpArray,new StringBuilder(),0,ans);
        return ans;
    }

    private void process(String digits, String[] helpArray, StringBuilder sb, int index, List<String> ans) {
        if (index == digits.length()) {
            String s = new String(sb);
            ans.add(s);
            return;
        }
        String target = helpArray[digits.charAt(index) - '0'];
        for(int i = 0;i < target.length();i++) {
            sb.append(target.charAt(i));
            process(digits,helpArray,sb,index + 1,ans);
            //回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Code17().letterCombinations("2");
        strings.forEach(p -> System.out.println(p));
    }

}
