/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hashtable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test public void testHashTableAddingKeyValue() {
        HashTable<String, Integer> test = new HashTable<>();
        test.add("deyaa",3);
        boolean output = test.contains("deyaa");
        assertTrue(output);
    }

    @Test public void testHashTableRetrievingValueBasedOnKey() {
        HashTable<String, Integer> test = new HashTable<>();
        test.add("deyaa",3);
        int output = test.get("deyaa");
        assertEquals(3, output);
    }

    @Test public void testHashTableRetrievingNullForNotExistKey() {
        HashTable<String, Integer> test = new HashTable<>();
        test.add("deyaa",3);
        assertEquals(null, test.get("Fadi"));
    }

    @Test public void testHashTableHandleTheCollision() {
        HashTable<String, Integer> test = new HashTable<>();
        test.add("person", 300);
        test.add("noBody", 400);
        test.add("dontKnow", 200);
        test.add("else", 100);
        String expected = "3 : [ {key=person, value=300} ]\n"+
        "5 : [ {key=else, value=100} ]\n"+
        "7 : [ {key=noBody, value=400} ]\n"+
        "8 : [ {key=dontKnow, value=200} ]\n";
        assertEquals(expected, test.toString());
    }

    @Test public void testHashTableRetrieveValueFromBucketHasCollision() {
        HashTable<String, Integer> test = new HashTable<>();
        test.add("person", 300);
        test.add("noBody", 400);
        test.add("dontKnow", 200);
        test.add("else", 100);
        String expected = "3 : [ {key=person, value=300} ]\n"+
                "5 : [ {key=else, value=100} ]\n"+
                "7 : [ {key=noBody, value=400} ]\n"+
                "8 : [ {key=dontKnow, value=200} ]\n";
        assertEquals(expected, test.toString());
        int output1 = test.get("person");
        int output2 = test.get("noBody");
        assertEquals(400, output2);
        assertEquals(300, output1);

    }

    @Test public void testRepeatedWordIfNotExist() {
        HashTable<String, Integer> test = new HashTable<>();
        String str = "hello world";
        String expected = test.repeatedWord(str);
        assertEquals(expected, "not exist repeated word");
    }
    @Test public void testRepeatedWordIfStringIsEmpty() {
        HashTable<String, Integer> test = new HashTable<>();
        String str = "";
        String expected = test.repeatedWord(str);
        assertEquals(expected, "not exist repeated word");
    }

    @Test public void testRepeatedWordIfWasExist() {
        HashTable<String, Integer> test = new HashTable<>();
        String str = "Once upon a time, there was a brave princess who...";
        String expected = test.repeatedWord(str);
        assertEquals(expected, "a");
    }

    @Test
    void testJoinLeftFunction()   {
        HashTable<String, String> t1 = new HashTable<>();
        HashTable<String, String> t2 = new HashTable<>();
        t1.add("fond", "enamored");
        t1.add("wrath", "anger");
        t1.add("diligent", "employed");
        t1.add("outfit", "garb");
        t1.add("guide", "usher");

        t2.add("fond", "averse");
        t2.add("wrath", "delight");
        t2.add("diligent", "idle");
        t2.add("guide", "follow");
        t2.add("flow", "jam");
        String outPut = "[[diligent, employed, idle], [wrath, anger, delight], [fond, enamored, averse], [guide, usher, follow], [outfit, garb, null]]";
        String expected = t1.leftJoin(t1,t2).toString();
        assertEquals(outPut,expected);
    }
}
