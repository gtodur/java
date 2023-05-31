package practice.linkedlist;

public class TestLinkedList {

	public static void main(String[] args) {
		
		/**
		 * ######################### SINGLE LINKED LIST - START #########################
		 */
		
		SingleLinkedList<Integer> sll = new SingleLinkedList<>();
		sll.setHead(new Node<Integer>(23));
		Node<Integer> second = new Node<>(45);
		Node<Integer> third = new Node<>(37);
		Node<Integer> fourth = new Node<>(88);
		sll.getHead().setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		
		//print
		sll.printSLL();
		
		//length
		System.out.println("Length : " + sll.length());
		
		//insertFirst
		sll.insertFirst(11);
		sll.printSLL();
		
		//insertLast
		sll.insertLast(65);
		sll.printSLL();
		
		//insertAtPosition
		sll.insertAtPosition(2, 24);
		sll.printSLL();
		
		//deleteFirst
		Node<Integer> deletedNode = sll.deleteFirst();
		System.out.println("Linked list after deleting first item : " + deletedNode.getData() + " is - ");
		sll.printSLL();
		
		//deleteLast
		deletedNode = sll.deleteLast();
		System.out.println("Linked list after deleting last item : " + deletedNode.getData() + " is - ");
		sll.printSLL();
				
		//deleteAtPosition
		sll.deleteAtPosition(3);
		System.out.println("Linked list after deleting item at position 3 : ");
		sll.printSLL();
		
		//search
		System.out.println(sll.isDataExists(45));
		System.out.println(sll.isDataExists(88));
		
		//reverse
		System.out.println("Linked list before reverse -- ");
		sll.printSLL();
		Node<Integer> reversedhead = sll.reverse();
		System.out.println("Linked list after reverse -- ");
		sll.printSLLByNode(reversedhead);
		
		System.out.println();
		System.out.println("----------------------------------------------");
		
		SingleLinkedList<Integer> sll2 = new SingleLinkedList<>();
		sll2.insertFirst(45);
		sll2.insertFirst(27);
		sll2.insertAtPosition(1, 11);
		sll2.insertAtPosition(1, 21);
		sll2.printSLL();
		
		/**
		 * ######################### SINGLE LINKED LIST - END #########################
		 */
		
		System.out.println("----------------------------------------------");
		
		/**
		 * ######################### DOUBLE LINKED LIST - START #########################
		 */
		
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
		//add first
		dll.insertFirst(45);
		dll.insertFirst(76);
		dll.insertFirst(13);
		
		//print - forward and backward
		System.out.println("Printing in forward direction - ");
		dll.displayForward();
		System.out.println();
		System.out.println("Printing in backward direction - ");
		dll.displayBackward();
		
		//add last
		dll.insertLast(11);
		dll.insertLast(22);
		dll.insertLast(33);
		
		//print - forward and backward
		System.out.println("Printing in forward direction - ");
		dll.displayForward();
		System.out.println();
		System.out.println("Printing in backward direction - ");
		dll.displayBackward();
		
		System.out.println();
		
		dll.displayForward();
		
		System.out.println();
		
		//delete first
		System.out.println("Deleted first node -> " + dll.deleteFirst().getData());
		
		//delete last
		System.out.println("Deleted last node -> " + dll.deleteLast().getData());
		
		dll.displayForward();
		
		/**
		 * ######################### DOUBLE LINKED LIST - END #########################
		 */
		System.out.println();
		System.out.println("----------------------------------------------");
		
		/**
		 * ######################### CIRCULAR LINKED LIST - START #########################
		 */
		CircularLinkedList<Integer> cll = new CircularLinkedList<>();
		
		
		Node<Integer> firstCLLNode = new Node<>(23);
		Node<Integer> secondCLLNode = new Node<>(45);
		Node<Integer> thirdCLLNode = new Node<>(67);
		firstCLLNode.setNext(secondCLLNode);
		secondCLLNode.setNext(thirdCLLNode);
		thirdCLLNode.setNext(firstCLLNode);
		cll.setLast(thirdCLLNode);
		
		//print
		cll.display();
		
		System.out.println();
		
		//insert first
		cll.insertFirst(19);
		cll.insertFirst(11);
		cll.display();
		
		System.out.println();
		
		//insert last
		cll.insertLast(74);
		cll.insertLast(83);
		cll.display();
		
		System.out.println();
		
		//remove first
		System.out.println("First item removed from CLL - " + cll.deleteFirst().getData());
		System.out.println("First item removed from CLL - " + cll.deleteFirst().getData());
		
		/**
		 * ######################### CIRCULAR LINKED LIST - END #########################
		 */
	}

}
