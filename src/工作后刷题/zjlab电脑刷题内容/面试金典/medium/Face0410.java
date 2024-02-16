package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  11:17
 * <p>
 * 检查子树。
 * 你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * <p>
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * <p>
 * 注意：此题相对书上原题略有改动。
 * <p>
 * 示例1:
 * <p>
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * 示例2:
 * <p>
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * 提示：
 * <p>
 * 树的节点数目范围为[0, 20000]。
 */
public class Face0410 {

    //双重递归
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            boolean left = checkSub(t1.left, t2.left);
            boolean right = checkSub(t1.right, t2.right);
            if (left && right) {
                return true;
            }
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean checkSub(TreeNode root1,TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return checkSub(root1.left,root2.left) && checkSub(root1.right,root2.right);
    }
}
