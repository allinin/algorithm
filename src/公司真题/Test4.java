package 公司真题;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/4/5 15:53
 */
public class Test4 {
    public static void main(String[] args){
      int[] arr=new int[]{1,3,4,5,7,8,10,11,32,234};
      process(arr,10);
        //System.out.println();


    }


    public static void process(int[] arr,int target){

        int left=0;
        int right=arr.length-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(arr[left]);//得到的是第一个大于等于target的数
        System.out.println(arr[right]);//得到的是第一个小于target的数

    }

    public static int numSquares(int n) {
        int[]dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=n;i++){
            if(i*i<=n)
                dp[i*i]=1;
        }
        for(int i=1;i<=n;i++){
            if(dp[i]==Integer.MAX_VALUE)
                for(int j=1;j<i;j++){
                    dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
                }
        }
        return dp[n];
    }
}
