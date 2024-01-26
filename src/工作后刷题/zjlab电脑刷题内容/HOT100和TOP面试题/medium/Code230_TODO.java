package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import HOT100和TOP面试题.TreeNode;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  14:25
 * 二叉搜索树中第k小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 *
 *
 *
 * 提示：
 *
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *   TODO  进阶实现
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/1050055/er-cha-sou-suo-shu-zhong-di-kxiao-de-yua-8o07/
 */
public class Code230_TODO {

    private int ans = 0;
    private int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }

    private void inOrder(TreeNode root,int k) {
        if(root != null){
            inOrder(root.left,k);
            num++;
            if(num == k) {
                ans = root.val;
            }
            inOrder(root.right,k);
        }
    }
}
