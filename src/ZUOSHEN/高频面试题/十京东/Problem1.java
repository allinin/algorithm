package ZUOSHEN.高频面试题.十京东;
/*
 有一个无限长的数字序列：1、2、2、3、3、3……(数字k在该序列中正好出现k次)，求这个数组序列的第n项是多少。
 */
public class Problem1 {
    public static int getNumber(long n){
        return (int)Math.ceil((Math.sqrt(1+8*(double)n)-1)/2);
    }
}
