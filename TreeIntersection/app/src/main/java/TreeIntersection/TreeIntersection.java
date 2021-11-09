package TreeIntersection;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeIntersection {
    Hashtable<Integer,Integer> hashtable = new Hashtable<>();
    List<Integer> outputList = new ArrayList<>();


    public List<Integer> findCommonValuesInTwoBinaryTrees(BinaryTree tree1, BinaryTree tree2){
        addFirstTreeToHashTable(tree1);
        checkSecondTreeCommonValues(tree2);
        return outputList;
    }

    private void addFirstTreeToHashTable(BinaryTree tree){
        Queue<Node> q = new LinkedList<>();
        if(tree.isEmpty())
            return;
        q.add(tree.root);
        while(! q.isEmpty()){
            Node currentNode = q.poll();
            hashtable.add(String.valueOf(currentNode.value) , 1);
            if(currentNode.left != null)
                q.add(currentNode.left);
            if(currentNode.right != null)
                q.add(currentNode.right);

        }
    }

    private void checkSecondTreeCommonValues(BinaryTree tree){
        Queue<Node> q = new LinkedList<>();
        if(tree.isEmpty())
            return;
        q.add(tree.root);
        while(! q.isEmpty()){
            Node currentNode = q.poll();
            if(hashtable.contains(String.valueOf(currentNode.value)) && hashtable.get(String.valueOf(currentNode.value)) == 1)
                outputList.add((int)currentNode.value);
                hashtable.add(String.valueOf(currentNode.value),0);
            if(currentNode.left != null)
                q.add(currentNode.left);
            if(currentNode.right != null)
                q.add(currentNode.right);
        }
    }

}