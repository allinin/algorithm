package ZUOSHEN.基础班.图;

import java.util.ArrayList;

public class Node {
    //图中的结点
    public int value;
    public int in;//该结点的入度数
    public int out;//该结点的出度数
    public ArrayList<Node> nexts; //该结点有多少个后序结点
    public ArrayList<Edge>edges;//以该结点为出度的边

    public Node(int value) {
        this.value = value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }
}
