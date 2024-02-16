package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  09:35
 * 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Face0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, start, mid - 1);
        root.right = process(nums, mid + 1, end);
        return root;
    }
}
