package ZUOSHEN.基础班.动态规划与递归;

/**
 * 题目描述：给你一个数组 arr,和一个整数aim,如果可以选择任意arr的数字，能不能累加得到aim,返回true or false
 */
public class MoneyProblem {

    //暴力递归版本,i表示当前数组的元素的位子，sum表示当前计算的和，
    public static boolean process1(int[] arr,int i,int sum,int aim)
    {
        if(sum==aim)
            return true;
        if(i==arr.length)
            return false;
        return process1(arr,i+1,sum,aim) || process1(arr,i+1,sum+arr[i],aim);//和子序列问题类似，要或者不要当前的值，在不选择当前i位置的值时
                                                                                          //sum不变，选择了当前i位置的值时，i+1位置的sum变为sum+arr[i]
    }
    public static boolean money1(int[] arr,int aim)
    {
        return process1(arr,0,0,aim);
    }

    //动态规划版本
    public static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    //动态规划2，假设只用正数
    public static boolean money3(int[] arr,int aim)
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            count+=arr[i];
        }
        if(count<aim)
            return false;
        boolean[][] dp=new boolean[arr.length+1][count+1];
        for(int i=0;i<=count;i++)
        {
            if(i!=aim)
            dp[arr.length][i]=false;
            else
                dp[arr.length][i]=true;
        }
        for(int i=arr.length-1;i>=0;i--)
        {
            for(int j=0;j<=count;j++)
            {
                dp[i][j]=dp[i+1][j] || dp[i][j+arr[i]];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 ,2,3,4,54,5,3};
        int aim = 65;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }

}
