/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linkedList;

public class Main {
  public static void main(String[] args) {
    Linkedlist linklist = new Linkedlist();
//    linklist.append("deyaa");
//    linklist.append("najdat");
//    linklist.append("khear");
//    linklist.insertBefore("najdat","aldeen");

    linklist.insert("Boss");
    linklist.append("deyaa");
    linklist.append("aldeen");
    linklist.append("najdat");
    linklist.insertAfter("najdat","pozan");


    //linklist.insertAfter("khear","pozan");

    System.out.println(linklist.toString());

    System.out.println(linklist.includes("deyaa"));
  }
}
