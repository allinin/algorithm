package 左神算法.进阶班二.第二章;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。

编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。



示例 1:

┌───┐
│   │
└───┼──>
│

输入: [2,1,1,2]
输出: true

示例 2:

┌──────┐
│      │
│
│
└────────────>

输入: [1,2,3,4]
输出: false

示例 3:

┌───┐
│   │
└───┼>

输入: [1,1,1,1]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/self-crossing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/2/16 19:21
 */
public class Problem06_Self_Crossing {

    public static boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) {
            return false;
        }
        if ((x.length > 3 && x[2] <= x[0] && x[3] >= x[1]) || (x.length > 4 && ((x[3] <= x[1] && x[4] >= x[2]) || (x[3] == x[1] && x[0] + x[4] >= x[2])))) {
            return true;
        }
        for (int i = 5; i < x.length; i++) { //考虑第i条边与第i条边之前的边有没有可能相交
            if (x[i - 1] <= x[i - 3] && ((x[i] >= x[i - 2]) || (x[i - 2] >= x[i - 4] && x[i - 5] + x[i - 1] >= x[i - 3] && x[i - 4] + x[i] >= x[i - 2]))) {
                return true;
            }
        }
        return false;
    }
}
