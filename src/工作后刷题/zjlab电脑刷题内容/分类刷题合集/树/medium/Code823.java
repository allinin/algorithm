package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.树.medium;

import java.util.*;

/**
 * @Author:zbl
 * @Date:2024/2/7 18:12
 * 带因子的二叉树
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 * <p>
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * <p>
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 * <p>
 * 输入: arr = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 109
 * arr 中的所有值 互不相同
 */
public class Code823 {

    private static final Integer MOD = 1000000007;
    Map<Integer, Long> map = new HashMap<>();

    //map也可以写成是dp数组，即：相当于dp+双指针
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int left = 0,right = i - 1;
            long tmp = 1l;
            while(left <= right) {
                if((long)arr[left] * arr[right] > arr[i]) {
                    right--;
                } else if((long)arr[left] * arr[right] < arr[i]) {
                    left++;
                } else {
                    tmp = (tmp + map.get(arr[left]) * map.get(arr[right])) % MOD;
                    if(arr[left] != arr[right]) {
                        tmp = (tmp + map.get(arr[left]) * map.get(arr[right])) % MOD;
                    }
                    left++;
                    right--;
                }
            }
            map.put(arr[i],tmp);
            ans = (ans + tmp) % MOD;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48};
        int[] arr2 = new int[]{18, 3, 6, 2};
        int[] arr1 = new int[]{2, 82, 64, 18, 85, 86, 81, 4, 67, 95};
        System.out.println(new Code823().numFactoredBinaryTrees(arr));

    }

}
