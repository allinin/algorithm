package 公司笔试真题.拼多多;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:在一块长为n，宽为m的场地上，有n✖️m个1✖️1的单元格。每个单元格上的数字就是按照从1到n和1到m中的数的乘积。具体如下

n = 3, m = 3
1   2   3
2   4   6
3   6   9

给出一个查询的值k，求出按照这个方式列举的的数中第k大的值v。
例如上面的例子里，
从大到小为(9, 6, 6, 4, 3, 3, 2, 2, 1)
k = 1, v = 9
k = 2, v = 6
k = 3, v = 6
...
k = 8, v = 2
k = 9, v = 1

输入描述:
只有一行是3个数n, m, k 表示场地的宽高和需要查询的k。使用空格隔开。

输出描述:
给出第k大的数的值。

输入例子1:
3 3 4

输出例子1:
4
 * @date 2020/7/29 22:23
 */
public class Solution5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int low = 1;
        int high = n*m;
        int mid = 0;
        k = n*m+1-k;
        while (low<high){
            mid = low+(high-low)/2;
            int count = countMin(n,m,mid);
            if(count<k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        System.out.println(low);
    }

    private static int countMin(int n, int m, int mid) {
        int count = 0;
        for(int i=1;i<=n;i++){
            count += Math.min(mid/i,m);
        }
        return count;
    }
}
