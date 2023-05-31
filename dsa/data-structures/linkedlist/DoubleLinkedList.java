package practice.linkedlist;

public class DoubleLinkedList<T> {
	 private DoubleNode<T> head;
	 private DoubleNode<T> tail;
	 private int length;
	 
	 public DoubleLinkedList() {
		 this.head = null;
		 this.tail = null;
		 this.length = 0;
	 }
	 
	 public DoubleNode<T> getHead() {
		return head;
	}

	public void setHead(DoubleNode<T> head) {
		this.head = head;
	}

	public DoubleNode<T> getTail() {
		return tail;
	}

	public void setTail(DoubleNode<T> tail) {
		this.tail = tail;
	}

	public void setLength(int length) {
		this.length = length;
	}

	 public boolean isEmpty() {
		 return length == 0; //OR head == null
	 }
	 
	 public void displayForward() {
		 if(head == null) return;
		 DoubleNode<T> current = head;
		 while(current != null) {
			 System.out.print(current.getData() + " --> ");
			 current = current.getNext();
		 }
		 System.out.print("null");
	 }
	 
	 public void displayBackward() {
		 if(tail == null) return;
		 DoubleNode<T> current = tail;
		 while(current != null) {
			 System.out.print(current.getData() + " --> ");
			 current = current.getPrevious();
		 }
		 System.out.print("null");
	 }

	public void insertFirst(T data) {
		DoubleNode<T> newNode = new DoubleNode<>(data);
		if(isEmpty()) {
			tail = newNode;
		} else {
			head.setPrevious(newNode);
		}
		newNode.setNext(head);
		head = newNode;
		length++;
	}
	
	public void insertLast(T data) {
		DoubleNode<T> newNode = new DoubleNode<>(data);
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
		}
		tail = newNode;
		length++;
	}
	
	public DoubleNode<T> deleteFirst() {
		if(isEmpty()) {
			return null;
		}
		DoubleNode<T> current = head;
		if(head == tail) {
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}
		head = head.getNext();
		current.setNext(null);
		return current;
	}

	public DoubleNode<T> deleteLast() {
		if(isEmpty()) {
			return null;
		}
		DoubleNode<T> current = tail;
		if(head == tail) {
			head = null;
		} else {
			tail.getPrevious().setNext(null);
		}
		tail = tail.getPrevious();
		current.setPrevious(null);
		return current;
	}
}

class DoubleNode<T> {
	private T data;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	
	public DoubleNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}
} 
