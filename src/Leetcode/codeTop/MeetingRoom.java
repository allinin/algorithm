package Leetcode.codeTop;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * codeTop中的会议室题目，分为会议室I与会议室II两个题目
 * 一、会议室I:LeetCode 252
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
 *
 * 示例 1:
 * 输入: [[0,30],[5,10],[15,20]]
 * 输出: false
 *
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: true
 *
 * 二、会议室II:leetCode 253
 *给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: 1

 */
public class MeetingRoom {


    public static void main(String[] args) {

    }

    /**
     * 会议室I
     * @param matrix
     * @return
     */
    public static boolean meetingRoom1(int[][] matrix){
        if(matrix == null || matrix.length < 2){
            return true;
        }
        Arrays.sort(matrix,(a,b) ->{return a[0] - b[0];});
        int last = matrix[0][1];
        for(int i = 1;i < matrix.length;i++){
            if(last > matrix[i][0]){
                return false;
            }
            last = matrix[i][1];
        }
        return true;

    }

    /**
     * 会议室II
     * @param matrix
     * @return
     */
    public static int meetingRoom(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return  0;
        }
        Arrays.sort(matrix,(a,b) ->{return a[0] - b[0];});
        //保存当前正在开会的结束时间,queue中元素的个数即表示当前需要的会议室的数量
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for(int[] arr : matrix){
            //当前要开的会是arr,如果当前要开的会的开始时间大于正在开的会的结束时间，则表示正在开的会已经结束，可以和将要开的会公用一个会议室
            while(!queue.isEmpty() && queue.peek() <= arr[0]){
              queue.poll();
            }
            queue.add(arr[1]);
            ans = Math.max(ans,queue.size());
        }
        return ans;

    }
}
