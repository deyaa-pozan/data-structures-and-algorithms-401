/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linkedList;

public class Main {
  public static void main(String[] args) {
    Linkedlist link = new Linkedlist();
    link.insert("abdelqader");
    link.insert("marah");
    link.insert("deyaa");

    System.out.println(link.toString());
    System.out.println(link.includes("deyaa"));
  }
}