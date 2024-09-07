package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.位运算;

import 工作后刷题.TreeNode;

/**
 * @Author:zbl
 * @Date:2024/2/7 18:13
 * 二叉树的伪回文路径(medium)
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是「伪回文」的，当它满足：
 * 路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中伪回文路径的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 * 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 * 这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 3：
 * <p>
 * 输入：root = [9]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定二叉树的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 9
 */
public class Code1457 {

    int[] help = new int[10];
    int ans = 0;

    //方法一:
    public int pseudoPalindromicPaths(TreeNode root) {
        process(root);
        return ans;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }

        help[root.val]++;
        //到达叶子节点
        if (root.left == null && root.right == null) {
            if (check()) {
                ans++;
            }
        }

        process(root.left);
        process(root.right);
        //回溯
        help[root.val]--;

    }

    private boolean check() {
        int evenNum = 0, oddNum = 0;
        for (int i = 1; i <= 9; i++) {
            if (help[i] % 2 == 0) {
                oddNum++;
            } else {
                evenNum++;
            }
        }
        if (evenNum > 1) {
            return false;
        }
        return true;
    }
    //方法二:位运算的方式
    public int pseudoPalindromicPaths2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num ^= (1 << root.val);
        if (root.left == null && root.right == null) {
            //到达根节点，符合要求的情况下，只有一个或者0个奇数情况，也就是num的二进制表示中只有一位或者0位是1
            //去num二进制表示中的最后一个1所在的位表示的数字
            if((num & -num) == num) {
                ans++;
            }
        }
        dfs(root.left,num);
        dfs(root.right,num);
        //回溯
        num ^= (1 << root.val);
    }


}
