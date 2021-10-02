/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linkedList;

public class Linkedlist {

   Node head;
  private int size;

public void insert(String data){
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

  }