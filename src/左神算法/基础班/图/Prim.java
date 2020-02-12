package 左神算法.基础班.图;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.getWeight() - o2.getWeight();
        }

    }
    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node node : graph.nodes.values()) { //认为是一个森林，所以加入一个for循环,随便一个点开始
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : node.edges) { //将选择的边的另一个点的相应的边也加入到priorityqueue
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

}
