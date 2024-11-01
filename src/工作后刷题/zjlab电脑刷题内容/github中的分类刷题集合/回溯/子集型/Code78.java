package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.子集型;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集 medium
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author: ZBL
 * @date: 2024-11-01  19:27
 */
public class Code78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            process(nums, 0, i, new ArrayList<>());
        }
        return res;
    }

    private void process(int[] nums, int start, int size, List<Integer> list) {
        if (list.size() == size) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            process(nums, i + 1, size, list);
            list.remove(list.size() - 1);
        }
    }

}
