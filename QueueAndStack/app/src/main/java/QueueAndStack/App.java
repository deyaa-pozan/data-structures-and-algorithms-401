/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package QueueAndStack;

public class App {

    public static void main(String[] args) {


        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);
        queue.enqueue(1);

        System.out.println(queue.toString());

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());


        System.out.println(queue.size);

        System.out.println("-----------");
        Stack<String> stack = new Stack<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack);

    }
}