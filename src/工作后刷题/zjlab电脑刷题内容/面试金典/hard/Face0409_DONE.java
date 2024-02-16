package 工作后刷题.zjlab电脑刷题内容.面试金典.hard;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  10:13
 * 二叉搜索树序列
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * <p>
 * 给定一个由不同节点组成的二叉搜索树 root，输出所有可能生成此树的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3]
 * 输出: [[2,1,3],[2,3,1]]
 * 解释: 数组 [2,1,3]、[2,3,1] 均可以通过从左向右遍历元素插入树中形成以下二叉搜索树
 * 2
 * / \
 * 1   3
 * 示例 2:
 * <p>
 * 输入: root = [4,1,null,null,3,2]
 * 输出: [[4,1,3,2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉搜索树中的节点数在 [0, 1000] 的范围内
 * 1 <= 节点值 <= 10^6
 * 用例保证符合要求的数组数量不超过 5000
 */
public class Face0409_DONE {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            res.add(new ArrayList<>());
            return res;
        }
        List<Integer> path = new LinkedList<>();
        path.add(root.val);

        process(path, new LinkedList<TreeNode>(), root);

        return res;
    }

    private void process(List<Integer> path, List<TreeNode> deque, TreeNode cur) {
        if (cur.left != null) {
            deque.add(cur.left);
        }
        if (cur.right != null) {
            deque.add(cur.right);
        }
        if (deque.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        int len = deque.size();
        for (int i = 0; i < len; i++) {
            TreeNode child = deque.get(i);
            path.add(child.val);
            deque.remove(i);
            //注意这里的deque参数的形式
            process(path, new LinkedList<>(deque), child);

            //回溯
            path.remove(path.size() - 1);
            deque.add(i, child);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

    }
}
