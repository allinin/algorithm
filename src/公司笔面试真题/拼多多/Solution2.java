package 公司笔面试真题.拼多多;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:数列 {An} 为N的一种排列。
例如N=3，可能的排列共6种：
1
2
3
4
5
6
1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
定义函数F:

其中|X|表示X的绝对值。

现在多多鸡想知道，在所有可能的数列 {An} 中，F(N)的最小值和最大值分别是多少。

输入描述:
第一行输入1个整数T，表示测试用例的组数。
( 1 <= T <= 10 )
第二行开始，共T行，每行包含1个整数N，表示数列 {An} 的元素个数。
( 1 <= N <= 100,000 )

输出描述:
共T行，每行2个整数，分别表示F(N)最小值和最大值

输入例子1:
2
2
3

输出例子1:
1 1
0 2

例子说明1:
对于N=3：
- 当{An}为3，2，1时可以得到F(N)的最小值0
- 当{An}为2，1，3时可以得到F(N)的最大值2
 * @date 2020/7/29 20:32
 */
public class Solution2{

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            long[] nums=new long[n];//因为有可能越界，所以这里设置成long类型
            for(int i=0;i<n;i++){
                nums[i]=sc.nextLong();
            }
            for(int i=0;i<n;i++){
                long[] res=process(nums[i]);
                System.out.println(res[0]+" "+res[1]);
            }

        }

        public static long[] process(long n){
            long[] res=new long[2];
            long sum=n*(n+1)/2;
            if(sum%2==1) res[0]=1;//最小值
            else res[0]=0;
            long help=(n-1)*n/2;
            res[1]=n-(int)(help%2);//最大值=n-(n-1)时的最小值
            return res;

        }
}
