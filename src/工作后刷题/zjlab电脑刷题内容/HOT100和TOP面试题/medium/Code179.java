package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-25  15:35
 * <p>
 * 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */


public class Code179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            //直接a + b与b + a进行比较即可
           String s1 = a + b;
           String s2 = b + a;
           return s2.compareTo(s1);
        });
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans += strs[i];
        }
        return ans.charAt(0) == '0' ? "0" : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code179().largestNumber(new int[]{34323,3432}));
    }
}
