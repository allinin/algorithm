package 左神算法.进阶班二.第三章;

/**
 * @author zbl
 * @version 1.0
 * @content:【补充题目3】
0左边必有1的二进制字符串数量
【题目描述】
给定一个整数N，求由"0"字符与"1"字符组成的长度为N的所有字符串中，满足"0"字符的左边必有"1"字符的字符
串数量。
【举例】
N=1。只由"0"与"1"组成，长度为1的所有字符串："0"、"1"。只有字符串"1"满足要求，所以返回1。
N=2。只由"0"与"1"组成，长度为2的所有字符串为："00"、"01"、"10"、"11"。只有字符串"10"和"11"满足要求，
所以返回2。
N=3。只由"0"与"1"组成，长度为3的所有字符串为："000"、"001"、"010"、"011"、"100"、"101"、"110"、"111"。
字符串"101"、"110"、"111"满足要求，所以返回3。
 * @date 2020/2/19 15:02
 */
public class Code_07_ZeroLeftOneStringNumber {

    public static int getNum1(int n){
        if(n<1)
            return 0;
        return process(1,n);
    }

    private static int process(int i, int n) { //表示i-1位置为1的情况下，有多少种合法的情况
        if(n==i)
            return 1;
        if(i==n-1)
            return 2;

        return process(i+1,n)+process(i+2,n);
    }

    public static int getNum2(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return n;
        int res=2;
        int pre=1;
        int tmp=0;
        for(int i=3;i<=n;i++){
            tmp=res;
            res=res+pre;
            pre=tmp;
        }
        return res;

    }

    public static int getNum3(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return n;
        int[][]base={{1,1},{1,0}};
       int[][] res=MatrixPower(base,n-2);
       return 2*res[0][0]+res[1][0];

    }

    private static int[][] MatrixPower(int[][] base, int n) {
        int[][]res=new int[base.length][base.length];
        for(int i=0;i<base.length;i++){
            res[i][i]=1;
        }
        int[][] temp=base;
        for(;n!=0;n>>=1){
            if((n&1)!=0)
                res=multiMatrix(res,temp);
            temp=multiMatrix(temp,temp);
        }
        return res;
    }

    private static int[][] multiMatrix(int[][] m1,int[][]m2){

        int[][]res=new int[m1.length][m2[0].length];
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m2[0].length;j++)
                for(int k=0;k<m2.length;k++){
                res[i][j]+=m1[i][k]*m2[k][j];
                }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i != 20; i++) {
            System.out.println(getNum1(i));
            System.out.println(getNum2(i));
            //System.out.println(getNum3(i));
            System.out.println("===================");
        }

    }
}
