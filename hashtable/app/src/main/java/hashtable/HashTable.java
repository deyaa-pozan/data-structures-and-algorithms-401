package hashtable;

import hashtable.LinkedList.Linkedlist;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Queue;

public class HashTable<K, V> {
    

    // bucket of hashnodes used to store linked list of
    // hashnodes in each bucket when collisions occur
    private ArrayList<HashNode<K, V>> bucketArray;

    // will hold the current size of our bucketArray
    private int numBuckets;

    // will hold the total number of hashnodes in the bucket array
    private int size;

    public HashTable() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // create bucket array AKA simulate an actual array
        for (int index = 0; index < numBuckets; index++) {
            bucketArray.add(null);
        }
    }

    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    public int hash(K key) {
        return Objects.hashCode(key)%numBuckets * -1;
    }
    

    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // hashCode can be negative (key.hashCode() can be -ve (negative))
        // so we need to make it positive
        index = index < 0 ? index * -1 : index;

        return index;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
    public void add(K key, V value) {

        // gets the head of a linked list for a given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // check if key present
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) { // checks for duplicates
                // if there is a duplicate just overwrite
                head.value = value;
                return;
            }

            // adds to the chain of the linkedlist, by adding to the front
            head = head.next;
        }

        // insert the value in to the position
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // if the load factor (number of hasnnodes) goes beyond the threshold
        // double the hashtble aka the bucket array
        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;

            // increase bucket array size
            for (int index = 0; index < numBuckets; index++) {
                bucketArray.add(null);
            }

            // copy back in the original data to the increased bucket array
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public String repeatedWord(String str){
        String [] words = str.toLowerCase(Locale.ROOT).split(" ");
        HashTable<String, Integer> hashTable = new HashTable<>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].contains(",")){
                words[i] = words[i].substring(0, words[i].length()-1);
            }
            if(!words[i].equals("")){
                if (hashTable.get(words[i]) != null){
                    return words[i];
                }
                hashTable.add(words[i],i);
            }
        }
        return "not exist repeated word";
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                return head.value;
            }

            head = head.next;
        }

        return null;
    }

    public boolean contains(K key){
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode)
                return true;
        }

        return false;
    }

    public ArrayList<ArrayList<String>> leftJoin(HashTable<K,V> t1, HashTable<K,V> t2){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (HashNode<K,V> n:t1.bucketArray){
            HashNode<K,V> head=n;
            while (head!=null){
                ArrayList<String> inner= new ArrayList<>();
                inner.add((String) head.key) ;
                inner.add((String) head.value);
                inner.add((String) t2.get(head.key)) ;
                list.add(inner);
                head=head.next;
            }
        }
        return list;
    }



    public boolean uniqueCharacters(String str) {
        char[] c = new char[str.length()];
        for (int i = 0; i <str.length(); i++)
        { char c1 = str.charAt(i);
            c[i] = c1;
        }

        HashTable<Character, Character> hashTable = new HashTable<>();
        for (int i = 0; i < c.length; i++) {
            if(c[i]!=' ' && c[i]!=','){
                if (hashTable.get(c[i]) != null){
                    return false;
                }
                hashTable.add(c[i],c[i]);
            }
        }
        return true;
    }


    @Override
    public String toString() {
        if(this.size ==0)
            return "Null";

        StringBuilder out = new StringBuilder();
        for (int i = 0 ; i < bucketArray.size(); i++) {
            if (bucketArray.get(i)==null)
                continue;
            out.append(i);
            out.append(" : [ ");
            out.append(bucketArray.get(i).toString());
            out.append(" ]\n");
        }

        return out.toString();
    }

}
