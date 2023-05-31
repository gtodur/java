package practice.linkedlist;

public class SingleLinkedList<T> {

	private Node<T> head;
	
	public void setHead(Node<T> sllNode) {
		this.head = sllNode;
	}
	
	public Node<T> getHead() {
		return this.head;
	}
	
	public void printSLL() {
		System.out.println("List contains : ");
		Node<T> current = this.head;
		while(current != null) {
			System.out.print(current.getData() + " --> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
	
	public int length() {
		if(head == null) return 0;
		int count = 0;
		Node<T> current = head;
		while(current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public void insertFirst(T data) {
		Node<T> newNode = new Node(data);
		if(head == null) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	public Node<T> deleteFirst() {
		if(head == null) return null;
		Node<T> temp = head;
		head = head.getNext();
		temp.setNext(null);
		return temp;
	}
	
	public void insertAtPosition(int position, T data) {
		Node<T> newNode = new Node(data);
		if(position == 1) {
			newNode.setNext(head);
			head = newNode;
		} else {
			int count = 1;
			Node<T> previous = head;
			while(count < position - 1) {
				previous = previous.getNext();
				count++;
			}
			Node<T> current = previous.getNext();
			newNode.setNext(current);
			previous.setNext(newNode);
		}
	}
	
	public void deleteAtPosition(int position) {
		if(position == 1)  head = head.getNext();
		else {
			Node<T> previous = head;
			int count = 1;
			while(count < position - 1) {
				previous = previous.getNext();
				count++;
			}
			Node<T> current = previous.getNext();
			previous.setNext(current.getNext());
		}
	}
	 
	public void insertLast(T data) {
		Node<T> newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		} else {
			Node<T> current = head;
			while(null != current.getNext()) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}
	
	public Node<T> deleteLast() {
		if(head == null || head.getNext() == null) return head;
		Node<T> current = head;
		Node<T> previous = null;
		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(null);
		return current;
	}
	
	public boolean isDataExists(T searchKey) {
		Node<T> current = head;
		while(current != null) {
			if(current.getData() == searchKey) return true;
			current = current.getNext();
		}
		return false;
	}
	
	public Node<T> reverse() {
		if (head == null) return head;
		Node<T> current = head;
		Node<T> previous = null;
		Node<T> next = null;
		while(current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;	//here previous is the first node now 
	}
	
	public void printSLLByNode(Node<T> node) {
		if(node == null) System.out.println("null");
		while(node != null) {
			System.out.print(node.getData() + " --> ");
			node = node.getNext();
		}
		System.out.print("null");
	}
	 
}

class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
