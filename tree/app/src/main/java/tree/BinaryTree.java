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

    public  int treeMax(){
        if (isEmpty()) {
            return 0;
        }
        int max = 0;
        ArrayList<T> allNodes = preOrder(root);
        for (int i = 0; i < allNodes.size(); i++) {
            if(Integer.parseInt(allNodes.get(i)+"") > max){
                max =Integer.parseInt(allNodes.get(i)+"");
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "\n root=" + root +
                "\nnodes=" + values +
                '}';
    }
}