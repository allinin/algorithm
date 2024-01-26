package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  14:31
 * <p>
 * 节点间通路。
 * 给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * 示例2:
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * 提示：
 * <p>
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 */
public class Code0401 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] matrix = new List[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
        }
        for (int[] arr : graph) {
            matrix[arr[0]].add(arr[1]);
        }
        boolean[] visited = new boolean[n];
        visited[start] = true;
        return bfs(start, target, matrix, visited);
    }

    private boolean bfs(int start, int end, List<Integer>[] matrix, boolean[] visited) {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.add(start);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int idx = deque.poll();
                for (int next : matrix[idx]) {
                    if (next == end) {
                        return true;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        deque.add(next);
                    }
                }
            }
        }
        return false;
    }

}
