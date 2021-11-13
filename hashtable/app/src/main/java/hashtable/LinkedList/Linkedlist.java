package hashtable.LinkedList;



import java.util.ArrayList;

public class Linkedlist {

    Node head;
    private int size;


    public void insert(String data){
        if(isListEmpty()){
            head= new Node(data);
            size++;
        }else {
            Node node = new Node(data);
            node.setNext(head);
            head = node;
            size++;
        }
    }

    public void append(String data){
        if(head == null){
            head= new Node(data);
            size++;
        }else {
            Node current = head ;
            while(current.getNext() != null){
                current = current.getNext();
            }
            Node node = new Node(data);
            current.setNext(node);
            size++;
        }
    }



    public int getSize() {
        return size;
    }
    public boolean isListEmpty() {
        return this.head == null;
    }

    public void insertAfter(String value, String newVal) {
        if (isListEmpty()) {
            System.out.println("The value " + value + " is not exist!");
            return;
        }
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(value)) {
                addNodeHere(currentNode, newVal);
                return;
            }
            currentNode = currentNode.getNext();
        }

        System.out.println("The value " + value + " is not exist!");

    }

    public void insertBefore(String value, String newVal) {
        if (isListEmpty()) {
            System.out.println("The value " + value + " is not exist!");
            return;
        }
        if (this.head.getData().equals(value)) {
            this.insert(newVal);
            return;
        }
        Node currentNode = this.head;

        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData().equals(value)) {
                addNodeHere(currentNode, newVal);
                return;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("The value " + value + " is not exist!");
    }

    private void addNodeHere(Node currentNode, String value) {
        Node newNode = new Node(value);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        size++;
    }
    public boolean includes(String data) {
        Node current = head;
        while (current!=null) {
            if (data.equals(current.getData())) {
                return true;
            }
            current = current.getNext();
        }
        return false;

    }

    public String kthFromEnd(int index){
        Node current = head;
        if (isListEmpty()) {
            return "List is empty";}
        if (index>getSize()-1||index<0){
            return "Exception";
        }
        int i = 0;
        int indexFound = getSize()-index-1;
        while (i<indexFound){
            current = current.getNext();
            i++;
        }

        return current.getData();
    }

    public Linkedlist zipLists(Linkedlist list2){
        Node current1 ;
        Node current2 ;
        Linkedlist thisLinkedlist ;
        if(this.getSize() >= list2.getSize()){
            current1 = this.head;
            current2 = list2.head;
            thisLinkedlist = this;

        }else{
            thisLinkedlist =list2;
            current1 = list2.head;
            current2 = this.head;
        }
        while (current2!=null&&current1.getNext()!=null){
            thisLinkedlist.insertAfter(current1.getData(),current2.getData());
            current2=current2.getNext();
            current1=current1.getNext().getNext();
        }
        return thisLinkedlist;
    }

    public void reverse(){
        if (isListEmpty()) {
            System.out.println("List is empty");
        }
        Node current = this.head;
        Node next = null ;
        Node pre = null;
        while (current!=null){
            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current= next;
        }
        this.head = pre;
    }

    public boolean palindrome() {
        if (isListEmpty()){
            System.out.println("List is empty");
            return true ;
        }
        ArrayList<String> arr = new ArrayList<>();
        Node current = this.head;
        while (current!=null){
            arr.add(current.getData());
            current = current.getNext();
        }
        for (int i = 0; i < arr.size()/2; i++) {
            if (arr.get(i)!=arr.get(arr.size()-i-1)){
                return false;
            }

        }

        return true;
    }




    @Override
    public String toString() {
        StringBuilder result;
        if (head == null) {
            result = new StringBuilder("List is empty");
        } else {
            Node current;
            current = head;
            result = new StringBuilder("HEAD -> ");

            while (current != null) {
                // moves the current reference along the list
                result.append(current.getData()).append(" -> ");
                current = current.getNext();
            }

            result.append("NULL");
        }
        return result.toString();
    }
}
