package 工作后刷题.zjlab电脑刷题内容.删列造序系列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  10:21
 * <p>
 * 删列造序III(hard)
 * 给定由 n 个小写字母字符串组成的数组 strs ，其中每个字符串长度相等。
 * <p>
 * 选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
 * <p>
 * 比如，有 strs = ["abcdef","uvwxyz"] ，删除索引序列 {0, 2, 3} ，删除后为 ["bef", "vyz"] 。
 * <p>
 * 假设，我们选择了一组删除索引 answer ，那么在执行删除操作之后，最终得到的数组的行中的 每个元素 都是按字典序排列的（即 (strs[0][0] <= strs[0][1] <= ... <= strs[0][strs[0].length - 1]) 和 (strs[1][0] <= strs[1][1] <= ... <= strs[1][strs[1].length - 1]) ，依此类推）。
 * <p>
 * 请返回 answer.length 的最小可能值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["babca","bbazb"]
 * 输出：3
 * 解释：
 * 删除 0、1 和 4 这三列后，最终得到的数组是 strs = ["bc", "az"]。
 * 这两行是分别按字典序排列的（即，strs[0][0] <= strs[0][1] 且 strs[1][0] <= strs[1][1]）。
 * 注意，strs[0] > strs[1] —— 数组 strs 不一定是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：strs = ["edcba"]
 * 输出：4
 * 解释：如果删除的列少于 4 列，则剩下的行都不会按字典序排列。
 * 示例 3：
 * <p>
 * 输入：strs = ["ghi","def","abc"]
 * 输出：0
 * 解释：所有行都已按字典序排列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 100
 * strs[i] 由小写英文字母组成
 */
public class Code960_DONE {


    //非最小结尾子数组的方式通过,相当于求公共的最长递增子序列
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int[] dp = new int[len]; //表示以第i个字符结尾的非递减序列的最大长度
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i = 0;i < len;i++) {
            for(int j = 0;j < i;j++) {
                boolean flag = true;
                //只有当strs中所有的字符串都满足i位置的字符不小于j位置的字符的时候才计算
                for(String str : strs) {
                    if(str.charAt(i) < str.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                //此时第i列在所有的字符串中都满足条件，将可以选择第i列
                if(flag) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return len - ans;
    }

        //TODO 最小结尾子数组的方式没有通过
        public int minDeletionSize2(String[] strs) {
            Set<Integer> deleteIndexs = new HashSet<>();
            for (String str : strs) {
                int[] dp = new int[str.length() + 1];
                char[] dpc = new char[str.length() + 1];
                Arrays.fill(dp, str.length());
                Arrays.fill(dpc,'z');
                dp[1] = 0;
                dpc[1] = str.charAt(0);
                int len = 1;
                Set<Integer> set = new HashSet<>();
                set.add(0);
                for (int i = 1; i < str.length(); i++) {
                    set.add(i);
                    int left = 1, right = len + 1;
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (str.charAt(i) >= dpc[mid]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    if (left == len + 1) {
                        len++;
                        dp[len] = i;
                        dpc[len] = str.charAt(i);
                    } else {
                        if (dpc[left] > str.charAt(i)) {
                            dp[left] = i;
                            dpc[left] = str.charAt(i);
                        }
                    }
                }
                for (int i = 1; i <= len; i++) {
                    if (dp[i] != str.length()) {
                        set.remove(dp[i]);
                    }
                }
                deleteIndexs.addAll(set);
            }
            return deleteIndexs.size();
        }


    public static void main(String[] args) {
        System.out.println(new Code960_DONE().minDeletionSize(new String[] {"babab","babbb","bbbba"}));
    }
}
