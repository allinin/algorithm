package 工作后刷题.zjlab电脑刷题内容.和为k的子数组系列类似题目;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zbl
 * @Date:2024/2/7 18:00
 * 表现良好的最长时间段(medium)
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于8小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * 示例 1：
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * <p>
 * 示例 2：
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * 1 <= hours.length <= 104
 * 0 <= hours[i] <= 16
 */
public class Code1124 {

    //方法一：仿照和为k的子数组问题解决
    public int longestWPI(int[] hours) {
        int n = hours.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (hours[i] > 8 ? 1 : -1);
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (sum > 0) {
                ans = i + 1;
                continue;
            }
            if (map.containsKey(sum - 1)) {
                ans = Math.max(ans, i - map.get(sum - 1));
            }
        }
        return ans;
    }
}
