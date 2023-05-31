package practice.queues;

public class QueueAsLinkedList<T> {
		private Node<T> front;
		private Node<T> rear;
		private int length;
		
		public Node<T> getFront() {
			return front;
		}
		public void setFront(Node<T> front) {
			this.front = front;
		}
		public Node<T> getRear() {
			return rear;
		}
		public void setRear(Node<T> rear) {
			this.rear = rear;
		}
		public int getLength() {
			return length;
		}
		
		public QueueAsLinkedList() {
			this.front = null;
			this.rear = null;
			this.length = 0;
		}
		
		public boolean isEmpty() {
			return length == 0;
		}
		
		public void display() {
			if(isEmpty()) return;
			Node<T> current = front;
			while(current != null) {
				System.out.print(current.getData() + " --> ");
				current = current.getNext();
			}
			System.out.println();
		}
		
		public void enqueue(T data) {
			Node<T> newNode = new Node<>(data);
			if(isEmpty()) {
				front = newNode;
			} else {
				rear.setNext(newNode);
			}
			rear = newNode;
			length++;
		}
		
		public T dequeue() {
			if(isEmpty()) {
				return null;
			}
			T result = front.getData();
			front = front.getNext();
			if(front == null) {
				rear = null;
			}
			length--;
			return result;
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

