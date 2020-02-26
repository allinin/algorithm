package 左神算法.进阶班二.第五章;

/**
 * @author zbl
 * @version 1.0
 * @content:某游戏是一个卡牌类游戏，玩家通过战斗或抽牌可以拿到一些
技能牌，每张技能牌都有对应的伤害值(伤 害值>=0)，当你有
了组合技属性之后，你可以在自己手头上选择任意张技能牌，
以组合技的方式来攻击 boss，组合技的总伤害将等于所组合的
各张技能牌的伤害值的乘积(只有一张牌时，组合技伤害值等于
这张牌 本身的伤害值)，但是能发动组合技必须有个前提:所有
被选择的技能牌的伤害系数之和必须等于m(m>0) 以解开封印;
你为了能赢得最终胜利，需要在所有技能牌中挑出若干张技能
牌触发组合技(每张牌只能用一 次)，以形成最大威力的组合技
攻击效果。 例如:你有伤害值分别为1,2,3,4,5的五张牌，给定
的解开封印的阈值(m)为10，那形成最大组合攻击效果 的组合
为30(5*3*2)，而不是24(4*3*2*1)，也不是20(5*4*1)，需要输
出的结果即30。
 * @date 2020/2/24 16:03
 */
public class Code_02_Max_Damage {

    //递归的方式
    public static int getMax(int[] arr,int sum){
        return process(arr,0,sum);
    }

    //arr中都是正数，表示可以选取数组中index位置及其之后的元素
    public static int process(int[] arr,int index,int sum){

        if(sum<0)
            return -1;
        if(index==arr.length){
            return sum==0 ? 1:-1;
        }

        int nonInclu=process(arr,index+1,sum);//不选取当前位置的值
        int inclu=arr[index]*process(arr,index+1,sum-arr[index]);//选取当前位置的值
        return Math.max(inclu,nonInclu);
    }


    //动态规划的方式
    public static int maxDamage(int[] arr,int sum){
        if(arr==null || arr.length==0)
            return 0;
        int[][] dp=new int[arr.length+1][sum+1];
        dp[arr.length][0]=1;
        for(int i=1;i<=sum;i++){
            dp[arr.length][i]=-1;
        }
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<=sum;j++){
                int noInclu=dp[i+1][j];
                int only=j-arr[i]==0 ?arr[i]:0;
                int inclu=j-arr[i]>0 ? arr[i]*dp[i+1][j-arr[i]]:0;
                dp[i][j]=Math.max(only,Math.max(noInclu,inclu));
            }
        }
        return dp[0][sum];
    }

    public static void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int threshold = 11;
        System.out.println(maxDamage(arr, threshold));
        System.out.println(getMax(arr,threshold));
    }
}
