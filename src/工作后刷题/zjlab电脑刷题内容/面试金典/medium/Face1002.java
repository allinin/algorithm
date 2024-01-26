package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  18:53
 * <p>
 * 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Face1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;

    }
}
