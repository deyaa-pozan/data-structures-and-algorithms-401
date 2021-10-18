package tree;

public class BinarySearchTree<T> extends BinaryTree {
    public boolean contains(T value) {
        try {
            if (!isEmpty()) {
                Node current = root;
                while (current != null) {
                    if ((int) value == (int) current.value){
                        return true;
                    }
                    if ((int) value > (int) current.value) {
                        if (current.right == null) {
                            return false;
                        }
                        current = current.right;

                    } else {
                        if (current.left == null) {
                            return false;
                        }
                        current = current.left;
                    }
                }
            } else {
                return false;
            }
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}