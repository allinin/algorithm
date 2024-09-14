package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.子集型.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合 medium
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * @author: ZBL
 * @date: 2024-09-11  19:21
 */
public class Code17 {

    private String[] help = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return res;
        }
        process(digits,new StringBuffer(),0);
        return res;
    }

    private void process(String digits,StringBuffer sb,int idx) {
        if(idx == digits.length()) {
            res.add(new String(sb));
            return;
        }
        for(char c : help[digits.charAt(idx) - '0'].toCharArray()) {
            sb.append(c);
            process(digits,sb,idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
