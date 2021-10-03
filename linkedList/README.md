# Singly Linked List
The simplest type of linked-list, which mean that there is only one reference(the number of the node has).
Where nodes single connected to each other stated from the head, example: {1} -> {2} -> {3} -> NULL
## Challenge
Create a node class to Create a Linked List and use the methods to add the nodes (insert()), check of a value is in that list (includes()) and print the list content as a String. (toString()) Any exceptions or errors that come from your code should be semantic. and make a test for every possible cases of linked list.
## Approach & Efficiency
```
while(current != null) {
        result += "{ " + current.getData() + " } -> ";
        current = current.getNext();
    }
```
That will confirm that the next node in the list isn't null
**Space -> O(1)**
**Time -> O(n)**
## API
### insert()
Add a new node with value as an arguments to the head of list.
**Space -> O(1)**
**Time -> O(1)**
### includes()
A method indicates whether that certain Node's value exists somewhere within the list and return a true otherwise return false.
**Space -> O(1)**
**Time -> O(n)**
### toString()
Returns: a string representing all the values in the Linked List, formatted as:
"{ a } -> { b } -> { c } -> NULL"
**Space -> O(1)**
**Time -> O(n)**