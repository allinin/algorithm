package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2023-12-27  14:07
 * <p>
 * 课程表II
 * <p>
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，
 * 表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 */
public class Code210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        int[] du = new int[numCourses];
        Set<Integer>[] graph = new Set[numCourses];
        //必须依次进行填充
        for(int i = 0;i < numCourses;i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] prequisity : prerequisites) {
            //记录依赖a[1]的课程有哪些
            graph[prequisity[1]].add(prequisity[0]);
            //a[0]的入度+1
            du[prequisity[0]]++;
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < du.length; i++) {
            //du[i] == 0说明i课程不依赖任何其他的课程
            if (du[i] == 0) {
                deque.add(i);
            }
        }
        while(!deque.isEmpty()) {
            Integer course = deque.poll();
            list.add(course);
            //依赖course的课程
            for(Integer num : graph[course]) {
                //入度-1
                if(--du[num] == 0) {
                    deque.add(num);
                }
            }
        }
        if(list.size() == numCourses) {
            int[] ans = new int[list.size()];
            for(int i = 0;i < numCourses;i++) {
                ans[i] = list.get(i);

            }
            return ans;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] order = new Code210().findOrder(3, new int[][]{{1,0},{1,2},{0,1}});
        for(int num : order) {
            System.out.print(num + " ");
        }
    }
}
