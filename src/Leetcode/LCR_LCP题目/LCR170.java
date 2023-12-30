package Leetcode.LCR_LCP题目;

/**
 * @Author:zbl
 * @Date:2023/12/30 12:31
 * <p>
 * 交易逆序对总数
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= record.length <= 50000
 */
public class LCR170 {


    int ans = 0;

    //归并排序的方式
    public int reversePairs(int[] record) {
        if(record == null || record.length < 2) {
            return 0;
        }
        int n = record.length;
        process(record, 0, n - 1);
        return ans;
    }

    private void process(int[] record, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        process(record, left, mid);
        process(record, mid + 1, right);
        merge(record, left, mid,right);
    }

    private void merge(int[] nums, int left,  int mid,int right) {
        int[] help = new int[right - left + 1];
        int idx1 = left, idx2 = mid + 1;
        int idx = 0;
        while (idx1 <= mid && idx2 <= right) {
            if (nums[idx1] <= nums[idx2]) {
                help[idx++] = nums[idx1++];
            } else {
                ans += (mid - idx1 + 1);
                help[idx++] = nums[idx2++];
            }
        }
        while (idx1 <= mid) {
            help[idx++] = nums[idx1++];
        }
        while (idx2 <= right) {
            help[idx++] = nums[idx2++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = help[i - left];
        }
    }

    //TODO 树状数组的方式
    public int reversePairs2(int[] record) {
        if(record == null || record.length < 2) {
            return 0;
        }

        return ans;
    }

}
