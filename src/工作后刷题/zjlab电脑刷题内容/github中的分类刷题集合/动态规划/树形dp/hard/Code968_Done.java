package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.树形dp.hard;

import 工作后刷题.TreeNode;

/**
 * 监控二叉树 hard (最小支配集问题）
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 *
 * @author: ZBL
 * @date: 2024-09-11  18:41
 */
public class Code968_Done {

    public int minCameraCover(TreeNode root) {
        int[] res = process(root);
        return Math.min(res[0], res[2]);
    }

    /**
     * @param root
     * @return int[3]:分别表示监控当前节点及子树：当前节点安装摄像头需要的最少摄像头数，被父节点监控需要的最少摄像头数，被子节点监控苏需要的最少摄像头数
     */
    private int[] process(TreeNode root) {
        if (root == null) {
            //Integer.MAX_VALUE / 2 表示无效的数,并防止溢出
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] res = new int[3];
        int[] left = process(root.left);
        int[] right = process(root.right);
        res[0] = 1 + Math.min(left[0], Math.min(left[1], left[2])) + Math.min(right[0], Math.min(right[1], right[2]));
        res[1] = Math.min(left[0], left[2]) + Math.min(right[0], right[2]);
        res[2] = Math.min(left[0] + right[2], Math.min(left[2] + right[0], left[0] + right[0]));
        return res;
    }
}
