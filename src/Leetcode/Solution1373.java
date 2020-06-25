package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。

二叉搜索树的定义如下：

任意节点的左子树中的键值都 小于 此节点的键值。
任意节点的右子树中的键值都 大于 此节点的键值。
任意节点的左子树和右子树都是二叉搜索树。
 

示例 1：



输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
输出：20
解释：键值为 3 的子树是和最大的二叉搜索树。
示例 2：



输入：root = [4,3,null,1,2]
输出：2
解释：键值为 2 的单节点子树是和最大的二叉搜索树。
示例 3：

输入：root = [-4,-2,-5]
输出：0
解释：所有节点键值都为负数，和最大的二叉搜索树为空。
示例 4：

输入：root = [2,1,3]
输出：6
示例 5：

输入：root = [5,4,8,3,null,6,3]
输出：7
 

提示：

每棵树最多有 40000 个节点。
每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/16 22:02
 */
public class Solution1373 {

    public class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
  }

    public class Result{
        boolean isBST;
        int nums;
        int Max;
        int Min;
        public Result(boolean isBst,int nums,int max,int min){
            this.isBST=isBst;
            this.nums=nums;
            this.Max=max;
            this.Min=min;
        }
    }

    public int maxSum=0;
    public int maxSumBST(TreeNode root) {
        if(root==null)
            return 0;
        process(root);
        return maxSum;
    }

    private Result process(TreeNode root){
        if(root==null){
            return new Result(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Result left=process(root.left);
        Result right=process(root.right);
        if(!(left.isBST && right.isBST)){
            return new Result(false,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);
        }else{
            if(!(left.Max<root.val && right.Min>root.val)){
                return new Result(false,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);
            }
        }
        int nums=left.nums+right.nums+root.val;
        int min=Math.min(Math.min(left.Min,right.Min),root.val);
        int max=Math.max(Math.max(left.Max,right.Max),root.val);
        maxSum=Math.max(maxSum,nums);
        return new Result(true,nums,max,min);


    }

    public static void main(String[] args) {
        Solution1373 solution=new Solution1373();
        TreeNode root=solution.new TreeNode(4);
        TreeNode left=solution.new TreeNode(3);
        root.left=left;
        left.left=solution.new TreeNode(1);
        left.right=solution.new TreeNode(5);

        System.out.println(solution.maxSumBST(root));

    }
}
