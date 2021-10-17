package tree;

public class BinarySearchTree<T> extends BinaryTree {

    public void add(Object value) {
        value = (T) value;
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

    public boolean contains(T value) {
        value = (T) value;
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