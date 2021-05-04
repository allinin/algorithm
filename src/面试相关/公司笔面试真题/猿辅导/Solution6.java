package 面试相关.公司笔面试真题.猿辅导;

/**
 * @author zbl
 * @version 1.0
 * @content:算法：一个蛇形矩阵，搜索一个数字是否在其中
[[1, 2, 3, 4],
[8, 7, 6, 5],
[9, 10, 11, 12],
[16, 15, 14, 13]]
 * @date 2020/9/3 10:16
 */
public class Solution6 {

    //将二维矩阵看成一个递增的一维矩阵，然后找出坐标的变换逻辑。
    public static boolean process(int[][] matrix,int target){
        if(matrix==null || matrix.length==0)
            return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0,right=m*n-1,mid=0;
        while(left<right){
            mid=(left+right)>>>1;
            int[] ans=help(mid,m,n);
            if(matrix[ans[0]][ans[1]]<target){
                left=mid+1;
            }else {
                right = mid;
            }
        }
        int[] ans=help(left,m,n);
        if(matrix[ans[0]][ans[1]]==target){
            return true;

        }
        return false;

    }

    //将一维数组中的坐标num映射成蛇形矩阵的相应的坐标位置
    private static int[] help(int num,int m,int n){
        int row=num/n;
        int col=num%n;
        if(row %2==1){
            col=n-col-1;
        }
        int[] res=new int[2];
        res[0]=row;
        res[1]=col;
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix={
                {1, 2, 3, 4},
                {8, 7, 6, 5},
                {10, 11, 12, 14},
                {120, 18, 17, 16}
        };
        System.out.println(process(matrix,666));
    }
}
