package tree;


import java.util.ArrayList;

public class BinaryTree<T> {
    Node root=null;
    int values = 0;

    public boolean isEmpty() {
        return root == null;
    }


    public ArrayList<T> preOrder(Node root){
        ArrayList <T> tree = new ArrayList<>();
        if(!isEmpty()){
            tree.add((T) root.value);
            if(root.left != null)
                tree.addAll(preOrder(root.left));
            if(root.right != null)
                tree.addAll(preOrder(root.right));
        }
        return tree;
    }
    public ArrayList<T> inOrder(Node root){
        ArrayList <T> tree = new ArrayList<>();
        if(!isEmpty()){

            if(root.left != null)
                tree.addAll(inOrder(root.left));

            tree.add((T) root.value);

            if(root.right != null)
                tree.addAll(inOrder(root.right));
        }
        return tree;
    }
    public ArrayList<T> postOrder(Node root){
        ArrayList <T> tree = new ArrayList<>();
        if(!isEmpty()){
            if(root.left != null)
                tree.addAll(postOrder(root.left));
            if(root.right != null)
                tree.addAll(postOrder(root.right));
            tree.add((T) root.value);
        }
        return tree;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "\n root=" + root +
                "\nnodes=" + values +
                '}';
    }
}