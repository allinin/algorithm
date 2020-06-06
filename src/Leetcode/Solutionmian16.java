package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。



示例 1:

输入: 2.00000, 10
输出: 1024.00000

示例 2:

输入: 2.10000, 3
输出: 9.26100

示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25



说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/4 9:45
 */
public class Solutionmian16 {
    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==0.0){
            if(n>=0) return 0;
            //throw new Exception("数据不合法");
        }
        boolean flag=false;
        double part=1.0;//当n=Integer.MIN_VALUE的时候，如果取反，则会出现数据丢失的情况
        if(n<0){//将n装变成正数
            flag=true;
            if(n==Integer.MIN_VALUE){
                n=Integer.MAX_VALUE;
                part=x;
            }else{
                n=-n;
            }

        }

        double res=process(x,n);
        return flag ? 1.0/part*res : part*res;

    }
    private  static double process(double x,int n){
        if(n==0)
            return 1.0;
        int m=lowbit(n);
        n-=m;
        double tmp=x;
        while(m!=1){
            tmp=tmp*tmp;
            m/=2;
        }

        return tmp*process(x,n);

    }
    //返回n的最有一个1代表的数的大小
    private  static int lowbit(int n){
        return n & (-n);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.000,-2));
        String str="a good   example";
        String[] split = str.split(" ");
        System.out.println(split.length);
    }
}
