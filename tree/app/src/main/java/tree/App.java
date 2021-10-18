/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tree;

public class App {
    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        
        tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(15);
        tree.add(12);
        tree.add(20);

//        System.out.println(tree.inOrder(tree.root));
//        System.out.println(tree.postOrder(tree.root));
//        System.out.println(tree);
//        System.out.println(tree.contains(6));
//        System.out.println(tree.treeMax());
          System.out.println(tree.breadthFirstSearch());
//        System.out.println(tree.preOrder(tree.root));


    }
}
