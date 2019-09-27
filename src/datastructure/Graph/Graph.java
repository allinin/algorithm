package datastructure.Graph;

import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//存储边的数量
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n=8;//结点的个数
      String vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
      Graph graph=new Graph(n);
      for(String vertex:vertexs)
      {
          graph.insertVertex(vertex);
      }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        //graph.showGraph();//显示
        graph.dfs();
        System.out.println();
        graph.bfs();
    }

    public Graph(int n)
    {
        vertexList=new ArrayList<>(n);
        edges=new int[n][n];
        numOfEdges=0;
    }

    //得到第一个邻接结点
    public int getFirstNeighbor(int index)
    {
        for(int i=0;i<vertexList.size();i++)
        {
            if(edges[index][i]>0)
            {
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接结点饿坐标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2)
    {
        for(int i=v2+1;i<vertexList.size();i++)
        {
            if(edges[v1][i]>0)
            {
                return i;
            }
        }
        return -1;//如果不存在返回-1；
    }
    //深度优先遍历，i第一次就是0
    private void dfs(boolean[]isVisited,int i)
    {
        //首先我们访问该结点，输出
        System.out.print(vertexList.get(i)+"->");
        isVisited[i]=true;
        int w=getFirstNeighbor(i);
        while (w!=-1)
        {
            if(!isVisited[w])
            {
                dfs(isVisited,w);
            }
            //如果w被访问过了
            w=getNextNeighbor(i,w);//查找w的下一个节点
        }
    }

    public void dfs()
    {
        isVisited=new boolean[vertexList.size()];
        for(int i=0;i<vertexList.size();i++)
        {
            if(!isVisited[i])
            dfs(isVisited,i);
        }
    }

    //对一个结点进行广度优先遍历算法
    private void bfs(boolean[] isVisited,int i)
    {
        int u;//表示队列头结点对应的结点下标
        int w;//邻接结点
        LinkedList queue=new LinkedList();
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;
        queue.addLast(i);//利用队列来记录访问的结点的顺序
        while(!queue.isEmpty())
        {
            //取出队列的头结点的下标
            u=(int)queue.removeFirst();
            w=getFirstNeighbor(u);
            while(w!=-1)
            {
                if(!isVisited[w])
                {   isVisited[w]=true;
                    System.out.print(getValueByIndex(w)+"->");
                    queue.addLast(w);
                }
                //以u为前驱结点，找w后面的下一个邻节点
                w=getNextNeighbor(u,w);

            }
        }
    }

    public void bfs()
    {   isVisited=new boolean[vertexList.size()];
        for(int i=0;i<vertexList.size();i++)
        {
            if(isVisited[i])
                bfs(isVisited,i);
        }
    }
    //返回顶点的个数
    public int getNumOfVertex()
    {
        return vertexList.size();
    }
    //显示图对应的矩阵
    public void showGraph()
    {
        for(int[] arr:edges)
        {
            System.out.println(Arrays.toString(arr));
        }
    }

    //得到边的个数
    public int getNumOfEdges()
    {
        return numOfEdges;
    }

    //返回结点（i）对应的数据
    public String getValueByIndex(int i)
    {
        return vertexList.get(i);
    }
    //返回 v1 v2对应的权值
     public int getWeight(int v1,int v2)
     {
         return edges[v1][v2];
     }
    //插入结点
    public void insertVertex(String vertex)
    {
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1,int v2,int weight)
    {
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;//边的数量加1
    }
}
