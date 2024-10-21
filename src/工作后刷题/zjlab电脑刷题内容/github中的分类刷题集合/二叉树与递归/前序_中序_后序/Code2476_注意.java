package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.前序_中序_后序;

import 工作后刷题.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最近节点查询 medium
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * <p>
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * <p>
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * 示例 2 ：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [2, 105] 内
 * 1 <= Node.val <= 106
 * n == queries.length
 * 1 <= n <= 105
 * 1 <= queries[i] <= 106
 *
 * @author: ZBL
 * @date: 2024-10-20  20:19
 */
public class Code2476_注意 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    //超时了
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        if (queries == null || queries.isEmpty()) {
            return res;
        }
        for (int num : queries) {
            ;
            List<Integer> list = new ArrayList<>();
            list.add(findLessMax(root, num));
            int bigMin = findBigMin(root, num);
            list.add(bigMin == Integer.MAX_VALUE ? -1 : bigMin);
            res.add(list);
        }
        return res;
    }

    private int findLessMax(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val == val) {
            return val;
        }
        if (root.val > val) {
            return findLessMax(root.left, val);
        }
        //小于
        return Math.max(root.val, findLessMax(root.right, val));
    }

    private int findBigMin(TreeNode root, int val) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.val == val) {
            return val;
        }
        if (root.val < val) {
            return findBigMin(root.right, val);
        }
        //大于
        return Math.min(root.val, findBigMin(root.left, val));
    }

    //中序遍历转化为数组+二分查找
    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        if (queries == null || queries.isEmpty()) {
            return res;
        }
        inOrder(root);
        Integer[] array = list.toArray(new Integer[0]);
        for (int num : queries) {
            List<Integer> list = new ArrayList<>();
            list.add(findLessMax(array, num));
            list.add(findBigerMin(array, num));
            res.add(list);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }

    private int findLessMax(Integer[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                //mid < target
                left = mid + 1;
            }
        }
        return left == arr.length ? arr[left - 1] : arr[left] == target ? target : left > 0 ? arr[left - 1] : -1;
    }

    //当targe在数组中不存在时，通过这种求最后一次出现的位置的方式来判断出目标值，因为在目标值在数组中不存在时，通过这种方式求最后一次出现的位置的索引会有问题。具体见Code34中的说明
    private int findBigerMin(Integer[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                //mid <= target
                left = mid;
            }
        }

        if (arr[left] == target) {
            return target;
        }
        if (left == arr.length - 1) {
            return -1;
        }
        //TODO 当arr[left] != target时，当left == 0时，有可能是arr[0] > target造成的，也有可能是因为arr[left] != target造成的。当target > arr[0]且target不在数组中时，
        // 要想通过找到target在数组中的正确位置，需要取值上述过程求取的(index + 1),所以在计算一个数字在有序数组中的位置时，最好通过计算第一次出现的位置来判断。
        return arr[left] > target ? arr[left] : arr[left + 1];

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(16);
        TreeNode left = new TreeNode(14);
        TreeNode leftLeft = new TreeNode(5);
        TreeNode leftRight = new TreeNode(15);
        leftLeft.left = new TreeNode(1);
        left.left = leftLeft;
        left.right = leftRight;
        root.left = left;
        List<Integer> query = new ArrayList<>();
        query.add(2);
        // new Code2476().closestNodes2(root, query);
        Integer[] arr = new Integer[]{1, 2, 4, 6};
        new Code2476_注意().findBigerMin(arr, 5);

    }
}
