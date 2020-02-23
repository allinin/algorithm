package 左神算法.进阶班二.第四章;

/**
 * @author zbl
 * @version 1.0
 * @content:题目二
调整[0,x)区间上的数出现的概率
【题目】
假设函数Math.random()等概率随机返回一个在[0,1)范围上的
数，那么我们知道，在[0,x)区间上的数出现的概率为x
（0<x≤1）。给定一个大于0的整数k，并且可以使用
Math.random()函数，请实现一个函数依然返回在[0,1)范围上
的数，但是在[0,x)区间上的数出现的概率为xk(0<x≤1)。
 * @date 2020/2/21 16:35
 */
public class Code_02_ProbabilityXPowerK {

    public static double rankXPowerK(int k){
        if(k<1)
            return 0;
        double res=-1;
        for(int i=0;i!=k;i++){
            res=Math.max(res,Math.random());
        }
        return res;
    }

    public static void main(String[] args) {
        double range=0.5;
        int times=500000;
        int count=0;
        for(int i=0;i!=times;i++){
            if(rankXPowerK(2)<range){
                count++;
            }
        }
        double p=(double)count/(double)times;
        System.out.println(p);

    }
}
