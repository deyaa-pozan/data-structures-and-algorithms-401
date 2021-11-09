package hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T> {
    Node root=null;
    int values = 0;
    int sum= 0;
    HashTable<Integer, Integer> hashtable = new HashTable<>();
    List<Integer> list = new ArrayList<>();

    public List<Integer> treeIntersection(Tree<T> tree1, Tree<T> tree2){
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        if(tree1.isEmpty() || tree2.isEmpty())
            return list;
        q1.add(tree1.root);
        while(! q1.isEmpty()){
            Node currentNode = q1.poll();
            hashtable.add((int)currentNode.value , 1);
            if(currentNode.left != null)
                q1.add(currentNode.left);
            if(currentNode.right != null)
                q1.add(currentNode.right);
        }
        q2.add(tree2.root);
        while(! q2.isEmpty()){
            Node currentNode = q2.poll();
            if(hashtable.contains((int)currentNode.value) && hashtable.get((int)currentNode.value) == 1)
                list.add((int)currentNode.value);
            hashtable.add((int)currentNode.value,0);
            if(currentNode.left != null)
                q2.add(currentNode.left);
            if(currentNode.right != null)
                q2.add(currentNode.right);
        }
        return list;
    }


    public boolean isEmpty() {
        return root == null;
    }

    public void add(T value) {
        Node node = new Node(value);
        try{
            if(!isEmpty()){
                Node current = root;
                values++;
                while(current != null){
                    if((int) value > (int) current.value  ){
                        if(current.right == null){
                            current.right = node;
                            return;
                        }
                        current = current.right;

                    }
                    else{
                        if(current.left == null){
                            current.left = node;
                            return;
                        }
                        current = current.left;
                    }
                }
            }else {
                values++;
                root = node;
            }
        }
        catch (ClassCastException e){
            System.out.println(e.getMessage());
        }


    }



    @Override
    public String toString() {
        return "BinaryTree{" +
                "\n root=" + root +
                "\nnodes=" + values +
                '}';
    }
}