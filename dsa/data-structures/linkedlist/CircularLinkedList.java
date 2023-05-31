package practice.linkedlist;

public class CircularLinkedList<T> {
	private Node<T> last;
	private int length;
	
	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

	public int getLength() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}
	
	public void display() {
		if(last == null) return;
		Node<T> current = last.getNext();
		while(current != last) {
			System.out.print(current.getData() + " --> ");
			current = current.getNext();
		}
		System.out.print(last.getData());
	}
	
	public void insertFirst(T data) {
		Node<T> newNode = new Node<>(data);
		if(last == null) {
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
		}
		last.setNext(newNode);
		length++;
	}
	
	public void insertLast(T data) {
		Node<T> newNode = new Node<>(data);
		if(last == null) {
			last = newNode;
			last.setNext(last);
		} else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
			last = newNode;
		}
		length++;
	}
	
	public Node<T> deleteFirst() {
		if(last == null) {
			return null;
		}
		Node<T> temp = last.getNext();
		if(last.getNext() == last) {
			last = null;
		} else {
			last.setNext(temp.getNext());
		}
		temp.setNext(null);
		length--;
		return temp;
	}
}