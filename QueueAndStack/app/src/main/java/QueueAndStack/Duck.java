package QueueAndStack;

public class Duck {
    public  String duck(String[] arr, int k) {
        Queue<String> q = new Queue<>();
        Node current = q.getFront();
        for (int i = 0; i < arr.length; i++) {
            q.enqueue(arr[i]);
        }
        if (q.size > 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < k % q.size; j++) {
                    if (j - (k % q.size) == 1) {
                        current.setNext(current.getNext().getNext());
                    }
                    current = current.getNext();
                }
                current = q.getFront();
            }
        }
        return q.front.getValue() + "";
    }
}
