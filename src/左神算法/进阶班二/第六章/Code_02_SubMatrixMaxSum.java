package 左神算法.进阶班二.第六章;

/**
 * @author zbl
 * @version 1.0
 * @content:子矩阵的最大累加和问题
【题目】
给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和。
例如，矩阵matrix为：
-90 48 78
64 -40 64
-81 -7 66
其中，最大累加和的子矩阵为：
48 78
-40 64
-7 66
所以返回累加和209。
例如，matrix为：
-1 -1 -1
-1 2 2
-1 -1 -1
其中，最大累加和的子矩阵为：
2 2
所以返回累加和4。
 * @date 2020/2/28 15:54
 */
public class Code_02_SubMatrixMaxSum {

    public static int maxSum1(int[][] matrix){
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int res=Integer.MIN_VALUE;
        int cur=0;
        int [] help=new int[matrix[0].length];
        for(int m=0;m<matrix.length;m++){
             for(int p=0;p<help.length;p++){
                 help[p]=0;
             }
            for(int i=m;i<matrix.length;i++){
                 cur=0;
                 for(int j=0;j<matrix[i].length;j++){
                    help[j]+=matrix[i][j];
                    cur+=help[j];
                    res=Math.max(res,cur);
                    cur=cur>0?cur:0;
                }
            }
        }

        return res;

    }

    public static int maxSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i != m.length; i++) {
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
        System.out.println(maxSum1(matrix)==maxSum2(matrix));

    }

}
