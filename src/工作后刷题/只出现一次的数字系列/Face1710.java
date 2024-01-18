package 工作后刷题.只出现一次的数字系列;

/**
 * @Author:zbl
 * @Date:2024/1/15 20:47
 * 主要元素(easy)
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class Face1710 {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if(num == 0) {
                target = nums[i];
                num++;
            } else if (target == nums[i]) {
                num++;
            } else {
                num--;
            }
        }
        num = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] == target) {
                num++;
            }
        }
        return num * 2 > nums.length ?  target : -1;
    }
}
