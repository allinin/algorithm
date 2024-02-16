package 工作后刷题.zjlab电脑刷题内容.二分查找.最小化最大值;

import javax.swing.*;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:19
 * <p>
 * 最小化两个数组中的最大值(medium)
 * <p>
 * 给你两个数组 arr1 和 arr2 ，它们一开始都是空的。你需要往它们中添加正整数，使它们满足以下条件：
 * <p>
 * arr1 包含 uniqueCnt1 个 互不相同 的正整数，每个整数都不能被divisor1 整除 。
 * arr2 包含 uniqueCnt2 个 互不相同 的正整数，每个整数都不能被divisor2 整除 。
 * arr1 和 arr2 中的元素 互不相同 。
 * 给你 divisor1 ，divisor2 ，uniqueCnt1 和 uniqueCnt2 ，请你返回两个数组中 最大元素 的 最小值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3
 * 输出：4
 * 解释：
 * 我们可以把前 4 个自然数划分到 arr1 和 arr2 中。
 * arr1 = [1] 和 arr2 = [2,3,4] 。
 * 可以看出两个数组都满足条件。
 * 最大值是 4 ，所以返回 4 。
 * 示例 2：
 * <p>
 * 输入：divisor1 = 3, divisor2 = 5, uniqueCnt1 = 2, uniqueCnt2 = 1
 * 输出：3
 * 解释：
 * arr1 = [1,2] 和 arr2 = [3] 满足所有条件。
 * 最大值是 3 ，所以返回 3 。
 * 示例 3：
 * <p>
 * 输入：divisor1 = 2, divisor2 = 4, uniqueCnt1 = 8, uniqueCnt2 = 2
 * 输出：15
 * 解释：
 * 最终数组为 arr1 = [1,3,5,7,9,11,13,15] 和 arr2 = [2,6] 。
 * 上述方案是满足所有条件的最优解。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= divisor1, divisor2 <= 105
 * 1 <= uniqueCnt1, uniqueCnt2 < 109
 * 2 <= uniqueCnt1 + uniqueCnt2 <= 109
 */
public class Code2513 {

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long left = 1l, right = Math.max(1l * divisor1 * uniqueCnt1 - 1, 1l * divisor2 * uniqueCnt2 - 1);
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, divisor1, divisor1, uniqueCnt1, uniqueCnt2)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return (int) left;
    }

    private boolean check(long target, int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        if (divisor1 > divisor2) {
            int tmp = divisor1;
            divisor1 = divisor2;
            divisor2 = divisor1;
        }
        int diff = divisor2 - divisor1;
        long num1 = target % divisor1 + target / divisor1 * (divisor1 - 1);
        long num2 = target % divisor2 + target / divisor2 * (divisor2 - 1);
        long same = diff * (target / divisor2) + target % divisor1;
        return num1 + num2 - same >= uniqueCnt1 + uniqueCnt2;
    }
}
