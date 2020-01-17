package ZUOSHEN.基础班.第三课;

public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][]arr)
    {
        int row1=0;
        int col1=0;
        int row2=arr.length-1;
        int col2=arr[0].length-1;
        while(row1<=row2 && col1<=col2)
        {
            printEdge(arr,row1++,col1++,row2--,col2--);
        }
    }

    public static void printEdge(int[][]arr,int row1,int col1,int row2,int col2)
    {
        if(row1==row2)
        {
            for(int i=col1;i<=row2;i++)
            {
                System.out.println(arr[row1][i]+"\t");
            }
        }else if(col1==col2)
        {
            for(int i=row1;i<=row2;i++)
            {
                System.out.println(arr[i][row1]+"\t");
            }
        }else{
            int curR=row1;
            int curC=col1;
            while (curC!=col2)   //注意这里的写法，如果是curC<=col2的话，终止的时候curC已经越界了。后序处理会麻烦。
            {
                System.out.println(arr[row1][curC]+"\t");
                curC++;
            }
            while(curR!=row2)
            {
                System.out.println(arr[curR][curC]);
                curR++;
            }
            while(curC!=col1)
            {
                System.out.println(arr[row2][curC]);
                curC--;
            }
            while(curR!=row1)
            {
                System.out.println(arr[curR][col1]);
                curR--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }
}
