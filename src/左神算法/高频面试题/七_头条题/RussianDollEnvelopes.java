package 左神算法.高频面试题.七_头条题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zbl
 * @version 1.0
 * @content: You have a number of envelopes with widths and heights given as a pair of integers(w,h).One envelope can fit into another if and
 * only if both the width and height of one envelops is greater than the width and height of the other envelop.What is the maximum number of
 * envelopes can you Russian doll?(put one inside other)
 * @date 2020/1/16 11:30
 */
public class RussianDollEnvelopes {

    public  static class Node{
        public int width;
        public int height;

        public Node(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
     //排序后求最长递增子序列的长度，即是答案
    public static class DotComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.width!=o2.width){
                return o1.width-o2.width;
            }else {
                return o2.height-o1.height;
            }
        }
    }
    public static int maxEnvelopes(int[][]es){
        if(es==null || es.length==0 || es[0]==null || es[0].length==0){
            return 0;
        }
        Node[] dots=new Node[es.length];
        for(int i=0;i<es.length;i++)
        {
            dots[i]=new Node(es[i][0],es[i][1]);
        }

        Arrays.sort(dots,new DotComparator());
        int[] ends=new int[dots.length];//最小结尾子数组
        ends[0]=dots[0].height;
        int right=0;
        int l=0;
        int r=0;
        int m=0;
        for(int i=1;i<es.length;i++){
            l=0;
            r=right;
            //找到第一个大于等于dots[i]的值
            while(l<=r){
                m=(l+r)/2;
                if(dots[i].height>ends[m]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            right=Math.max(right,l);
            ends[l]=dots[i].height;
        }
        return right+1;

    }

    public static void main(String[] args) {
        int[][] test = { { 4, 3 }, { 1, 2 }, { 5, 7 }, { 5, 3 }, { 1, 1 }, { 4, 9 } };
        System.out.println(maxEnvelopes(test));
    }
}
