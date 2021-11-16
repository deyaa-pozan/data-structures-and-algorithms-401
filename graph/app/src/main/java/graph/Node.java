package graph;
import java.util.ArrayList;
import java.util.List;

public class Node <T> {

    private T value;
    private List<Neighbor> neighbors = new ArrayList<>();

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public List<Neighbor> getNeighbors() {
        return neighbors;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void addNeighbor(Neighbor neighbor){
        if(! neighbors.contains(neighbor))
             neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" value: ");
        out.append(this.value);
        out.append(" ,  Neighbors: ");
        out.append(neighbors);
        out.append(" ");
        return out.toString();
    }
}