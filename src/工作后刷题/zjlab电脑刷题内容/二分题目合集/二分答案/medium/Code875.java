package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-27  14:04
 * <p>
 * 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class Code875 {
    public int minEatingSpeed(int[] piles, int h) {
        //可能的速度在最大速度与最小速度之间，注意最小值的初始值选取
        int min = 1, max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        while(min < max) {
            int mid = min + (max - min) / 2;
            if(check(piles,mid,h)) {
                max = mid;
            } else {
                //即取mid的速度不能符合要求
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean check(int[] piles,int speed,int h) {
        int sum = 0;
        for(int pile : piles) {
            sum += pile / speed;
            if(pile % speed != 0) {
                sum += 1;
            }
        }
        return  sum <= h;
    }

    public static void main(String[] args) {
        System.out.println(new Code875().minEatingSpeed(new int[]{30,11,23,4,20},6));
    }
}
