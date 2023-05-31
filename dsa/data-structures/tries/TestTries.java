package practice.tries;

public class TestTries {

	public static void main(String[] args) {
		// construct a new Trie node
        Trie head = new Trie();
 
        head.insert("techie");
        head.insert("techi");
        head.insert("tech");
 
        System.out.println(head.search("tech"));            // true
        System.out.println(head.search("techi"));           // true
        System.out.println(head.search("techie"));          // true
        System.out.println(head.search("techiedelight"));   // false
 
        head.insert("techiedelight");
 
        System.out.println(head.search("tech"));            // true
        System.out.println(head.search("techi"));           // true
        System.out.println(head.search("techie"));          // true
        System.out.println(head.search("techiedelight"));   // true
        
        ////////////////////////////////////////////////////////////////
        
     // construct a new Trie node
        TrieUsingHashmap head1 = new TrieUsingHashmap();
 
        head1.insert("techie");
        head1.insert("techi");
        head1.insert("tech");
 
        System.out.println(head1.search("tech"));            // true
        System.out.println(head1.search("techi"));           // true
        System.out.println(head1.search("techie"));          // true
        System.out.println(head1.search("techiedelight"));   // false
 
        head1.insert("techiedelight");
 
        System.out.println(head1.search("tech"));            // true
        System.out.println(head1.search("techi"));           // true
        System.out.println(head1.search("techie"));          // true
        System.out.println(head1.search("techiedelight"));   // true

	}

}
