package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/5 13:37
 */
public class Solutionmian29 {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return new int[0];
        int len=matrix.length;
        int len1=matrix[0].length;
        int [] res=new int[len*len1];
        int srow=0,scol=0,erow=len-1,ecol=len1-1;//记录左上点的坐标以及右上点的坐标
        int index=0;
        while(srow<erow && scol<ecol){
            for(int i=srow,j=scol;j<=ecol;j++)
                res[index++]=matrix[i][j];


            for(int i=srow+1,j=ecol;i<=erow;i++)
                res[index++]=matrix[i][j];

            for(int i=erow,j=ecol-1;j>=scol;j--)
                res[index++]=matrix[i][j];

            for(int i=erow-1,j=scol;i>srow;i--)
                res[index++]=matrix[i][j];

            srow++;
            scol++;
            erow--;
            ecol--;
        }
        for(int i=srow;i<=erow;i++)
            for(int j=scol;j<=ecol;j++)
                res[index++]=matrix[i][j];
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }
}
