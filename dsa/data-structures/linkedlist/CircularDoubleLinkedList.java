package practice.linkedlist;

public class CircularDoubleLinkedList<T> {
	
	DoubleNode<T> start;
	
	void insertEnd(T value)
	{
	    // If the list is empty, create a single node
	    // circular and doubly list
	    if (start == null)
	    {
	    	DoubleNode<T> new_node = new DoubleNode<T>(value);
	        new_node.next = new_node.prev = new_node;
	        start = new_node;
	        return;
	    }
	 
	    // If list is not empty
	 
	    /* Find last node */
	    DoubleNode<T> last = (start).prev;
	 
	    // Create Node dynamically
	    DoubleNode<T> new_node = new DoubleNode<T>(value);
	 
	    // Start is going to be next of new_node
	    new_node.next = start;
	 
	    // Make new node previous of start
	    (start).prev = new_node;
	 
	    // Make last previous of new node
	    new_node.prev = last;
	 
	    // Make new node next of old last
	    last.next = new_node;
	}
	 
	// Function to insert Node at the beginning
	// of the List,
	void insertBegin(T value)
	{
	    // Pointer points to last Node
		DoubleNode<T> last = (start).prev;
	 
		DoubleNode<T> new_node = new DoubleNode<T>(value); // Inserting the data
	 
	    // setting up previous and next of new node
	    new_node.next = start;
	    new_node.prev = last;
	 
	    // Update next and previous pointers of start
	    // and last.
	    last.next = (start).prev = new_node;
	 
	    // Update start pointer
	    start = new_node;
	}
	 
	// Function to insert node with value as value1.
	// The new node is inserted after the node with
	// with value2
	void insertAfter(T value1, T value2)
	{
		DoubleNode<T> new_node = new DoubleNode<T>(value1); // Inserting the data
	 
	    // Find node having value2 and next node of it
		DoubleNode<T> temp = start;
	    while (temp.data != value2)
	        temp = temp.next;
	    DoubleNode<T> next = temp.next;
	 
	    // insert new_node between temp and next.
	    temp.next = new_node;
	    new_node.prev = temp;
	    new_node.next = next;
	    next.prev = new_node;
	}
	 
	void display()
	{
		DoubleNode<T> temp = start;
	 
	    System.out.printf("\nTraversal in forward direction \n");
	    while (temp.next != start)
	    {
	        System.out.printf("%d ", temp.data);
	        temp = temp.next;
	    }
	    System.out.printf("%d ", temp.data);
	 
	    System.out.printf("\nTraversal in reverse direction \n");
	    DoubleNode<T> last = start.prev;
	    temp = last;
	    while (temp.prev != last)
	    {
	        System.out.printf("%d ", temp.data);
	        temp = temp.prev;
	    }
	    System.out.printf("%d ", temp.data);
	}
	
	DoubleNode<T> deleteNode(DoubleNode<T> start, T key)
    {
        // If list is empty
        if (start == null)
            return null;
 
        // Find the required node
        // Declare two pointers and initialize them
        DoubleNode<T> curr = start, prev_1 = null;
        while (curr.data != key) {
            // If node is not present in the list
            if (curr.next == start) {
                System.out.printf("\nList doesn't have node with value = %d", key);
                return start;
            }
 
            prev_1 = curr;
            curr = curr.next;
        }
 
        // Check if node is the only node in list
        if (curr.next == start && prev_1 == null) {
            (start) = null;
            return start;
        }
 
        // If list has more than one node,
        // check if it is the first node
        if (curr == start) {
            // Move prev_1 to last node
            prev_1 = (start).prev;
 
            // Move start ahead
            start = (start).next;
 
            // Adjust the pointers of prev_1 and start node
            prev_1.next = start;
            (start).prev = prev_1;
        }
 
        // check if it is the last node
        else if (curr.next == start) {
            // Adjust the pointers of prev_1 and start node
            prev_1.next = start;
            (start).prev = prev_1;
        }
        else {
            // create new pointer, points to next of curr node
        	DoubleNode<T> temp = curr.next;
 
            // Adjust the pointers of prev_1 and temp node
            prev_1.next = temp;
            temp.prev = prev_1;
        }
        return start;
    }
	
	int searchList(DoubleNode<T> start, T search)
	{
	    // Declare the temp variable
		DoubleNode<T> temp = start;
	     
	    // Declare other control
	    // variable for the searching
	    int count = 0, flag = 0, value;
	     
	    // If start is null return -1
	    if(temp == null)
	        return -1;
	    else
	    {
	        // Move the temp pointer until,
	        // temp.next doesn't move
	        // start address (Circular Fashion)
	        while(temp.next != start)
	        {
	            // Increment count for location
	            count++;
	             
	            // If it is found raise the
	            // flag and break the loop
	            if(temp.data == search)
	            {
	                flag = 1;
	                count--;
	                break;
	            }
	             
	            // Increment temp pointer
	            temp = temp.next;
	        }
	         
	        // Check whether last element in the
	        // list content the value if contain,
	        // raise a flag and increment count
	        if(temp.data == search)
	        {
	            count++;
	            flag = 1;
	        }
	         
	        // If flag is true, then element
	        // found, else not
	        if(flag == 1)
	            System.out.println("\n"+search +" found at location "+
	                                            count);
	        else
	            System.out.println("\n"+search +" not found");
	    }
	    return -1;
	}
}
