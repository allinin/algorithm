package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class Code49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        if(strs == null || strs.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        for(String str: strs) {
            int[] visited = new int[26];
            for(char c : str.toCharArray()) {
                visited[c - 'a']++;
            }
            String key = "";
            for(int i = 0;i < 26;i++) {
                if(visited[i] != 0) {
                    key += (i +"_"+visited[i]);
                }
            }
            List<String> val = map.getOrDefault(key, new ArrayList<>());
            val.add(str);
            map.put(key,val);
        }
        for(List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Code49().groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

}
