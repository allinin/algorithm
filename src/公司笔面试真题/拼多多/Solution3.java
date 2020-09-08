package 公司笔面试真题.拼多多;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:多多鸡打算造一本自己的电子字典，里面的所有单词都只由a和b组成。
每个单词的组成里a的数量不能超过N个且b的数量不能超过M个。
多多鸡的幸运数字是K，它打算把所有满足条件的单词里的字典序第K小的单词找出来，作为字典的封面。

输入描述:
共一行，三个整数N, M, K。(0 < N, M < 50, 0 < K < 1,000,000,000,000,000)

输出描述:
共一行，为字典序第K小的单词。

输入例子1:
2 1 4

输出例子1:
ab

例子说明1:
满足条件的单词里，按照字典序从小到大排列的结果是
a
aa
aab
ab
aba
b
ba
baa
 * @date 2020/7/29 21:37
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        long k=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        System.out.println(process(n,m,k,sb));
    }

    private static int process(int n,int m,long k,StringBuilder sb){

        return 1;
    }
}
