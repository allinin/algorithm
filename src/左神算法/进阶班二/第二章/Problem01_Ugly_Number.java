package 左神算法.进阶班二.第二章;

/**
 * @author zbl
 * @version 1.0
 * @content: 求第n个丑数
 * @date 2020/2/15 19:30
 */
public class Problem01_Ugly_Number {

    public static int uglyNumber1(int index){
        int num=0;
        int count=0;
        while(count<index){
            num++;
            if(isUgly(num)){
                count++;
            }
        }
        return num;
    }

    public static boolean isUgly(int num){
        //消除num所有的因子2
        while(num%2==0){
            num/=2;
        }
        while(num%3==0){
            num/=3;
        }
        while(num%5==0){
            num/=5;
        }
        return num==1 ? true:false;
    }

    public static int uglyNumber2(int n) {
        int[] help = new int[n];
        help[0] = 1;
        int i2 = 0;//表示可能*2的位置，一开始在最开始的位置
        int i3 = 0;//表示可能*3的位置，一开始在最开始的位置
        int i5 = 0;//表示可能*5的位置，一开始在最开始的位置
        int index = 1;
        while (index < n) {
            help[index] = Math.min(2 * help[i2], Math.min(3 * help[i3], 5 * help[i5]));
            if (help[index] == 2 * help[i2])//下一个数来自可能*2的位置，那么再下一个可能*2的位置就到下一个数的位置了
                i2++;
            if (help[index] == 3 * help[i3])
                i3++;
            if (help[index] == 5 * help[i5])
                i5++;
            index++;
        }
        return help[index - 1];
    }

    public static void main(String[] args) {
        int test = 8;
        System.out.println(uglyNumber1(test));
        System.out.println(uglyNumber2(test));
    }

}
