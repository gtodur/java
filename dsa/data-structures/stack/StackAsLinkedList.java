package practice.stack;

public class StackAsLinkedList<T> { 
	  private Node<T> top;
    private int length;
    
    public StackAsLinkedList() {
    	this.top = null;
    	length = 0;
    }

	public Node<T> getTop() {
		return top;
	}

	public void setTop(Node<T> top) {
		this.top = top;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNext(top);
		top = newNode;
		length++;
	}
	
	public T pop() {
		if(isEmpty()) return null;
		T item = top.getData();
		top = top.getNext();
		length--;
		return item;
	}
	
	public T peek() {
		return top == null ? null : top.getData();
	}
	
}

class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
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
