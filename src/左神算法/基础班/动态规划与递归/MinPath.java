package 左神算法.基础班.动态规划与递归;

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上角走到右下角，每一步只能向下或者向右，沿途经过的数字要累加起来，返回最小的路径和。
 */
public class MinPath {

    public static int minPath1(int[][] matrix)
    {
        return walk(matrix,0,0);
    }

    //从（i,j)出发，到达最右下角位置，最短路径和（暴力枚举，存在重复计算）
    public static int walk(int[][]matrix,int i,int j)
    {
        if(i==matrix.length-1 && j==matrix[0].length-1)
            return matrix[i][j];
        if(i==matrix.length-1)
            return matrix[i][j]+walk(matrix,i,j+1);
        if(j==matrix[0].length-1)
            return matrix[i][j]+walk(matrix,i+1,j);
        //一般情况：
        int right=walk(matrix,i,j+1);//右边位置到最右下角的最短路径和
        int down=walk(matrix,i+1,j);//下边位置到最右下角的最短路径和
        return matrix[i][j]+Math.min(right,down);
    }

    //动态规划版本
    public static int minPath2(int[][]matrix)
    {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)
            return 0;
        //根据可变参数构建dp数组
        int row =matrix.length;
        int col=matrix[0].length;
        int [][] dp=new int[row][col];
        dp[row-1][col-1]=matrix[row-1][col-1];
        for(int i=row-1;i>=1;i--)
        {
            dp[i-1][col-1]=dp[i][col-1]+matrix[i-1][col-1];
        }
        for(int j=col-1;j>0;j--)
        {
            dp[row-1][j-1]=dp[row-1][j]+matrix[row-1][j-1];
        }
        for(int i=row-2;i>=0;i--)
        {
            for(int j=col-2;j>=0;j--)
            {
                dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+matrix[i][j];
            }
        }
        return dp[0][0];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
