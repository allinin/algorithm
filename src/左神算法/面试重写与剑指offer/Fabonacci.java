package 左神算法.面试重写与剑指offer;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 斐波那契数列的非递归实现
 * @date 2020/3/21 15:18
 */
public class Fabonacci {

    public static int fabonacci(int index){
        if(index==1)
            return 1;
        if(index==2)
            return 2;
        int nowMinuOne=2;
        int nowMinusTwo=1;
        int now=0;
        for(int i=3;i<=index;i++){
            now=nowMinuOne+nowMinusTwo;
            nowMinusTwo=nowMinuOne;
            nowMinuOne=now;
        }
        return now;
    }
}
