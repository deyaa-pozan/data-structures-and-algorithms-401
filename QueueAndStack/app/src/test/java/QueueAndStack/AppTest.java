/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package QueueAndStack;

import QueueAndStack.Animal.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void pushToStack() {
        Stack<String> stack = new Stack<>();
        stack.push("3");
        int size = stack.getSize();
        int expectedSize = 1;
        Assertions.assertEquals(expectedSize,size);

    }
    @Test public void pushMultiTOStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        String output = stack.toString();
        String expectedOutput = "3\n2\n1\nnull";
        Assertions.assertEquals(expectedOutput,output);
    }
    @Test
    public void popStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(9);
        stack.push(1);
        int value = stack.pop();
        int size = stack.getSize();
        int expectedSize = 2;
        Assertions.assertEquals(expectedSize,size);
        int expectedOutput = 1;
        Assertions.assertEquals(expectedOutput,value);
    }
    @Test public void emptyAfterMultiPops() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(7);
        stack.push(6);
        stack.pop();
        stack.pop();
        stack.pop();
        int size = stack.getSize();
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize,size);
        String output = stack.toString();
        String expectedOutput = "null";
        Assertions.assertEquals(expectedOutput,output);
    }
    @Test public void peekNextItem() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(8);
        stack.push(8);
        stack.push(1);
        int peeked = stack.peek();
        int size = stack.getSize();
        int expectedSize = 3;
        Assertions.assertEquals(expectedSize,size);
        int expectedOutput = 1;
        Assertions.assertEquals(expectedOutput,peeked);
    }
    @Test public void instantiateEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        int size = stack.getSize();
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize,size);
        String output = stack.toString();
        String expectedOutput = "null";
        Assertions.assertEquals(expectedOutput,output);
    }

    @Test public void callingPopOrPeekOnEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        Assertions.assertNull(stack.peek());
        Assertions.assertNull(stack.pop());
    }

    @Test public void enqueueIntoAQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(4);
        int size = queue.size;
        int expectedSize = 1;
        Assertions.assertEquals(expectedSize,size);
    }

    @Test public void enqueueMultiValuesToQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(6);
        queue.enqueue(3);
        queue.enqueue(1);
        int size = queue.size;
        int expectedSize = 3;
        Assertions.assertEquals(expectedSize,size);
    }
    @Test public void dequeueOutQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(40);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(6);
        queue.enqueue(1);
        int value = queue.dequeue();
        int expectedValue = 40;
        int size = queue.size;
        int expectedSize = 4;
        Assertions.assertEquals(expectedSize,size);
        Assertions.assertEquals(expectedValue,value);
    }
    @Test public void peekInQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);
        int value = queue.peek();
        int expectedValue = 10;
        int size = queue.size;
        int expectedSize = 5;
        Assertions.assertEquals(expectedSize,size);
        Assertions.assertEquals(expectedValue,value);

    }
    @Test public void emptyQueueAfterMultiDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        int size = queue.size;
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize,size);
    }

    @Test public void instantiateEmptyQueue() {
        Queue<String> queue = new Queue<String>();
        int size = queue.size;
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize,size);

    }

    @Test public void callingDequeueOrPeekEmptyQueue() {
        Queue<Integer> queue = new Queue<Integer>();
        Assertions.assertNull(queue.peek());
        Assertions.assertNull(queue.dequeue());
    }
    @Test public void enqueueIntoQueuePseudo() {
        QueuePseudo<String> queue = new QueuePseudo<>();
        queue.enqueue("deyaa");
        int size = queue.getSize();
        int expectedSize = 1;
        Assertions.assertEquals(expectedSize,size);
    }

    @Test public void dequeueQueuePseudo() {
        QueuePseudo<String> queue = new QueuePseudo<>();
        queue.enqueue("DEYAA");
        queue.enqueue("ABED");
        queue.enqueue("AMMAR");

        String value = queue.dequeue();
        String expectedValue = "DEYAA";
        int size = queue.getSize();
        int expectedSize = 2;
        Assertions.assertEquals(expectedSize,size);
        Assertions.assertEquals(expectedValue,value);
    }

    @Test public void emptyQueuePseudoAfterDequeues() {
        QueuePseudo<String> queue = new QueuePseudo<>();
        queue.enqueue("DEYAA");
        queue.enqueue("ABED");
        queue.enqueue("AMMAR");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        int size = queue.getSize();
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize,size);
    }


    @Test public void dequeueOnEmptyQueuePseudo() {
        QueuePseudo<String> queue = new QueuePseudo<>();
        Assertions.assertNull(queue.dequeue());
    }

    @Test public void createEmptyAnimalShelter() {
        AnimalShelter animals = new AnimalShelter();
        Assertions.assertEquals("AnimalShelter{animalQueue=front rear}",animals.toString());
    }
    @Test public void enqueueAnimalsToTheShelter() {
        AnimalShelter animals = new AnimalShelter();
        Animal animal1 = new Dog("dog1");
        Animal animal2 = new Dog("dog2");
        Animal animal3 = new Cat("cat1");
        Animal animal4 = new Cat("cat2");
        animals.enqueue(animal1);
        animals.enqueue(animal2);
        animals.enqueue(animal3);
        animals.enqueue(animal4);
        String expected ="AnimalShelter{animalQueue=front Animal{name='dog1'} -- Animal{name='dog2'} -- Animal{name='cat1'} -- Animal{name='cat2'} -- rear}";
        Assertions.assertEquals(expected,animals.toString());
    }
    @Test public void dequeuePrefCat() {
        AnimalShelter animals = new AnimalShelter();
        Animal animal1 = new Dog("dog1");
        Animal animal2 = new Dog("dog2");
        Animal animal3 = new Cat("cat1");
        Animal animal4 = new Cat("cat2");
        animals.enqueue(animal1);
        animals.enqueue(animal2);
        animals.enqueue(animal3);
        animals.enqueue(animal4);
        Animal value = animals.dequeue("dog");
        String expected ="dog1";
        Assertions.assertEquals(expected,value.getName());

    }

    @Test public void dequeuePrefCatNotFound() {
        AnimalShelter animals = new AnimalShelter();

        Animal animal1 = new Dog("dog1");
        Animal animal2 = new Dog("dog2");
        animals.enqueue(animal1);
        animals.enqueue(animal2);
        Animal value = animals.dequeue("cat");
        Assertions.assertNull(value);
    }
    @Test public void testDequeuePrefAnyThingAnotherCatOrDog() {
        AnimalShelter animals = new AnimalShelter();

        Animal animal1 = new Dog("dog1");
        Animal animal2 = new Dog("dog2");
        Animal animal3 = new Cat("cat1");
        Animal animal4 = new Cat("cat2");
        Animal animal5 = new AnotherAnimal("lion");
        animals.enqueue(animal1);
        animals.enqueue(animal2);
        animals.enqueue(animal3);
        animals.enqueue(animal4);
        animals.enqueue(animal5);
        Animal value = animals.dequeue("cute animal");
        String expected ="AnimalShelter{animalQueue=front Animal{name='dog1'} -- Animal{name='dog2'} -- Animal{name='cat1'} -- Animal{name='cat2'} -- rear}";
        Assertions.assertEquals(expected,animals.toString());
        Assertions.assertEquals("lion",value.getName());
    }

    @Test public void bracketsOverlapping(){
        String str = "{(})";
        boolean bool = Brackets.ValidateBrackets(str);
        Assertions.assertFalse(bool);
    }
    @Test public void wordsInBrackets() {
        String str = "()[[Extra Characters]]";
        boolean bool = Brackets.ValidateBrackets(str);
        Assertions.assertTrue(bool);
    }
    @Test public void bracketIncrementAtTheEnd() {
        String str = "[{}]]";
        boolean bool = Brackets.ValidateBrackets(str);
        Assertions.assertFalse(bool);
    }
    @Test public void bracketIncrementAtBeginning() {
        String str = "[({})";
        boolean bool = Brackets.ValidateBrackets(str);
        Assertions.assertFalse(bool);
    }
    @Test public void emptyString() {
        String str = "";
        boolean bool = Brackets.ValidateBrackets(str);
        Assertions.assertTrue(bool);
    }
}

