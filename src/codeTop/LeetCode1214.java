package codeTop;

import java.util.HashSet;

/**
 * Given the roots of two binary tree,root1 and root2,return true if and only if there is a node in the first tree
 * and a node in the second tree whose value sum up to a given integer target
 */
public class LeetCode1214 {

    HashSet<Integer> set = new HashSet<>();

    /**
     * 时间负责度：O(N),空间复杂度：O(n)
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTS(TreeNode root1,TreeNode root2,Integer target){
        if(root1 == null || root2 == null){
            return false;
        }
        dfs(root1);
        return process(root2,target);
    }

    //将TreeNode root的所有节点都放到set中
    private void dfs(TreeNode root){
        if(root != null){
            set.add(root.value);
            dfs(root.left);
            dfs(root.right);
        }
    }
    private boolean process(TreeNode root,Integer target){
        if(root == null){
            return false;
        }
        int diff = target - root.value;
        if(set.contains(diff)){
            return true;
        }
        return process(root.left,target) || process(root.right,target);
    }
    /**
     * 方法二：O(nlogn),固定其中一个bst,二分查找另一个。
     *
     */
    public boolean twoSumBSTS2(TreeNode root1,TreeNode root2,Integer target){
        if(root1 == null) return false;
        if(find(root2,target - root1.value)) return true;
        return twoSumBSTS2(root1.left,root2,target) || twoSumBSTS2(root1.right,root2,target);
    }

    private boolean find(TreeNode root,Integer target){
        if(root == null){
            return false;
        }
        if(root.value == target){
            return true;
        }else if(root.value > target){
            return find(root.left,target);
        }else {
            return find(root.right,target);
        }
    }
}

class TreeNode{
    public Integer value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer value){
        this.value = value;
    }
}
