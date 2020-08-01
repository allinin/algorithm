package 公司笔试真题.猿辅导.二零_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:中午是猿辅导水果时间，小猿会给每个同学发水果。猿辅导有一个矩形的办公区域，共有N 排，每排M个工位。平时小猿按照从第一排到最后一排的顺序发水果，某一天小猿突然发现似乎旋转着发水果是一种更有趣的方式，所以决定试试按照逆时针方向螺旋发水果。
已知每个工位有一个数字，表示该工位员工的工号，每个员工的工号不同。已知小猿从（0, 0）位置开始，按照逆时针螺旋的顺序发水果，请输出收到水果的员工工号序列。

输入描述:
第一行 两个数， 数组行列 N，M
接下来 N 行，每行 M 个正整数，表示每个位置的员工工号
1 ≤ N ≤ 1000
1 ≤ M ≤ 1000

输出描述:
发放水果工号序列

输入例子1:
3 3
1 2 3
4 5 6
7 8 9

输出例子1:
1 4 7 8 9 6 3 2 5
 * @date 2020/7/25 21:15
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        List<Integer> list=process(matrix,n,m);
        for(Integer num:list){
            System.out.print(num+" ");
        }
    }

    private static List<Integer> process(int[][] matrix, int n, int m){
       List<Integer>list=new ArrayList<>();
       int rs=0,cs=0,re=n-1,ce=m-1;
       while(rs<=re && cs<=ce){
           if(rs==re){
               for(int i=cs;i<=ce;i++){
                   list.add(matrix[rs][i]);
               }
           }else if(cs==ce){
               for(int i=rs;i<=re;i++){
                   list.add(matrix[i][ce]);
               }
           }else{
               for(int i=rs;i<=re;i++){
                   list.add(matrix[i][cs]);
               }

               list.remove(list.size()-1);

               for(int i=cs;i<=ce;i++){
                   list.add(matrix[re][i]);
               }
               list.remove(list.size()-1);
               for(int i=re;i>=rs;i--){
                   list.add(matrix[i][ce]);
               }
               list.remove(list.size()-1);
               for(int i=ce;i>=cs;i--){
                   list.add(matrix[rs][i]);
               }
               list.remove(list.size()-1);
           }
           rs++;
           cs++;
           re--;
           ce--;
       }
       return list;
    }

    /**
     * 或者如下写法
     */
//public static void main(String[] args){
//
//    Scanner sc = new Scanner(System.in);
//    int N = sc.nextInt();
//    int M = sc.nextInt();
//    int[][] matrix = new int[N][M];
//    for(int i = 0;i < N; i++){
//        for(int j=  0;j < M;j++){
//            matrix[i][j] = sc.nextInt();
//            //    System.out.print(matrix[i][j]+" ");
//        }
//        //  System.out.println();
//    }
//
//    int[] res = fruits(matrix);
//    for(int i = 0 ; i< res.length - 1;i++){
//        System.out.print(res[i] + " ");
//    }
//    System.out.print(res[res.length - 1]);
//
//}
//
//    public static int[] fruits(int[][] matrix){
//        //1 <= m , n <= 1000
//        //不需要特点判断
//        int m = matrix.length;
//        int n = matrix[0].length;
//        if(m == 1 && n==1){
//            int[] res = new int[]{matrix[0][0]};
//            return res;
//        }
//        int[] res = new int[m * n];
//        int index = 0;
//        int up = 0 ;
//        int down = m -1;
//        int left = 0;
//        int right = n -1;
//        while(index < m * n){
//
//            for(int i = up;i <= down;i++)
//            {
//                res[index++] = matrix[i][left];
//            }
//            left++;
//            if(left > right){
//                break;
//            }
//            for(int j = left;j <= right;j++){
//                res[index++] = matrix[down][j];
//            }
//            down--;
//            if(down < up){
//                break;
//            }
//            for(int i = down;i >= up;i--){
//                res[index++] = matrix[i][right];
//            }
//            right--;
//            if(right < left){
//                break;
//            }
//            for(int j = right;j >= left;j--){
//                res[index++] = matrix[up][j];
//            }
//            up++;
//            if(up > down){
//                break;
//            }
//        }
//
//        return res;
//    }


}
