package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Code78 {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        if(nums == null || nums.length == 0) {
            return res;
        }
        for(int i = 1;i <= nums.length;i++) {
            process(nums,i,0,0,new ArrayList<>());
        }
        return res;
    }
    private void process(int[] nums,int targetLen,int nowLen,int index,List<Integer>list) {
        if(nowLen == targetLen) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i < nums.length;i++) {
            list.add(nums[i]);
            process(nums,targetLen,nowLen + 1,i + 1,list);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> subsets = new Code78().subsets(arr);
        for(List<Integer> list : subsets) {
            list.forEach(p -> System.out.print(p + " "));
            System.out.println();
        }

    }

}
