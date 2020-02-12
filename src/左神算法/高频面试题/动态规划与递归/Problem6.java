package 左神算法.高频面试题.动态规划与递归;

/**
 * @author zbl
 * @version 1.0
 * @content:阿里题：有n个气球，编号为0到n-1,每个气球上都标有一个数字，这些数字存在数组nums中，现在要求你戳破所有的气球。每当你戳破一个气球i时，你可以获得
 * nums[left]*nums[i]*nums[right]个硬币。这里的left和right代表i相邻的两个气球的编号。注意当你戳破了气球i后，气球left和气球right就变成了相邻的气球了，求能获得最大的硬币数量
 * 你可以假设nums[-1]=nums[n]=1,但是他们不是真正存在的，所以不能被戳破
 * @date 2020/1/10 10:56
 */
public class Problem6 {

    public static int maxCoins1(int[] arr){
        if(arr==null || arr.length==0)
            return 0;
        if(arr.length==1){
            return arr[0];
        }
        int [] help=new int[arr.length+2];
        help[0]=1;
        help[help.length-1]=1;
        for(int i=0;i<arr.length;i++){
            help[i+1]=arr[i];
        }
        return process(help,1,help.length-2);
    }

    public static int process(int[] arr,int l,int r){//总有一个气球被最后打破，穷举所有的情况，找出其中最大的情况。l:表示最左边的气球的位置，r:表示最右边的气球的位置
        if (l == r) {
            return arr[l - 1] * arr[l] * arr[r + 1];
        }

        int res=Math.max(arr[l-1]*arr[l]*arr[r+1]+process(arr,l+1,r),
                arr[l-1]*arr[r]*arr[r+1]+process(arr,l,r-1));//最后打l或者r的情况
        for(int i=l+1;i<r;i++){
            res=Math.max(res,process(arr,l,i-1)+process(arr,i+1,r)+arr[l-1]*arr[i]*arr[r+1]);
        }
        return res;//res即为动态规划中的dp[i][j]
    }


    //动态规划
    public static int maxCoins2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int[] all = new int[size + 2];
        all[0] = 1;
        all[size + 1] = 1;
        for (int i = 0; i < size; i++) {
            all[i + 1] = arr[i];
        }
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; i--) {
            dp[i][i] = all[i] * all[i + 1] * all[i + 2];
            for (int j = i + 1; j < size; j++) {
                int coins = 0;
                for (int k = i; k <= j; k++) {
                    coins = all[i] * all[k + 1] * all[j + 2];
                    coins += k != i ? dp[i][k - 1] : 0;
                    coins += k != j ? dp[k + 1][j] : 0;
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[0][size - 1];
    }



    public static void main(String[] args) {
        int[] arr = { 3, 2, 6, 4, 2, 3, 4, 7, 9 };
        System.out.println(maxCoins1(arr));
        System.out.println(maxCoins2(arr));
    }

}
