package ZUOSHEN.基础班.图;

public class Edge { //图中的边

    public Node from;
    public int weight;
    public Node to;


    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }


    public Edge(Node from, int weight, Node to) {
        this.from = from;
        this.weight = weight;
        this.to = to;
    }
}
