package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2023-12-19  17:27
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
 */
public class Code77 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        process(n,k,new ArrayList<>(),1);
        return res;
    }

    private void process(int n, int k, List<Integer> list, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //对i的范围进行剪枝
        for (int i = index; i <= n - k + list.size() + 1; i++) {
            list.add(i);
            process(n,k,list,i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code77().combine(1,1);
        for(List<Integer> list : lists) {
            for(Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
