package 左神算法.基础班.动态规划与递归;

/**
 * 母牛每年生一个母牛，新出生的母牛成长三年后也能每年生一只母牛，假设不会死，求N年后，母牛的数量
 */
public class Cow {

    //自己多写出几年的情况，找规律,
    public static int cowNumber(int n)
    {
        if(n<1)return 0;
        if(n==1 || n==2 || n==3)
            return n;
        return cowNumber(n-1)+cowNumber(n-3);
    }
    //非递归的写法
    public static int cowNumber2(int n)
    {
        if(n<1) return 0;
        if(n==1 || n==2 || n==3)
            return n;
        int res=3;
        int pre=2;
        int prepre=1;
        int temp1=0;
        int temp2=0;
        for(int i=4;i<=n;i++){
            temp1=res;//保存一下当前的值
            temp2=pre;
            res=res+prepre;
            pre=temp1;
            prepre=temp2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(cowNumber(5));
    }
}
