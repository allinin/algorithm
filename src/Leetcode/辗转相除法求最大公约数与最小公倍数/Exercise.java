package Leetcode.辗转相除法求最大公约数与最小公倍数;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/5/2 22:58
 */
public class Exercise {

    //辗转相除法求a与b的最大公约数
    public int getMax(int a,int b){
        //使a等于a,b中较大的那个
        if(a<b){
            int m=a;
            a=b;
            b=a;
        }
        while(b!=0){
            int tmp=a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
    //求a与b的最小公倍数
    public int getMin(int a,int b){
        int tmp = getMax(a, b);
        return a*b/tmp;
    }
}
