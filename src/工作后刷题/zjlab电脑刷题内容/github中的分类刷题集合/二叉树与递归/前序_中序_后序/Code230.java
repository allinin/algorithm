package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.前序_中序_后序;

import 工作后刷题.TreeNode;

/**
 * 二叉搜索树的第k小元素 medium
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *
 * @author: ZBL
 * @date: 2024-10-20  20:10
 */
public class Code230 {

    int ans = 0;
    int idx = 1;

    public int kthSmallest(TreeNode root, int k) {
        process(root, k);
        return ans;
    }

    private void process(TreeNode root, int k) {
        if (root != null) {
            process(root.left, k);
            if (idx == k) {
                ans = root.val;
            }
            idx++;
            process(root.right, k);
        }
    }

}
