package 工作后刷题.zjlab电脑刷题内容.二分题目合集.第k大小.medium;


/**
 * @Author: ZBL
 * @Date: 2024-01-23  16:30
 * <p>
 * 第k个最小的素数分数(medium)
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * <p>
 * 对于每对满足 0 <= i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * <p>
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 示例 2：
 * <p>
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 * <p>
 * <p>
 * 进阶：你可以设计并实现时间复杂度小于 O(n2) 的算法解决此问题吗？
 */
public class Code786_DONE {

    int[] ans = new int[2];

    double diff = 1e-8;

    //方法一:二分+双指针
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0d, right = 1d;
        while (right - left > diff) {
            double mid = left + (right - left) / 2;
            if (check(arr, mid, k)) {
                right = mid;
            } else {
                //这里不能再是平时写的mid + 1,因为left，right的范围本来就在0-1
                left = mid;
            }
        }
        return ans;
    }


    private boolean check(int[] arr, double target, int k) {
        int sum = 0;
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            //用idx的下一个元素是否满足小于等于来规避idx
            while (1d * arr[idx + 1] / arr[i] <= target) idx++;
            if (1d * arr[idx] / arr[i] <= target) sum += idx + 1;
            //取最后一个满足无限接近target的组合
            if (Math.abs(1d * arr[idx] / arr[i] - target) < diff) {
                ans[0] = arr[idx];
                ans[1] = arr[i];
            }
        }
        return sum >= k;
    }




    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        int k = 3;
        int[] ints = new Code786_DONE().kthSmallestPrimeFraction(arr, k);
        for (int num : ints) {
            System.out.print(num + " ");
        }
    }


}
