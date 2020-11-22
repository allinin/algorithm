package Leetcode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution937 {

    public int[][] kClosest(int[][] points, int K) {
        if(points==null || points.length==0) return new int[0][0];
        int n=points.length;
        if(n<=K) return points;
        int[][] res=new int[K][2];
        int[] help=new int[n];//记录第i个点距离远点的距离的平方
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int x=points[i][0] * points[i][0];
            int y=points[i][1] * points[i][1];
            help[i]=x+y;
            if(map.containsKey(help[i])){
                List<Integer>list=map.get(help[i]);
                list.add(i);
                map.put(help[i],list);
            }else{
                List<Integer>list=new ArrayList<>();
                list.add(i);
                map.put(help[i],list);
            }
        }
        Arrays.sort(help);
        for(int i=0;i<K;i++){
            int target=help[i];
            List<Integer> list=map.get(target);
            for(Integer num :list){
                if(i<K){
                    res[i][0]=points[num][0];
                    res[i][1]=points[num][1];
                    i++;
                }else {
                    return res;
                }
            }
            --i;
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] nums={{3,3},{5,1},{-2,4}};
        new Solution937().kClosest(nums,2);
    }
}
