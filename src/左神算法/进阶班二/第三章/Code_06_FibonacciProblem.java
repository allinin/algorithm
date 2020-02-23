package 左神算法.进阶班二.第三章;

/**
 * @author zbl
 * @version 1.0
 * @content:斐波那契系列问题的递归和动态规划
【题目】
给定整数N，返回斐波那契数列的第N项。
【补充题目1】
给定整数N，代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法。
【举例】
N=3，可以三次都跨1个台阶；也可以先跨2个台阶，再跨1个台阶；还可以先跨1个台阶，再跨2个台阶。所以有
三种走法，返回3。
【补充题目2】
假设农场中成熟的母牛每年只会生1头小母牛，并且永远不会死。第一年农场有1只成熟的母牛，从第二年开始，
母牛开始生小母牛。每只小母牛3年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量。
 * @date 2020/2/19 15:01
 */
public class Code_06_FibonacciProblem {

    //斐波那契数列
    public static int f1(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return 1;
        return f1(n-1)+f1(n-2);
    }
    //非递归方式实现
    public static int f2(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return 1;
        int res=1;
        int temp=0;
        int pre=1;
        for(int i=3;i<=n;i++){
            temp=res;
            res=res+pre;
            pre=temp;
        }
        return res;
    }

    public static int f3(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return 1;
        int[][]base={{1,1},{1,0}};
        int[][] res=matrixPower(base,n-2);
        return res[0][0]+res[0][1];
    }

    /*
    题目二台阶问题
     */
    //递归方式
    public static int s1(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return n;
        return s1(n-1)+s1(n-2);
    }
    //非递归方式
    public static int s2(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return n;

        int temp=0;
        int res=2;
        int pre=1;
        for(int i=3;i<=n;i++){
            temp=res;
            res=res+pre;
            pre=temp;
        }
        return res;
    }

    //矩阵乘法的方式
    public static int s3(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return n;
        int[][] base = { { 1, 1 }, { 1, 0 } };
        int[][] res = matrixPower(base, n - 2);
        return 2 * res[0][0] + res[1][0];
    }

    /*
      生小牛问题
     */

    //递归实现
    public static int c1(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2 || n==3)
            return n;
        return c1(n-1)+c1(n-3);
    }

    //非递归实现
    public static int c2(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2 || n==3)
            return n;
        //以下方式和左神的实现不同
        int temp1=3;
        int temp2=2;
        int temp3=1;
        int res=0;
        for(int i=4;i<=n;i++){
            res=temp1+temp3;
            temp3=temp2;
            temp2=temp1;
            temp1=res;

        }
        return res;
    }

    //矩阵的方式实现
    public static int c3(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2 || n==3)
            return n;
        int[][] base={{1,1,0},{0,0,1},{1,0,0}};
        int[][] res = matrixPower(base, n - 3);
        return 3*res[0][0]+2*res[1][0]+res[2][0];
    }



    private static int[][] matrixPower(int[][] base, int p) {
        int[][]res=new int[base.length][base[0].length];
        for(int i=0;i<res.length;i++){
            res[i][i]=1; //单位矩阵
        }
        int[][] temp=base;
        for(;p!=0;p>>=1){
            if((p & 1)!=0){
                res=multiMatrix(res,temp);
            }
            temp=multiMatrix(temp,temp);
        }
        return res;

    }

    //矩阵乘法运算
    private static int[][] multiMatrix(int[][] m1,int[][]m2){
        int[][] res=new int[m1.length][m2[0].length];
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m2[0].length;j++){
                for(int k=0;k<m2.length;k++){
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }






    public static void main(String[] args) {
        int n = 23;
        System.out.println(f1(n));
        System.out.println(f2(n));
        System.out.println(f3(n));
        System.out.println("===");

        System.out.println(s1(n));
        System.out.println(s2(n));
        System.out.println(s3(n));
        System.out.println("===");

        System.out.println(c1(n));
        System.out.println(c2(n));
        System.out.println(c3(n));
        System.out.println("===");

    }


}
