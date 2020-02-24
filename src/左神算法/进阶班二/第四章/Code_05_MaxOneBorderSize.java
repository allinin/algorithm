package 左神算法.进阶班二.第四章;

/**
 * @author zbl
 * @version 1.0
 * @content:题目五
边界都是1的最大正方形大小
【题目】
给定一个NN的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方
形的边长长度。
例如：
0 1 1 1 1
0 1 0 0 1
0 1 0 0 1
0 1 1 1 1
0 1 0 1 1
其中，边框全是1的最大正方形的大小为4*4，所以返回4。
 * @date 2020/2/21 16:36
 */
public class Code_05_MaxOneBorderSize {

    //构建预处理矩阵down与right,表示当前元素下面和右面连续的1的个数
    public static void setBorderMap(int[][] m,int[][] right,int[][] down){
        int r=m.length;
        int c=m[0].length;
        if(m[r-1][c-1]==1)
        {
            right[r-1][c-1]=1;
            down[r-1][c-1]=1;
        }
        //最后一列
        for(int i=r-2;i>-1;i--){
            if(m[i][c-1]==1){
                right[i][c-1]=1;
                down[i][c-1]=down[i+1][c-1]+1;

            }

        }
        //最后一行
        for(int i=c-2;i>-1;i--){
            if(m[r-1][i]==1){
                right[r-1][i]=right[r-1][i+1]+1;
                down[r-1][i]=1;
            }
        }

        for(int i=r-2;i>-1;i--){
            for(int j=c-2;j>-1;j--){
                if(m[i][j]==1){
                    right[i][j]=right[i][j+1]+1;
                    down[i][j]=down[i+1][j]+1;
                }
            }
        }

    }

    public static int getMaxSize(int[][] m){
        int[][]right=new int[m.length][m[0].length];
        int[][]down=new int[m.length][m[0].length];
        setBorderMap(m,right,down);
        for(int i=Math.min(m.length,m[0].length);i!=0;i--){
            if(hasSizeOfBorder(i,right,down))
                return i;
        }
        return 0;
    }
    //判断是否是全部为1的矩阵
    public static boolean hasSizeOfBorder(int size,int[][]right,int[][] down){
        for(int i=0;i!=right.length-size+1;i++){
            for(int j=0;j!=right[0].length-size+1;j++){
                if(right[i][j]>=size && down[i][j]>=size
                        && down[i][j+size-1]>=size
                        && right[i+size-1][j]>=size)
                    return true;
            }

        }
        return false;
    }
    public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
        int[][] res = new int[rowSize][colSize];
        for (int i = 0; i != rowSize; i++) {
            for (int j = 0; j != colSize; j++) {
                res[i][j] = (int) (Math.random() * 2);
            }
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateRandom01Matrix(7, 8);
        printMatrix(matrix);
        System.out.println(getMaxSize(matrix));
    }
}
