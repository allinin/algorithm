package 左神算法.进阶班二.第五章;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:你的王国里有n条龙，你希望雇佣一些勇士把它们杀死，王国里一共有m个骑士
可以雇佣。假定，一个能力值 为x的骑士可以打败战斗力不超过x的恶龙，且
需要支付x个金币。已知勇士可以重复雇佣，且重复雇佣需要重 复支付金币，
请求出打败所有的恶龙需要的最小金币数目。 例如，你的王国里有三条龙，
战斗力分别为10，11，20，同时有三个勇士可以雇佣，能力值分别为
20,12,30，最省钱的方式是能力值12的勇士攻击战斗力10的龙，能力值12的勇
士攻击战斗力11的龙，能力值 20的勇士攻击战斗力20的龙，总共付出44金币。
进阶：
一条龙可以被勇士合力杀死，求付出的金币数
举例：
int[] knights = { 2, 10, 5 };
int[] dragons = { 3, 8, 6 };
原问题标准下应返回：25
进阶的标准下应返回：22
 * @date 2020/2/24 16:04
 */
public class Code_03_Min_Gold {


    public static int minGold1(int[] knights,int[] dragons){
        Arrays.sort(knights);
        int res=0;
        for(int i=0;i<dragons.length;i++){
            int cost=getMaxLeftMost(knights,dragons[i]);
            if(cost!=Integer.MAX_VALUE)
            {
                res+=cost;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        return res;
    }

    //二分查找法，找到恰好大于等于dragon的值。
    public static int getMaxLeftMost(int[] sortedArr, int dragon) {
        int L = 0;
        int R = sortedArr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (sortedArr[mid] < dragon) {
                L = mid + 1;
            } else { //找到第一个大于等于dragon的递归写法。
                index = mid;
                R = mid - 1;
            }
        }
        return index == -1 ? Integer.MAX_VALUE : sortedArr[index];
    }

    //进阶：
    public static int minGold2(int[] knights,int[] dragons){
        int sum=0;
        for(int i=0;i<knights.length;i++){
            sum+=knights[i];
        }
        int[][] dp=new int[knights.length][sum+1];
        dp[0][knights[0]]=knights[0];
        for(int i=1;i<knights.length;i++){
            for(int j=1;j<=sum;j++){
                if(dp[i-1][j]!=0)
                    dp[i][j]=dp[i-1][j];
                if(j-knights[i]>=0 && dp[i-1][j-knights[i]]!=0)
                    dp[i][j]=knights[i]+dp[i-1][j-knights[i]];
                if(j==knights[i]){
                    dp[i][j]=j;
                }
            }
        }
        int[] help=new int[sum+1];
        for(int i=1;i<=sum;i++){
            if(dp[knights.length-1][i]!=0){
                help[i]=dp[knights.length-1][i];
            }else{
                help[i]=Integer.MAX_VALUE;
            }
        }
        //printArray(help);
        for(int i=sum-1;i>-1;i--){
            help[i]=Math.min(help[i+1],help[i]);
        }
        //printArray(help);
        int res=0;
        for(int i=0;i<dragons.length;i++){
            res+=help[dragons[i]];
        }
        return res;




    }

    // 矩阵压缩，使用一维数组.
    public static int minGold3(int[] knights, int[] dragons) {
        int sum = 0;
        for (int i = 0; i < knights.length; i++) {
            sum += knights[i];
        }
        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[knights[0]] = knights[0];
        // printArray(dp);
        for (int i = 1; i < knights.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - knights[i] >= 0
                        && dp[j - knights[i]] < Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - knights[i]] + knights[i]);
                }
            }
            // printArray(dp);
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i], dp[i + 1]);
        }
         //printArray(dp);
        int res = 0;
        //没有必要再二分查找了
//        for (int i = 0; i < dragons.length; i++) {
//            int cost = getMaxLeftmost(dp, dragons[i]);
//            if (cost == Integer.MAX_VALUE) {
//                return Integer.MAX_VALUE;
//            }
//            res += cost;
//        }
        for(int i=0;i<dragons.length;i++){
            res+=dp[dragons[i]];
        }
        return res;
    }

    public static void printArray(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print((dp[i] == Integer.MAX_VALUE ? "X" : dp[i]) + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int[] knights1 = { 2, 10, 5 };
        int[] dragons1 = { 3, 8, 6 };
        System.out.println(minGold1(knights1, dragons1));

        int[] knights2 = { 2, 10, 5 };
        int[] dragons2 = { 3, 8, 6 };
        System.out.println(minGold2(knights2, dragons2));

        int[] knights3 = { 2, 10, 5 };
        int[] dragons3 = { 3, 8, 6 };
        System.out.println(minGold3(knights2, dragons2));

    }
}
