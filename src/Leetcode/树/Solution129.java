package Leetcode.树;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
1
/ \
2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/30 15:07
 */
public class Solution129 {


     public class TreeNode {
        int val;
         TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }

    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }

        private int dfs(TreeNode root,int preNum){
            if(root==null)
                return 0;
            int sum=preNum*10+root.val;
            if(root.left==null && root.right==null){
                return sum;
            }else{
                return dfs(root.left,sum)+dfs(root.right,sum);
            }
        }
    }
}
