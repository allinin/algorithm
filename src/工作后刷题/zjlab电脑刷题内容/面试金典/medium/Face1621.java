package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.*;

/**
 * @author zbl
 * @create 2024-01-15 16:03
 * 交换和
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 * 若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例:
 * <p>
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * 示例:
 * <p>
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * 提示：
 * <p>
 * 1 <= array1.length, array2.length <= 100000
 */
public class Face1621 {

    //排序后双指针
    public int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1 = 0, sum2 = 0;
        for (int num : array1) {
            sum1 += num;
        }
        for (int num : array2) {
            sum2 += num;
        }
        int diff = sum1 - sum2;
        int idx1 = 0, idx2 = 0;
        while (idx1 < array1.length && idx2 < array2.length) {
            int num1 = array1[idx1];
            int num2 = array2[idx2];
            int nowDiff = num1 - num2;
            //因为交换后一个数组的值加了nowDiff,另一个数组的值减了nowDiff,所以这里的判断值需要X2
            if (nowDiff * 2 == diff) {
                return new int[]{array1[idx1], array2[idx2]};
            } else if (nowDiff * 2 < diff) {
               idx1++;
            } else {
                idx2++;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] arr2 = new int[]{3, 6, 3, 3};
        int[] ans = new Face1621().findSwapValues(arr1, arr2);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
