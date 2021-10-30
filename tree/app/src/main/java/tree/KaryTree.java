package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KaryTree<T> {

    KaryNode root=null;
    int values = 0;
    int k =0;


    public KaryTree(int k) {
        if(k<=1)
            k=2;
        this.k = k;
    }

    public boolean isEmpty() {

        return root == null;
    }

    public boolean isNotEmpty(){
        return root != null;
    }

    public void add(T value){
        values++;
        KaryNode newNode = new KaryNode(value);
        if( isEmpty()){
            root = newNode;
            return;
        }
        Queue<KaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            KaryNode current = queue.poll();
            if(current.children.size() < this.k){
                current.addChild(newNode);
                return;
            }
            else {
                queue.addAll(current.children);
            }
        }
    }

    public ArrayList<T> breadthFirstSearch(){
        ArrayList <T> tree = new ArrayList<>();
        Queue<KaryNode> queue = new LinkedList<>();
        if(isNotEmpty()){
            queue.add(root);
            while(!queue.isEmpty()){
                KaryNode current = queue.poll();
                tree.add((T)current.value);
                if(! current.children.isEmpty())
                    queue.addAll(current.children);
            }
        }
        return tree;
    }

    @Override
    public String toString() {
        return "K_aryTree{" +
                "root=" + root +
                ", values=" + values +
                ", K=" + k +
                '}';
    }
}
