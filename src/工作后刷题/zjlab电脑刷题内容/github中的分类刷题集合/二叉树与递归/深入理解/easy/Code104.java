package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.深入理解.easy;

import org.omg.CORBA.MARSHAL;
import 工作后刷题.TreeNode;

/**
 * 二叉树的最大深度 easy
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 *
 * 输入：root = [1,null,2]
 * 输出：2
 *
 *
 * 提示：
 *
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 * @Author:zbl
 * @Date:2024/9/7 18:03
 */
public class Code104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left,right);
    }
}
