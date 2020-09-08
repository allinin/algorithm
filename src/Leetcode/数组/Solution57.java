package Leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/9/1 10:57
 */
public class Solution57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval==null || newInterval.length==0) return intervals;
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        int index=0;

        int max=Integer.MIN_VALUE;
        while(index<n){
            int[] help=new int[2];
            help[0]=intervals[index][0];
            help[1]=intervals[index][1];
            max=intervals[index][1];
            boolean flag=false;
            while(newInterval[0]<=max){
                help[0]=Math.min(help[0],newInterval[0]);
                help[1]=Math.max(help[1],newInterval[1]);
                if(max==intervals[index][1]){
                    flag=true;
                    break;
                }else{
                    newInterval[0]=help[0];
                    if(index<n-1)
                        max=intervals[index++][1];
                    else
                        break;
                }
            }
            if(flag){
                index++;
                list.add(help);
                break;
            }
            list.add(help);

        }
        while(index<n){
            list.add(intervals[index++]);
        }
        int[][] res=new int[list.size()][2];
        index=0;
        for(int[] arr :list){
            res[index][0]=arr[0];
            res[index++][1]=arr[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval={4,8};
        insert(matrix,newInterval);
    }
}
