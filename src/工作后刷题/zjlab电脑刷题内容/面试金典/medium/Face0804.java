package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-08  14:53
 * 幂集。
 * 编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Face0804 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i <= nums.length; i++) {
            process(i,nums,new ArrayList<>(),0);
        }
        return res;
    }

    private void process(int len, int[] nums, List<Integer> list, int index) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            process(len, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
