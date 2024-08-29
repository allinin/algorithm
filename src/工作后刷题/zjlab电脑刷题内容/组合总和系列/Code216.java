package 工作后刷题.zjlab电脑刷题内容.组合总和系列;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和III(medium)
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 *
 * @author: ZBL
 * @date: 2024-08-29  10:24
 */
public class Code216 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        process(n, 0, k, 1, new ArrayList<>());
        return res;
    }

    private void process(int targetValue, int nowValue, int k, int index, List<Integer> list) {
        if (nowValue == targetValue && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (i + nowValue > targetValue || list.size() >= k) {
                break;
            }
            list.add(i);
            process(targetValue, nowValue + i, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
