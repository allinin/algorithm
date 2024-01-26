package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-15  09:55
 * 部分排序
 * 给定一个整数数组，编写一个函数，找出索引m和n，
 * 只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。
 * 函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * 示例：
 * <p>
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 * <p>
 * 0 <= len(array) <= 1000000
 */
public class Face1616_注意 {
    public int[] subSort(int[] array) {
        int[] ans = new int[]{-1, -1};
        if (array == null || array.length == 0) {
            return ans;
        }
        int len = array.length;
        int[] maxArr = new int[len]; // i及以左的最大值
        int[] minArr = new int[len]; //i及以右的最小值
        maxArr[0] = array[0];
        minArr[len - 1] = array[len - 1];
        for (int i = 1; i < len; i++) {
            maxArr[i] = Math.max(maxArr[i - 1], array[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            minArr[i] = Math.min(minArr[i + 1], array[i]);
        }
        //从左往右遍历，找到最右边的maxArr[i] != arr[i]的索引说明是无序的最右边界
        for (int i = 0; i < len; i++) {
            if (maxArr[i] != array[i]) {
                ans[1] = i;
            }
        }
        //从右往左遍历，找出最左边的minArr[i] != arr[i]的索引说明是最左边界
        for (int i = len - 1; i >= 0; i--) {
            if (minArr[i] != array[i]) {
                ans[0] = i;
            }
        }
        return ans;
    }
}
