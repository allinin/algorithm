package algorithm.prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
    char[]data=new char[]{'A','B','C','D','E','F','G'};
    int vexs=data.length;
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
       MinGraph graph=new MinGraph(vexs);
       MinTree minTree=new MinTree();
       minTree.createMinTree(graph,vexs,data,weight);
       minTree.prim(graph,0);
    }
}

class MinTree {

    /**
     * @param minGraph：图对象
     * @param vexs：图的顶点个数
     * @param data：图中结点的数据
     * @param weight：图的边的权重
     */
    public void createMinTree(MinGraph minGraph, int vexs, char[] data, int[][] weight) {
        for (int i = 0; i < vexs; i++) {
            minGraph.data[i] = data[i];
            for (int j = 0; j < vexs; j++) {
                minGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showMinTree(MinGraph minGraph) {
        for (int[] link : minGraph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @param minGraph:图
     * @param v：表示从第几个结点开始生成
     */
    public void prim(MinGraph minGraph, int v) {

        //用来记录图的结点是否已经访问过,访问过标注为1，未访问过标注为0
        int[] visited = new int[minGraph.vexs];
        visited[v] = 1;//从v结点开始，因此标注为已经访问
        //用来记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将minWeight初始化成一个大数，后面在遍历过程中会被替代
        for (int k = 1; k < minGraph.vexs; k++)//生成边的数量为minGraph.vexs-1
        {
            //这个是确定每一次生成的子图，和哪一个结点的距离最近
            for (int i = 0; i < minGraph.vexs; i++) //i结点表示已经访问过的结点
            {
                for (int j = 0; j < minGraph.vexs; j++)//j结点表示还没有访问过的结点
                {
                    if (visited[i] == 1 && visited[j] == 0 && minGraph.weight[i][j] < minWeight) {
                        h1 = i;
                        h2 = j;
                        minWeight = minGraph.weight[i][j];
                    }
                }
            }
            System.out.println("边<" + minGraph.data[h1] + "," + minGraph.data[h2] + ">权值：" + minGraph.weight[h1][h2]);
            visited[h2] = 1;
            minWeight = 10000;


        }
    }

}


class MinGraph{
    int vexs;//表示图的结点的数量
    char[] data;//存储图的结点
    int[][] weight;//表示图的边

    public MinGraph(int vexs)
    {
        this.vexs=vexs;
        data=new char[vexs];
        weight=new int[vexs][vexs];
    }
}