package 工作后刷题.zjlab电脑刷题内容.二分查找.最大化最小值;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:21
 * <p>
 * 礼盒的最大甜蜜度
 * <p>
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * <p>
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * <p>
 * 返回礼盒的 最大 甜蜜度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * 示例 2：
 * <p>
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * 示例 3：
 * <p>
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= k <= price.length <= 105
 * 1 <= price[i] <= 109
 */
public class Code2517 {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int left = 0, right = price[n - 1] - price[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(mid, price, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //有序数组price中任意两数之间的差值>=diff的可选目标元素的数量是否>=k
    private boolean check(int diff, int[] price, int k) {
        int sum = 1,pre = price[0];
        for(int i = 1;i < price.length;i++) {
            if(price[i] - pre >= diff) {
                pre = price[i];
                sum++;
            }
        }
        return sum >= k;
    }

    public static void main(String[] args) {
        int[] price = new int[]{13, 5, 1, 8, 21, 2};
        int k = 3;
        System.out.println(new Code2517().maximumTastiness(price, k));
    }

}
