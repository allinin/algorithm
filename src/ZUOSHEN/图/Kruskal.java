package ZUOSHEN.图;

import java.util.*;

public class Kruskal {

    //通过并查集来实现
    public static class UnionSet{
        private HashMap<Node,Node> fatherMap;
        private HashMap<Node,Integer>rankMap;
        public UnionSet(){
            this.fatherMap=new HashMap<>();
            this.rankMap=new HashMap<>();
        }
        public void makeSet(Collection<Node> nodes)
        {
            fatherMap.clear();
            rankMap.clear();
            for(Node node:nodes)
            {
                fatherMap.put(node,node);
                rankMap.put(node,1);
            }
        }

        public Node findFather(Node node)
        {
            Node father=fatherMap.get(node);
            if(node!=father)
            {
                father=findFather(father);
            }
            fatherMap.put(node,father);
            return father;
        }
        public boolean isSameSet(Node node1,Node node2){
            return findFather(node1)==findFather(node2);
        }
        public void unionSet(Node node1,Node node2)
        {
            if(node1==null || node2==null)
                return;
            Node father1=findFather(node1);
            Node father2 = findFather(node2);
            if(father1==father2)
                return;
            Integer n1=rankMap.get(node1);
            Integer n2=rankMap.get(node2);
            if(n1<=n2){
                fatherMap.put(node1,father2);
                rankMap.put(father2,n1+n2);
            }else {
                 fatherMap.put(node2,father1);
                 rankMap.put(father1,n1+n2);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.getWeight()-o2.getWeight();
        }
    }

    public static Set<Edge> kruskalMST(Graph graph)
    {
        UnionSet unionSet=new UnionSet();
        unionSet.makeSet(graph.nodes.values());
        PriorityQueue<Edge> queue=new PriorityQueue<>(new EdgeComparator());
        for(Edge edge:graph.edges)
        {
            queue.add(edge);
        }
        HashSet<Edge> result=new HashSet<>();
        while(!queue.isEmpty())
        {
            Edge edge=queue.poll();
            if(!unionSet.isSameSet(edge.getFrom(),edge.getTo()))//当边的两个结点不属于同一个集合时，引出这条边
                                                                // 并且因为边的引入，使得这两个点所在的集合成为了同一个集合，因此将他们合并
            {
                result.add(edge);
                unionSet.unionSet(edge.getFrom(),edge.getTo());
            }
        }
        return result;
    }
}
