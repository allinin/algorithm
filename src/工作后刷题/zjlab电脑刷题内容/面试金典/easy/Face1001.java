package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  18:47
 * 合并排序数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 */
public class Face1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int leftA = m - 1, leftB = n - 1;
        int idx = m + n - 1;
        while (leftA >= 0 && leftB >= 0) {
            if (A[leftA] >= B[leftB]) {
                A[idx--] = A[leftA--];
            } else {
                A[idx--] = B[leftB--];
            }
        }
        while (leftB >= 0) {
            A[idx--] = B[leftB--];
        }
    }
}
