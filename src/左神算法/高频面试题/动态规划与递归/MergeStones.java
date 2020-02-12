package 左神算法.高频面试题.动态规划与递归;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。

每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。

找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。



示例 1：

输入：stones = [3,2,4,1], K = 2
输出：20
解释：
从 [3, 2, 4, 1] 开始。
合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
合并 [4, 1]，成本为 5，剩下 [5, 5]。
合并 [5, 5]，成本为 10，剩下 [10]。
总成本 20，这是可能的最小值。

示例 2：

输入：stones = [3,2,4,1], K = 3
输出：-1
解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.

示例 3：

输入：stones = [3,5,1,2,6], K = 3
输出：25
解释：
从 [3, 5, 1, 2, 6] 开始。
合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
合并 [3, 8, 6]，成本为 17，剩下 [17]。
总成本 25，这是可能的最小值。



提示：

1 <= stones.length <= 30
2 <= K <= 30
1 <= stones[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-cost-to-merge-stones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/2/8 9:44
 */
public class MergeStones {

    public static int mergeStones(int[] stones, int K) {
        if(K>stones.length)
            return 0;
        int len=stones.length;
        while(len!=0 && len!=K && K!=2){
            len-=(K-1);
            if(len<K)
                return -1;
        }
        return process(stones,K,stones.length-1);
    }
    //合并石头递归版本，超时了！！！
    public static int process(int[] arr,int k,int end){//start,end表示数组饿开始和结束下标


        if(k==end+1){
            int res=0;

            for(int i=0;i<=end;i++)
                res+=arr[i];
            return res;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=end-k+1;i++){
            int m=i;
            int res=0;

            for(int j=i;j<k+i;j++){
                res+=arr[j];
            }
            int[] stones=new int[end-k+2];
            for(int l=0;l<m;l++)
            {
                stones[l]=arr[l];
            }
            stones[m]=res;
            for(int l=m+1;l<=end-k+1;l++){
                stones[l]=arr[l+k-1];
            }
            ans=Math.min(ans,res+process(stones,k,end-k+1));

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{26,88,89,24,74,73,69,2,59,58,89,75,94

};
        System.out.println(mergeStones(arr,3));
    }
}
