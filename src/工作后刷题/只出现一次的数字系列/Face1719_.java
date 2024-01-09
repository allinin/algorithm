package 工作后刷题.只出现一次的数字系列;

/**
 * @Author:zbl
 * @Date:2024/1/8 20:06
 * 消失的两个数字 (hard) leetCode 260的加强版
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 示例 1:
 *
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 *
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 *
 * nums.length <= 30000
 */
public class Face1719_ {

    public static int[] missingTwo(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length; //说明加上缺失的数字一共有n + 2个，
        int help = 0;
        for(int num : nums) {
            help ^= num;
        }
        for(int i = 1;i <= n + 2;i++) {
            help ^= i;
        }
        //当前help = 缺失的两个数字的异或和
        int help2 = help & (-help); // 获得help二进制表示中的最后一位1，缺失的两个数字在这个1对应的位上一定是一个是0，一个是1
        //可以根据这个二进制1的位置将上述中的2n-2个数分成两组
        for(int num : nums) {
            if((num & help2) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        for(int i = 1;i <= n + 2;i++) {
            if((i & help2) == 0) {
                ans[0] ^= i;
            } else {
                ans[1] ^= i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       int[] ans = missingTwo(new int[]{2,3});
       for(int num : ans) {
           System.out.println(num);
       }
    }
}
