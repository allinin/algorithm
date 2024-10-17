package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.前序_中序_后序;

import 工作后刷题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 验证二叉树 medium
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 *
 * @author: ZBL
 * @date: 2024-10-17  18:22
 */
public class Code98 {

    Integer pre = null;
    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inOrder(root);
        return res;

    }

    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            if(pre == null) {
                pre = root.val;
            } else {
                if(root.val <= pre) {
                    res = false;
                    return;
                } else {
                    pre = root.val;
                }
            }
            inOrder(root.right);
        }
    }

}
