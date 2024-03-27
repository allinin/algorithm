package 工作后刷题.zjlab电脑刷题内容.社招面试题目;

import java.util.PriorityQueue;

/**
 * @Author: ZBL
 * @Date: 2024-03-11  09:03
 * <p>
 * 给定两个数组，两个数组的元素求和，输出求和结果最大的前k个元素,其中数组有序
 * 例如：
 * int[] a = {1, 2, 3, 4, 5}
 * int[] b = {2, 3, 4, 5, 6}
 * k = 3
 * 结果为：[11,10,10]
 */
public class XieChengMianShiTi_ {


    // o(klogk)
    public static int[] process(int[] arr1, int[] arr2, int k) {
        int[] ans = new int[k];
        int n1 = arr1.length, n2 = arr2.length;
        //int[]记录arr1,arr2的索引
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (arr1[a[0]] + arr2[a[1]] > arr1[b[0]] + arr2[b[1]]) {
                return -1;
            } else if (arr1[a[0]] + arr2[a[1]] < arr1[b[0]] + arr2[b[1]]) {
                return 1;
            }
            return 0;
        });
        //最大的元素一定是arr1最后一个元素+arr2最后一个元素
        priorityQueue.add(new int[]{n1 - 1, n2 - 1});
        //表示arr1 i位置的元素，arr2 j位置的元素是否已经处理
        boolean[][] visited = new boolean[n1][n2];

        int idx = 0;
        while (k > 0) {
            int[] top = priorityQueue.poll();
            ans[idx++] = arr1[top[0]] + arr2[top[1]];
            visited[top[0]][top[1]] = true;

            if (top[0] - 1 >= 0 && !visited[top[0] - 1][top[1]]) {
                priorityQueue.add(new int[]{top[0] - 1, top[1]});
            }
            if (top[1] - 1 >= 0 && !visited[top[0]][top[1] - 1]) {
                priorityQueue.add(new int[]{top[0], top[1] - 1});
            }

            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {2, 3, 4, 5, 6};
        int k = 5;
        int[] ans = process(arr1, arr2, k);
        for(int num : ans) {
            System.out.println(num);
        }
    }
}
