package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.深入理解.medium;

import 工作后刷题.TreeNode;

/**
 *  统计二叉树中好节点的数目 medium
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 * 示例 2：
 *
 *
 *
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 *
 *
 * 提示：
 *
 * 二叉树中节点数目范围是 [1, 10^5] 。
 * 每个节点权值的范围是 [-10^4, 10^4] 。
 * @Author:zbl
 * @Date:2024/9/7 18:09
 */
public class Code1448 {

    int ans = 0;


    //dfs
    public int goodNodes(TreeNode root) {
        process(root,Integer.MIN_VALUE);
        return ans;
    }

    private void process(TreeNode root,int nowMax) {
        if(root == null) {
            return;
        }
        if(root.val >= nowMax) {
            ans++;
        }
        process(root.left,Math.max(nowMax,root.val));
        process(root.right,Math.max(nowMax,root.val));

    }
}
