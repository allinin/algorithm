package 韩顺平算法与数据结构.algorithm.dynamic;

public class KnapsackProblem {
    public static void main(String[] args) {
        int []w={1,4,3};//记录物品的重量
        int []val={1500,3000,2000};//记录物品的价值
        int m=4;//背包的容量
        int n=val.length;//物品的个数


        //v[i][j]表示来前i个物品中能够装入容量为j的背包中的最大价值
        int[][]v=new int[n+1][m+1];
        int[][]path=new int[n+1][m+1];//增加一个数组来记录放入物品的情况

        for(int i=1;i<v.length;i++)
        {
            for(int j=1;j<v[0].length;j++)
            {
                if(w[i-1]>j)
                {
                    v[i][j]=v[i-1][j];
                }else {
                    if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]])
                    {
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        //把当前的情况记录到path。因为上式中出现了val，所以说明有物品加入背包
                        path[i][j] = 1;
                    }else {
                        v[i][j]=v[i-1][j];

                    }
                }
            }
        }
        //动脑筋
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while(i > 0 && j > 0 ) { //从path的最后开始找
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i-1]; //w[i-1]
            }
            i--;
        }

    }
}
