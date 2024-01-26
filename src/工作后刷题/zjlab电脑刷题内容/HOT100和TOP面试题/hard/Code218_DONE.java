package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  14:23
 * 天际线问题
 * <p>
 * 城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。
 * <p>
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * <p>
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。
 * <p>
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * <p>
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 * 示例 2：
 * <p>
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings 按 lefti 非递减排序
 */
public class Code218_DONE {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> help = new ArrayList<>();
        for (int[] building : buildings) {
            help.add(new int[]{building[0], -building[2]});//负的表示左边界
            help.add(new int[]{building[1], building[2]});//正数代表与之对应的有边界
        }
        //按照左边从小到达排序，在坐标相同的情况下，高度递减排序
        Collections.sort(help, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            //考虑左边界，因为左边界都是负数，所以从小到达排序等价于从大到小
            return a[1] - b[1];
        });
        //用来盛放高度的大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.add(0);//针对两个矩形之间有空隙的情况，此时需要插入0
        int preHeight = 0;
        for (int[] nums : help) {
            //碰到左边界，高度入队列
            if (nums[1] < 0) {
                priorityQueue.add(nums[1] * (-1));
            } else {
                //碰到有边界，说明当前矩形遍历结束，高度出边界
                priorityQueue.remove(nums[1]);
            }
            if (priorityQueue.peek() != preHeight) {
                ArrayList list = new ArrayList();
                list.add(nums[0]);
                list.add(priorityQueue.peek());
                res.add(list);
                preHeight = priorityQueue.peek();
            }
        }
        return res;
    }

    //优化出队列的情况
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> help = new ArrayList<>();
        for (int[] building : buildings) {
            help.add(new int[]{building[0], -building[2]});//负的表示左边界
            help.add(new int[]{building[1], building[2]});//正数代表与之对应的有边界
        }
        //按照左边从小到达排序，在坐标相同的情况下，高度递减排序
        Collections.sort(help, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            //考虑左边界，因为左边界都是负数，所以从小到达排序等价于从大到小
            return a[1] - b[1];
        });
        //用来盛放高度的大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.add(0);//针对两个矩形之间有空隙的情况，此时需要插入0
        Map<Integer, Integer> map = new HashMap<>();//记录需要删除的元素的次数
        int preHeight = 0;
        for (int[] nums : help) {
            //碰到左边界，高度入队列
            if (nums[1] < 0) {
                priorityQueue.add(nums[1] * (-1));
            } else {
                //碰到有边界，说明当前矩形遍历结束，并且当前矩形的高度是最大高度，出边界
                if (priorityQueue.peek().equals(nums[1])) {
                    priorityQueue.poll();
                    //弹出顶部后，如果当前顶是需要删除的元素，则继续弹出
                    while (map.getOrDefault(priorityQueue.peek(), 0) > 0) {
                        int peek = priorityQueue.poll();
                        map.put(peek, map.get(peek) - 1);
                    }
                } else {
                    map.put(nums[1], map.getOrDefault(nums[1], 0) + 1);
                }
            }

            if (priorityQueue.peek() != preHeight) {
                ArrayList list = new ArrayList();
                list.add(nums[0]);
                list.add(priorityQueue.peek());
                res.add(list);
                preHeight = priorityQueue.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> skylines = new Code218_DONE().getSkyline(nums);
        for (List<Integer> sky : skylines) {
            for (Integer num : sky) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        int[][] nums2 = {{0, 2, 3}, {2, 5, 3}};
        List<List<Integer>> skylines2 = new Code218_DONE().getSkyline(nums2);
        for (List<Integer> sky : skylines2) {
            for (Integer num : sky) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
