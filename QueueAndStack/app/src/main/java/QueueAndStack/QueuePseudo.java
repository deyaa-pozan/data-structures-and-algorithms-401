package QueueAndStack;

public class QueuePseudo<T> {


    private Stack<T> Stack1;
    private Stack<T> Stack2;

    public QueuePseudo() {
        this.Stack1 = new Stack<>();
        this.Stack2 = new Stack<>();
    }

    public  void enqueue(T value) {
        this.Stack1.push(value);
    }

    public T dequeue() {
        while (Stack1.top != null){
            Stack2.push(Stack1.pop());
        }
        T value = Stack2.pop();
        while (Stack2.top != null){
            Stack1.push(Stack2.pop());
        }
        return value;
    }



    public int getSize() {
        return Stack1.getSize();
    }


    @Override
    public String toString() {
        String strStack = "";
        Node tmp = Stack1.top;
        if(tmp == null){
            return "List is empty";
        }
        while (tmp != null) {
            strStack = strStack + tmp.value;

            if(tmp.next != null) {
                strStack = strStack + "-->";
            }
            tmp = tmp.next;
        }

        return strStack;
    }
}
