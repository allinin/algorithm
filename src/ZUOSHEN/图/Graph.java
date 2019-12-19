package ZUOSHEN.图;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    //由结点和边组成
    public HashMap<Integer,Node> nodes; //Integer的值与Node中的value值相同
    public HashSet<Edge> edges;

    public Graph() {
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }
}
