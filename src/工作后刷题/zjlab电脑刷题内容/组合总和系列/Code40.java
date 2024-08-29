package 工作后刷题.zjlab电脑刷题内容.组合总和系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和II(medium)
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * @author: ZBL
 * @date: 2024-08-29  10:23
 */
public class Code40 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        boolean[] visited = new boolean[candidates.length];

        process(candidates, target, 0,0, new ArrayList<>(), visited);

        return res;
    }

    private void process(int[] candidates, int target, int index,int nowValue, List<Integer> list, boolean[] visited) {
        if (target == nowValue) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + nowValue > target) {
                break;
            }
            //重复值的情况,用来消除重复组合
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(candidates[i]);
            //i + 1表示从下一个位置开始选取元素，体现了每个元素只能使用一次
            process(candidates, target, i + 1,nowValue + candidates[i], list, visited);
            //回溯
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
