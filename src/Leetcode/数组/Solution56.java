package Leetcode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/8 21:24
 */
public class Solution56 {

    public static int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return intervals;
        Arrays.sort(intervals,(a, b)->{return a[0]-b[0];});//根据每一个子数组的第一个元素的大小从小到大排序
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        int index=0;
        while(index<n){
            int[] help=new int[2];
            help[0]=intervals[index][0];
            int max=intervals[index][1];
            //因为后面涉及到了index+1,所以需要满足index+1<n
            while(index+1<n && (max>=intervals[index+1][0] || max>=intervals[index+1][1])){
                index++;
                if(max<intervals[index][1])
                    max=intervals[index][1];
            }
            index++;//都得需要++
            help[1]=max;
            list.add(help);
        }
        int[][] res=new int[list.size()][2];
        index=0;
        for(int[] tmp:list){
            res[index++]=tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(arr);

    }
}
