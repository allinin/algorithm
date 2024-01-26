package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-11  14:52
 * 最小差
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * <p>
 * 示例：
 * <p>
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间 [0, 2147483647] 内
 */
public class Face1606 {

    //最小差一定来自于两个数组排成一个有序数组后最近相邻的两个来自不同数组的两个数之差
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int lenA = a.length, lenB = b.length;
        if (a[lenA - 1] <= b[0]) {
            return Math.abs(b[0] - a[lenA - 1]);
        }
        if (a[0] >= b[lenB - 1]) {
            return Math.abs(a[0] - b[lenB - 1]);
        }
        int idxA = 0, idxB = 0, ans = Integer.MAX_VALUE;
        int pre = a[idxA] <= b[idxB] ? a[idxA++] : b[idxB++];
        int preFrom = a[idxA] <= b[idxB] ? 0 : 1;
        while (idxA < lenA && idxB < lenB) {
            if(ans == 0) {
                return ans;
            }
            if (a[idxA] <= b[idxB]) {
                if (preFrom == 1) {
                    ans = Math.min(ans, Math.abs(a[idxA] - pre));
                }
                pre = a[idxA++];
                preFrom = 0;
            } else {
                if (preFrom == 0) {
                    ans = Math.min(ans, Math.abs(b[idxB] - pre));
                }
                pre = b[idxB++];
                preFrom = 1;
            }
        }
        if (idxB < lenB && preFrom == 0) {
            ans = Math.min(ans, Math.abs(b[idxB] - pre));
        }
        if (idxA < lenA && preFrom == 1) {
            ans = Math.min(ans, Math.abs(a[idxA] - pre));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 15, 11, 2};
        int[] b = new int[] {23, 127, 235, 19, 8};
        System.out.println(new Face1606().smallestDifference(a,b));
    }
}
