/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linkedList;

public class Main {
  public static void main(String[] args) {
    Linkedlist linklist = new Linkedlist();
    linklist.insert("deyaa");
    linklist.insert("aldeen");
    linklist.insert("pozan");

    System.out.println(linklist.toString());
    System.out.println(linklist.includes("deyaa"));
  }
}
