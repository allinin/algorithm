package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 */
public class Code39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        //从小到达排序，便于剪枝
        Arrays.sort(candidates);
        process(candidates,target,0,0,res,new ArrayList<>());
        return res;
    }

    private void process(int[] candidates, int target, int nowSum, int index, List<List<Integer>> res, List<Integer> tmp) {
        if (nowSum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        //从第index个元素开始检索
        for (int i = index; i < candidates.length; i++) {
            if (nowSum + candidates[i] > target) {
                break;
            }
            nowSum += candidates[i];
            tmp.add(candidates[i]);
            //因为元素可以重用，所以下一轮检索的起始位置仍然为i
            process(candidates,target,nowSum,i,res,tmp);
            nowSum -= candidates[i];
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,5};
        List<List<Integer>> lists = new Code39().combinationSum(candidates, 8);
        for (List<Integer> list : lists) {
            for(Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
}
