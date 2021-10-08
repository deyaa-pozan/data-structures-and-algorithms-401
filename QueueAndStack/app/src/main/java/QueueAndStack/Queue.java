package QueueAndStack;

public class Queue <T> {
    Node front;
    Node rear;
    int size=0;

    public void enqueue(T value){
        Node newNode = new Node(value);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            size++;
          }else {
          rear.next = newNode;
          rear = newNode;
          size++;
        }

    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }else{
            Node current = front;
            front = front.next;
            current.next = null;
            size--;
            return (T) current.value;
        }
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }else {
            return (T) front.value;
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder strQueue = new StringBuilder();
        strQueue.append("front ");
        Node current = front;
        while(current != null){
            strQueue.append(current.value);
            strQueue.append(" -- ");
            current = current.next;
        }
        strQueue.append("rear");
        return strQueue.toString();
    }
}