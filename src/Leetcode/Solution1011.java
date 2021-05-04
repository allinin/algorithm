package Leetcode;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。

 

示例 1：

输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
输出：15
解释：
船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
第 1 天：1, 2, 3, 4, 5
第 2 天：6, 7
第 3 天：8
第 4 天：9
第 5 天：10

请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/26 13:09
 */
public class Solution1011 {
    public static int shipWithinDays(int[] weights, int D) {
        int len = weights.length;
        int sum = 0;
        for(int i = 0;i < len;i++){
            sum += weights[i];
        }
        int left = sum % D == 0 ? sum / D : sum / D + 1;
        int right = sum;
        int num = D,idx = 0;
        while(left < right){
            int mid = left + (right - left) / 2;
            num = D;
            idx = 0;
            int tmp = 0;
            while(num > 0 && idx < len){
                if(tmp >= mid){
                    tmp = 0;
                    num--;
                }else{
                    tmp += weights[idx];
                    idx = tmp > mid ? idx : idx + 1;
                }
            }
            if(num >= 0){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    //二分的方式
    public static int shipWithinDays2(int[] weights, int D) {
        int len = weights.length;
        int left = Arrays.stream(weights).max().getAsInt();//由于不能拆分一个包裹，所以左边界就是单个包裹重量的最大值
        int right = Arrays.stream(weights).sum();
        int num = D,idx = 0;
        while(left < right){
            int mid = left + (right - left) / 2;
            int need = 1, cur = 0;
            //计算需要的天数的过程
            for(int weight : weights){
                if(cur + weight > mid){
                    cur = 0;
                    need++;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr,5));
    }
}
