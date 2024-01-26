package 工作后刷题.zjlab电脑刷题内容.二分查找.二分答案.medium;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: ZBL
 * @Date: 2024-01-24  15:16
 * 可以到达的最远建筑(medium)
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * <p>
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * <p>
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * <p>
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 输出：4
 * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
 * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
 * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
 * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
 * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
 * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
 * 示例 2：
 * <p>
 * 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * 输出：7
 * 示例 3：
 * <p>
 * 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 */
public class Code1642 {

    //方法一：二分查找的方式
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int right = heights.length - 1, left = 0;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(heights, mid, bricks, ladders)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] heights, int targetIdx, int bricks, int ladders) {
        int[] diff = new int[targetIdx + 1];
        for (int i = 1; i <= targetIdx; i++) {
            diff[i] = heights[i] - heights[i - 1];
        }
        Arrays.sort(diff);
        for (int i = targetIdx; i >= 0; i--) {
            if (diff[i] > 0 && ladders > 0) {
                ladders--;
            } else if (diff[i] > 0) {
                if (bricks >= diff[i]) {
                    bricks -= diff[i];
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //方法二：优先级队列+贪心
    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];

            if (diff > 0) {
                ladders--;
                priorityQueue.add(diff);
                if (ladders < 0) {
                    int min = priorityQueue.poll();
                    if (bricks >= min) {
                        bricks -= min;
                        ladders++;
                    } else {
                        return i - 1;
                    }
                }
            }
        }
        return heights.length - 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 7, 6, 9, 14, 12};
        int bricks = 5, ladders = 1;
        System.out.println(new Code1642().furthestBuilding(arr, bricks, ladders));
    }
}
