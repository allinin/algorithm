package 面试手撕代码;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 判断一颗树是否是镜像对称的
 * @date 2020/7/6 20:27
 */
public class IsSymmetricTree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
    }

    public boolean process(TreeNode node){
        if(node==null) return true;
        if(node.left!=null && node.right!=null){
            return help(node.left,node.right);
        }
        return false;
    }
    private boolean help(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        if(left.val!=right.val) return false;
        boolean leftResult=help(left.right,right.left);
        boolean rightResult=help(left.left,right.right);
        return leftResult && rightResult;
    }
}
