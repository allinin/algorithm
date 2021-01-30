package Leetcode;

import java.util.ArrayList;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:

输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
注意:

数组内已种好的花不会违反种植规则。
输入的数组长度范围为 [1, 20000]。
n 是非负整数，且不会超过输入数组的大小。
通过次数51,826提交次数157,237

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/can-place-flowers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/1 12:24
 */
public class Solution605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if(n == 0) {
            return true;
        }
        if(n > (m + 1) / 2) {
            return false;
        }
        int oneCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            if(flowerbed[i] == 1){
                oneCount++;
                list.add(i);
            }
        }
        if(oneCount == 0){
            return true;
        }
        if((oneCount + n) > (m + 1) / 2) {
            return false;
        }
        int pos = list.get(0);
        if(pos >= 2){
            n -= pos/2;
        }
        if(n == 0){
            return true;
        }
        int pre = pos;
        for(int i = 1; i < list.size(); i++){
            pos = list.get(i);
            int diff = pos - pre -3;
            if(diff >=1) {
                n -= (diff + 1)/2;
            }
            if(n <= 0){
                return true;
            }
            pre = pos;
        }
        n -= (m - pos - 1)/2;
        return n > 0 ? false : true;
    }
    //方法二：
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int m = flowerbed.length;
        //用来统计可以最大种花的数量
        int count = 0;
        //上一个1出现的位置
        int pre = -1;
        for(int i = 0; i < m; i++){
            if(flowerbed[i] == 1){
                if(pre == -1){
                    count += i / 2;
                }else{
                    count += (i - pre - 2) / 2;
                }
                pre = i;
            }
        }
        if(pre == -1){
            //一个1也没有的情况
            count += (m + 1) / 2;
        }else{
            count += (m - pre - 1)/2;
        }
        return count >= n;

    }

    public static void main(String[] args) {
        int[] arr={1,0,0,0,1};
        System.out.println(canPlaceFlowers(arr,1));
    }
}
