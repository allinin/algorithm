package ZUOSHEN.图;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {

    public static List<Node> sortedTopology(Graph graph)
    {
        HashMap<Node ,Integer>inMap=new HashMap<>();//结点：结点的入度
        Queue<Node> zeroInQueue=new LinkedList<>();
        for(Node node:graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in==0)
            {
                zeroInQueue.add(node);
            }
        }
        List<Node> result=new LinkedList<>();
        while(!zeroInQueue.isEmpty())
        {
            Node cur=zeroInQueue.poll();//弹出入度为0的结点
            result.add(cur);
            for(Node node:cur.nexts)
            {
                inMap.put(node,inMap.get(node)-1);//弹出入度为零的结点后，将他的后序结点的入度全部减1，消除弹出结点的影响，
                                                   //消除影响后，入度变为0的结点在此如队里
                 if(inMap.get(node)==0)
                {
                    zeroInQueue.add(node);
                }
            }
        }
        return result;
    }
}
