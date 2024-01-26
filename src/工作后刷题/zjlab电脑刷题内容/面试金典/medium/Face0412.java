package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import HOT100和TOP面试题.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  11:28
 * 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class Face0412 {

    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> helpMap = new HashMap<>();
        helpMap.put(0, 1);
        process(root, sum, 0, helpMap);
        return res;
    }

    /**
     * @param root
     * @param sum
     * @param now：到达当前root节点之前的路径和
     * @param map
     */
    private void process(TreeNode root, int sum, int now, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        //先更新now值，再计算路径数量
        int nowValue = now + root.val;
        res += map.getOrDefault(nowValue - sum, 0);
        map.put(now + root.val, map.getOrDefault(nowValue, 0) + 1);

        process(root.left, sum, now + root.val, map);
        process(root.right, sum, now + root.val, map);

        map.put(nowValue, map.get(nowValue) - 1);

    }
}
