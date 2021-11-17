package graph;

import java.util.*;

public class Graph <T> {

    private ArrayList<Node> vertices = new ArrayList<>();
    private HashMap<T,Integer> dictionary = new HashMap<>();
    private int size = 0 ;


    public Node addNode (T value){
        int index;
        if (isNodeExist(value)){
            index = dictionary.get(value);
        }
        else {
            dictionary.put(value, this.size);
            Node newNode = new Node(value);
            vertices.add(newNode);
            index = this.size;
            this.size++;
        }
        return vertices.get(index);
    }

    public void addEdge( T value1, T value2, int weight) throws NodeNotFoundException {
        if( isNodeExist(value1) && isNodeExist(value2)){
            int index1 = dictionary.get(value1);
            int index2 = dictionary.get(value2);
            Node node1 = vertices.get(index1);
            Node node2 = vertices.get(index2);
            Neighbor neighborForNode1 = new Neighbor(node2,weight);
            Neighbor neighborForNode2 = new Neighbor(node1,weight);
            node1.addNeighbor(neighborForNode1);
            node2.addNeighbor(neighborForNode2);
        }
        else {
            throw new NodeNotFoundException("\n---------------------------------------------\n!!---  one of the following nodes or both of them are not found! : ( "
                                            + value1.toString() +", "+value2.toString()+" ) ---!! \n --------------------------------------------\n");
        }
    }

    private boolean isNodeExist(T value){
        return dictionary.containsKey(value);
    }

    public ArrayList<Neighbor> getNeighbors(T value) throws NodeNotFoundException {
        if (isNodeExist(value)){
            int index = dictionary.get(value);
            Node currentNode = vertices.get(index);
            return currentNode.getNeighbors();
        }
        else{
            throw new NodeNotFoundException("\n---------------------------------------------\n!!---  Node: (" + value.toString() + "), not found!  ---!! \n --------------------------------------------\n");
        }
    }

    public ArrayList<Node> getNodes() {
        return vertices;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        if (graphIsEmpty()){
            out.append("null");
        }
        for (Node node : vertices){
            out.append("Node: --{ ");
            out.append(node);
            out.append(" }-- \n");
        }
        return out.toString();
    }

    private boolean graphIsEmpty() {
        return this.size ==0;
    }

    public ArrayList<String> BFT(T root) throws NodeNotFoundException {
        if( nodeNotFound(root) )
            throw new NodeNotFoundException("Node not found..( "+root.toString()+" )!");
        Set<T> visited = new HashSet<>();
        ArrayList<String> output = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        Node rootNode = getNode(root);
        queue.add(rootNode);
        visited.add((T)rootNode.getValue());

        while( ! queue.isEmpty()){
            Node node = queue.poll();
            output.add(node.getValue().toString());

            ArrayList<Neighbor> neighbors = node.getNeighbors();
            Iterator<Neighbor> neighborsItr = neighbors.iterator();

            while(neighborsItr.hasNext()){

                Node neighborNode = neighborsItr.next().getNode();
                if(visited.contains(neighborNode.getValue())){
                    continue;
                }
                queue.add(neighborNode);
                visited.add((T)neighborNode.getValue());
            }
        }
        return output;
    }
    private Node getNode(T node) throws NodeNotFoundException {

        if( nodeNotFound(node) )
            throw new NodeNotFoundException("Node not found..( "+node.toString()+" )!");

        int index = dictionary.get(node);
        return  vertices.get(index);
    }

    private boolean nodeNotFound(T root) {
        return  ! dictionary.containsKey(root);
    }


}
