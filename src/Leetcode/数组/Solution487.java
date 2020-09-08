package Leetcode.数组;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。

示例 1：

输入：[1,0,1,1,0]
输出：4
解释：翻转第一个 0 可以得到最长的连续 1。
当翻转以后，最大连续 1 的个数为 4。


注：

输入数组只包含 0 和 1.
输入数组的长度为正整数，且不超过 10,000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-consecutive-ones-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/9/8 20:11
 */
public class Solution487 {

       public static int  process(int [] arr) {
           int n = arr.length;
           int left = 0, right = 0;
           boolean flag = false;
           int tmp=0;
           int res = 0;
           while (right < n) {
               if (arr[right] == 0) {
                   if(flag) {
                       left = tmp + 1;
                       flag = false;
                   }
                   else{
                       flag = true;
                       tmp=right;
                   }

               }
               res = Math.max(res, ++right - left);
           }
           return res;
       }

    public static void main(String[] args) {
        int[] arr=new int[]{1,0,1,1,0,1,1,1,1};
        System.out.println(process(arr));
    }
}
