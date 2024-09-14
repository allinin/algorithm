package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.排列型.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 全排列 medium
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * @author: ZBL
 * @date: 2024-09-11  19:32
 */
public class Code46 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        process(nums,new boolean[nums.length],new ArrayList<>());
        return res;
    }

    private void process(int[] nums,boolean[] visited,List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            process(nums,visited,list);
            visited[i] = false;
            list.remove(list.size() - 1);

        }
    }
}
