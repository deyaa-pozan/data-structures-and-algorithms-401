/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linkedList;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  Linkedlist MyTestLink = new Linkedlist();
  @Test
  void addNewNode() {
    MyTestLink.insert("marah");
    assertEquals("marah", MyTestLink.head.getData());
  }

  @Test
  void search() {
    assertFalse(MyTestLink.includes("deyaa"));

  }
@Test
void print(){
    MyTestLink.append("deyaa");
    MyTestLink.append("aldeen");
    MyTestLink.append("pozan");
    assertEquals("HEAD -> deyaa -> aldeen -> pozan -> NULL", MyTestLink.toString());
  }

    @Test public void insert(){
        MyTestLink.insert("Boss");//the first element (head)
        MyTestLink.append("deyaa");
        MyTestLink.append("aldeen");
        MyTestLink.append("pozan");
        String output = MyTestLink.toString();
        String expected = "HEAD -> Boss -> deyaa -> aldeen -> pozan -> NULL";
        assertEquals(expected,output);
    }
    @Test public void InsertBeforeTheMiddle(){
        MyTestLink.insert("Boss");//the first element (head)
        MyTestLink.append("deyaa");
        MyTestLink.append("aldeen");
        MyTestLink.append("pozan");
        MyTestLink.insertBefore("pozan","najdat");
        String output = MyTestLink.toString();
        String expected = "HEAD -> Boss -> deyaa -> aldeen -> najdat -> pozan -> NULL";
        assertEquals(expected,output);
    }
    @Test public void InsertBeforeTheFirst(){
        MyTestLink.insert("Boss");
        MyTestLink.append("deyaa");
        MyTestLink.append("aldeen");
        MyTestLink.append("pozan");
        MyTestLink.insertBefore("Boss","1");
        String output = MyTestLink.toString();
        String expected = "HEAD -> 1 -> Boss -> deyaa -> aldeen -> pozan -> NULL";
        assertEquals(expected,output);
    }
    @Test public void InsertAfterTheMiddle(){
        MyTestLink.insert("Boss");
        MyTestLink.append("deyaa");
        MyTestLink.append("aldeen");
        MyTestLink.append("pozan");
        MyTestLink.insertAfter("aldeen","najdat");
        String output = MyTestLink.toString();
        String expected = "HEAD -> Boss -> deyaa -> aldeen -> najdat -> pozan -> NULL";
        assertEquals(expected,output);
    }
    @Test public void InsertAfterTheLast(){
        MyTestLink.insert("Boss");
        MyTestLink.append("deyaa");
        MyTestLink.append("aldeen");
        MyTestLink.append("najdat");
        MyTestLink.insertAfter("najdat","pozan");
        String output = MyTestLink.toString();
        String expected = "HEAD -> Boss -> deyaa -> aldeen -> najdat -> pozan -> NULL";
        assertEquals(expected,output);
    }

}