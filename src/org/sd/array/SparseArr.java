package org.sd.array;

import java.util.Arrays;

public class SparseArr {

    public static void main(String[] args) {
        int[][] arr=new int[11][11];
        arr[1][2]=1;
        arr[2][3]=2;
        //遍历原始数组
        int sum=0;
        for(int[] row:arr)
        {
            for(int i:row)
            {
                System.out.printf("%d\t",i);
                if(i!=0)
                    sum++;
            }
            System.out.println();
        }
        //创建稀疏数组
        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组，将非0值放入稀疏数组
        int count=0;
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
            {
                if(arr[i][j]!=0)
                {
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=arr[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("稀疏数组为：。。。");
        for(int i=0;i<sparseArr.length;i++)
        {
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }
        //稀疏数组转为二维数组,先读取稀疏数组的第一行，根据第一行的数据创建二维数组
        int [][] sArr= new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=1;i<sparseArr[0][2];i++)
        {
            sArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        for(int[] row :sArr)
        {
            for(int j:row)
                System.out.printf("%d\t",j);
            System.out.println();
        }
    }
}
