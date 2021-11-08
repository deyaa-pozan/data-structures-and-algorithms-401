Implement a hashtable to store (key, value) pairs and retrieve the value in a fast way.

## Challenge

write the Java code to implement the hashtable and all its methods( add, get, contains, hash)
to store and retrieve data from this data structure in time complexity `O(1)`
where its method must do the following:

* `add`: takes in both the key and value. This method should hash the key, and add the key and value pair to the table, handling collisions as needed.
* `get`: takes in the key and returns the value from the table.
* `contains`: takes in the key and returns a boolean, indicating if the key exists in the table already.
* `hash`: takes in an arbitrary key and returns an index in the collection

## Approach & Efficiency

* ***Approach:***

Create an array of linked lists.. (buckets)of size `99` to hold the table in it

`hash(key):`

take a key as argument
calculate the sum for the ASCII code of each character in the key 
multibly the sum with `599`, where 599 is a prime number.
take the modulu of the result on the size of buckets:  `( result % 99 )`
return the final result ( index )

`add(key,value):`

hash the key.. using `hash` method 
go to the index returned from hash method in the buckets array.
check if the key is exist in the linked list which is inside the current bucket
if exist.. update the value of this key
if not .. add the pair(key, value) to the linked list

`get(key):`
hash the key.. using hash method 
go to the index returned from hash method
if the key is exist in this bucket.. return its value.
if not .. return null.

`contains(key):`
hash the key.. using hash method 
go to the index returned from hash method
if the key is exist in this bucket.. return true otherwise.. return false.

* ***Efficiency:***

***space: O(N)***

where n is the size of the array of buckets.

***time:*** 

* for add, get, contains:
  * average time : `O(1)`
  * worst case : `O(n)` "when the all keys is hashed to the same index."
* for hash: `O(1)`



# hashmap-repeated-word

Write a function that accepted a string parameter which  finds the first word to occur more than once in a string and return a string.

`repeatedWord(key):`


***space: O(N)***

***time:***

* for repeatedWord: `O(n^2)`

## Whiteboard Process

![repeate](repeate.jpg)