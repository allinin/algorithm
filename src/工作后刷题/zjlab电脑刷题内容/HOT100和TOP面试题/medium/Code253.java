package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 会议室II
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 */
public class Code253 {

    public int solution(int[][] meetings) {
        int ans = 0;
        if (meetings == null || meetings.length == 0) {
            return ans;
        }
        //按照开始时间从小到达排序
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        //构架小顶堆,存放会议结束时间
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        //先分配一个会议室用于第一个会议
        priorityQueue.add(meetings[0][1]);
        for (int i = 1; i < meetings.length; i++) {
            if (priorityQueue.peek() < meetings[i][0]) {
                //如果当前的最小会议结束时间小于下一个会议的开始时间，说明可以复用已有的会议室
                priorityQueue.poll();
            }
            //当前会议的结束时间加入到优先级队列
            priorityQueue.add(meetings[i][1]);
        }
        return priorityQueue.size();
    }
}
