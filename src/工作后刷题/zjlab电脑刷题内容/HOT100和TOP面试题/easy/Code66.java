package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * @Author: ZBL
 * @Date: 2023-12-19  17:25
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Code66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        int i = n - 1;
        for (; i >= 0; i--) {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
        }
        if (i >= 0 || carry == 0) {
            return digits;
        }
        int[] ans = new int[n + 1];
        ans[0] = carry;
        for(int j = 1;j <= n;j++) {
            ans[j] = digits[j - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9, 9};
        int[] ints = new Code66().plusOne(digits);
        for (int i : ints) {
            System.out.print(i + " ");
        }

    }
}
