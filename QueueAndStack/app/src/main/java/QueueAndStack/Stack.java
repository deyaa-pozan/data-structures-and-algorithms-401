package QueueAndStack;

public class Stack <T> {
    Node top = null;
    private int size =0;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    public T getMax(){
        if (isEmpty()){
            System.out.println("List is empty");
            return null;
        }
        Node current= top;
        Node max= top;

       while (current.getNext()!=null){
         if (Integer.parseInt(current.getValue()+"") < Integer.parseInt(current.getNext().getValue()+"")){
           max= current.getNext();
            }
         current= current.getNext();
       }
     return (T) max.getValue();
    }




    public void push(T value){
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T peek(){
        if(!this.isEmpty())
            return (T)top.value;

        return null;
    }


    public T pop(){
        Node current = top;
        if(!this.isEmpty()){
            top = top.next;
            current.next = null;
            size--;
            return (T) current.value;
        }
        return null;
    }



    @Override
    public String toString() {
        StringBuilder stackString = new StringBuilder();
        Node current = top;

        while(current != null){
            stackString.append(current.value);
            stackString.append("\n");
            current = current.next;
        }
        stackString.append("null");
        return stackString.toString();
    }
}