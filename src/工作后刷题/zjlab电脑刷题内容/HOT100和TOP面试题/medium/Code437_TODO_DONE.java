package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和III
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class Code437_TODO_DONE {

    private int ans = 0;

    private HashMap<Node, Integer> map = new HashMap<>();

    //原始递归方式
    public int pathSum(TreeNode root, int targetSum) {
        find(root, targetSum);
        return ans;
    }

    //双递归
    private void find(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        process(root, targetSum, 0);
        find(root.left, targetSum);
        find(root.right, targetSum);
    }

    /**
     * 计算从root开始和为targetSum的路径数量
     *
     * @param root
     * @param targetSum
     * @return
     */
    private void process(TreeNode root, int targetSum, int nowNum) {
        if (root == null) {
            return;
        }
        nowNum += root.val;
        if (nowNum == targetSum) {
            ans++;
        }
        process(root.left, targetSum, nowNum);
        process(root.right, targetSum, nowNum);
    }


    // 方法二:记忆化搜索,记录从每个节点寻找目标值target可选的路径数目，运行时间、空间竟然比直接递归更大了！！！
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = process2(root, targetSum, 0L);
        res += pathSum2(root.left, targetSum);
        res += pathSum2(root.right, targetSum);
        return res;
    }

    private int process2(TreeNode root, int targetSum, long nowNum) {
        if (root == null) {
            return 0;
        }
        long tmp = nowNum;
        int res = 0;
        nowNum += root.val;
        if (nowNum == targetSum) {
            res = 1;
        }
        Node leftNode = new Node(root.left, targetSum - nowNum);
        Node rightNode = new Node(root.right, targetSum - nowNum);
        if (map.containsKey(leftNode)) {
            res += map.get(leftNode);
        } else {
            res += process2(root.left, targetSum, nowNum);
        }
        if (map.containsKey(rightNode)) {
            res += map.get(rightNode);
        } else {
            res += process2(root.right, targetSum, nowNum);
        }
        Node node = new Node(root, targetSum - tmp);
        map.put(node, res);
        return res;
    }

    class Node {
        TreeNode treeNode; //当前节点
        long targetValue; //寻找的目标值

        public Node(TreeNode treeNode, long targetValue) {
            this.treeNode = treeNode;
            this.targetValue = targetValue;
        }

        @Override
        public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            if (anObject instanceof Node) {
                Node otherNode = (Node) anObject;
                if (otherNode.targetValue == this.targetValue && this.treeNode == otherNode.treeNode) {
                    return true;
                }
            }
            return false;
        }
    }

    //key:遍历到当前节点出现的所有节点和值，value:节点和值出现的次数
    private Map<Long, Integer> helpMap = new HashMap<>();

    // TODO 记忆化搜索，类似第560题，和为k子数组的做法，另一种写法见Face0412
    public int pathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        helpMap.put(0L, 1);

        return process3(root, targetSum, 0);
    }

    private int process3(TreeNode root, long targetSum, long curValue) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        long nowValue = curValue + root.val;

        res += helpMap.getOrDefault(nowValue - targetSum,0);
        //如果将该put与上述的get操作位置互换，例如当targetSum == 0时，结果会不对，所以必须是先计算在更新频率
        helpMap.put(nowValue, helpMap.getOrDefault(nowValue, 0) + 1);
        res += process3(root.left, targetSum, nowValue);
        res += process3(root.right, targetSum, nowValue);
        //回溯，避免对计算另一个子树造成影响
        helpMap.put(nowValue, helpMap.get(nowValue) - 1);
        return res;
    }


}
