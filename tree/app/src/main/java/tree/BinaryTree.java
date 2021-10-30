package tree;


import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTree<T> {
    Node root=null;
    int values = 0;
    int sum= 0;

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

    public ArrayList<T> breadthFirstSearch(){
        ArrayList <T> tree = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        Node current = root;
        if(!isEmpty()){
            list.add(current);
            for (int i = 0; i <values ; i++) {
                current = list.get(i);
                if(current.left != null){
                    list.add(current.left);
                }
                if(current.right != null){
                    list.add(current.right);
                }
            }
        }

        for (int j = 0; j < list.size(); j++) {
            tree.add((T)list.get(j).value);
        }
        return tree;
    }


    public int oddSum() {
        ArrayList<T> list = new ArrayList<>();
        list = inOrder(this.root);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if ((int) list.get(i) % 2 != 0) {
                sum += (int) list.get(i);
            }
        }
        return sum;
    }
    public int file(Node<T> t1) {

        if (root == null)
            return 0;
        if (t1.right == null &&
                t1.right == null) {
            sum = sum + 1;
        }
        if (t1.left != null)
            file(t1.left);
        if (t1.right != null)
            file(t1.right);
        return sum;
    }

    public boolean compare(BinarySearchTree<T> t1, BinarySearchTree<T> t2) {

        int a = file(t1.root) ;
        sum=0;
        int a2 = file(t2.root) ;
        sum=0;
        return a==a2;
    }

    public static KaryTree<String> fizzBuzzTree(KaryTree<Integer> karyTree){
        KaryTree<String> newTree = new KaryTree(karyTree.k);
        ArrayList<KaryNode> list = new ArrayList<>();
        if(karyTree.isNotEmpty()){
            list.add(karyTree.root);
            while(!list.isEmpty()){

                KaryNode<Integer> current = list.remove(0);

                String newValue;
                if(current.value % 3 == 0 && current.value % 5 ==0 )
                    newValue = "FizzBuzz";
                else if(current.value % 3 == 0)
                    newValue="Fizz";
                else if(current.value % 5 == 0)
                    newValue="Buzz";
                else
                    newValue=current.value.toString();

                newTree.add(newValue);

                if(! current.children.isEmpty())
                    list.addAll(current.children);
            }
        }
        return newTree;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "\n root=" + root +
                "\nnodes=" + values +
                '}';
    }
}