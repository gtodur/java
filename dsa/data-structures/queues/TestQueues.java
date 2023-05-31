package practice.queues;

public class TestQueues {

	public static void main(String[] args) {
		QueueAsLinkedList<Integer> queue = new QueueAsLinkedList<>();
		
		//enqueue
		queue.enqueue(10);
		queue.enqueue(20);
		
		queue.display();
		
		queue.enqueue(30);
		
		queue.display();
		
		//dequeue
		queue.dequeue();
		
		queue.display();
 
	}

}
