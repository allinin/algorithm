package 工作后刷题.zjlab电脑刷题内容.社招面试题目;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-03-27  09:07
 * 路径总和II(medium)
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有从根节点到叶子节点路径总和等于
 * 给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Code113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        process(root, targetSum, new ArrayList<>());
        return res;
    }

    private void process(TreeNode root, int targetSum, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));//注意这里不能return,如果return了，则不能弹出最后一个元素从而继续查找
        }
        process(root.left, targetSum, list);
        process(root.right, targetSum, list);
        list.remove(list.size() - 1);
    }

    private void process2(TreeNode root,int targetSum,List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
            //已经到达了叶子节点，并且正好是符合的路径，则可以添加该路径后，从list中弹出刚添加的值，然后终止；
            // 或者如process方法的做法，不弹出，但是也不终止，等到最后一起弹出
            list.remove(list.size() - 1);
            return;
        }
        process2(root.left,targetSum,list);
        process2(root.right,targetSum,list);
        list.remove(list.size() - 1);
    }
}
