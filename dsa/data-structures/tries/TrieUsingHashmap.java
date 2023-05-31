package practice.tries;

import java.util.HashMap;
import java.util.Map;

/*
 * The space complexity of a Trie data structure is O(N × M × C), 
 * where N is the total number of strings, 
 * M is the maximum length of the string, 
 * and C is the alphabet’s size.
 * 
 * The storage problem can be alleviated if we only allocate memory for alphabets in use 
 * and don’t waste space storing null pointers. 
 * Following is a memory-efficient implementation of Trie data structure in Java, which uses HashMap to store a node’s children
 */

public class TrieUsingHashmap {
	private boolean isLeaf;
    private Map<Character, TrieUsingHashmap> children;
 
    // Constructor
    TrieUsingHashmap()
    {
        isLeaf = false;
        children = new HashMap<>();
    }
 
    // Iterative function to insert a string into a Trie
    public void insert(String key)
    {
        System.out.println("Inserting \"" + key + "\"");
 
        // start from the root node
        TrieUsingHashmap curr = this;
 
        // do for each character of the key
        for (char c: key.toCharArray())
        {
            // create a new node if the path doesn't exist
            curr.children.putIfAbsent(c, new TrieUsingHashmap());
 
            // go to the next node
            curr = curr.children.get(c);
        }
 
        // mark the current node as a leaf
        curr.isLeaf = true;
    }
 
    // Iterative function to search a key in a Trie. It returns true
    // if the key is found in the Trie; otherwise, it returns false
    public boolean search(String key)
    {
        System.out.print("Searching \"" + key + "\" : ");
 
        TrieUsingHashmap curr = this;
 
        // do for each character of the key
        for (char c: key.toCharArray())
        {
            // go to the next node
            curr = curr.children.get(c);
 
            // if the string is invalid (reached end of a path in the Trie)
            if (curr == null) {
                return false;
            }
        }
 
        // return true if the current node is a leaf node and the
        // end of the string is reached
        return curr.isLeaf;
    }
}
