/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tree;

public class App {
    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(6);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        System.out.println(tree.preOrder(tree.root));
        System.out.println(tree.inOrder(tree.root));
        System.out.println(tree.postOrder(tree.root));
        System.out.println(tree);
        System.out.println(tree.contains(6));


    }
}
