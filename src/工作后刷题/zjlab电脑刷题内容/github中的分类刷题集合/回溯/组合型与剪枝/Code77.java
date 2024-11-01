package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.组合型与剪枝;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合 medium
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @author: ZBL
 * @date: 2024-11-01  19:56
 */
public class Code77 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        process(n,1,k,new ArrayList<>());
        return res;
    }

    private void process(int n, int start,int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n - (k - list.size()) + 1;i++) {
            list.add(i);
            process(n,i + 1,k,list);
            list.remove(list.size() - 1);
        }
    }
}
