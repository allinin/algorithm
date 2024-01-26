package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
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
 */
public class Code46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        process(nums,new ArrayList<>(),res,new boolean[nums.length]);
        return res;
    }

    private void process(int[] nums,List<Integer> list,List<List<Integer>> res,boolean[] visited) {
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            process(nums,list,res,visited);
            //回溯
            visited[i] = false;
            list.remove(list.size() - 1);
        }

    }

}
