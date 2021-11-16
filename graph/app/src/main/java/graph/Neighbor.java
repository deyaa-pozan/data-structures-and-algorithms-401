package graph;

public class Neighbor {
    private Node node;
    private int weight;

    public Neighbor(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ( ");
        out.append(node.getValue());
        out.append(" , ");
        out.append(weight);
        out.append(" ) ");
        return out.toString();
    }
}
