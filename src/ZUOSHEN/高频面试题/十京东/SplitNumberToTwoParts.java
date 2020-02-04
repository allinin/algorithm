package ZUOSHEN.高频面试题.十京东;

/*
  如果一个数字能够分成两组，其中一组的数字的和等于另一组数字的和，我们就将这个数成为神奇数。判断一个数是否为神奇数
 */
public class SplitNumberToTwoParts {

    public static boolean isMagic(int number){
        int sum=0;
        int temp=number;
        while(number!=0){
            sum+=number%10;//求所有位上的数的和
            number=number/10;
        }
        if((sum & 1)==1){ //奇数一定不是
            return false;
        }
        //只要找到可以达到sum的一半的组合便可
        boolean[] dp=new boolean[sum/2+1];//使用一个一维数组滚动刷新来实现
        sum=sum/2;
        dp[0]=true;
        while(temp!=0){
            int cur=temp%10;
            for(int i=sum;i>-1;i--){//数组从右往左滚动刷新
                dp[i]=dp[i] || (i-cur>=0 ? dp[i-cur]:false);
            }
            if(dp[sum]){
                return true;
            }
            temp=temp/10;
        }
        return false;
    }


    public static void main(String[] args) {
        int test = 2544;
        System.out.println(isMagic(test));
    }
}
