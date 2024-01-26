package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2024-01-16  10:21
 * 字母和数字
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 * <p>
 * 输入: ["A","A"]
 * <p>
 * 输出: []
 * 提示：
 * <p>
 * array.length <= 100000
 */
public class Face1705_DONE {


    //类似和为k的子数组问题，数字与字母相同，可以认为是和为0，其中字母认为是-1，数字认为是+1
    public String[] findLongestSubarray(String[] array) {
        //记录出现的sum和以及第一次出现的索引位置
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int ansLeft = -1, ansRight = -1, sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                int nowlen = i - map.get(sum);
                if (nowlen > maxLen) {
                    maxLen = nowlen;
                    ansLeft = map.get(sum) + 1;
                    ansRight = i;
                }
            } else {
                //第一次出现的时候记录索引位置
                map.put(sum, i);
            }
        }
        if (maxLen == 0) {
            return new String[0];
        }
        String[] ans = new String[ansRight - ansLeft + 1];
        for (int i = ansLeft; i <= ansRight; i++) {
            ans[i - ansLeft] = array[i];
        }
        return ans;
    }
}
