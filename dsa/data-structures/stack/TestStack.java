package practice.stack;

public class TestStack {

	public static void main(String[] args) {
//		IntStack intStack = new IntStack();
//		if(!intStack.isFull()) {
//			intStack.push(2);
//			intStack.push(4);
//			intStack.push(6);
//			intStack.push(8);
//		}
//		
//		System.out.println("Item popped : " + intStack.pop());
//		System.out.println("Item popped : " + intStack.pop());
		
		Student p1 = new Student("Guru", "123");
		Student p2 = new Student("Prasad", "456");
		Student p3 = new Student("Todur", "789");
		
		PersonStack personStack = new PersonStack();
		personStack.push(p1);
		personStack.push(p2);
		personStack.push(p3);
		
		System.out.println("Person popped : " + personStack.pop());
		System.out.println("Person popped : " + personStack.pop());
		
		System.out.println("----------------------------------------------------------------------------");
		
		StackAsLinkedList<Integer> stack = new StackAsLinkedList<>();
		//peek
		System.out.println("Element at top of stack - " + stack.peek());
				
		//push
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		//peek
		System.out.println("Element at top of stack - " + stack.peek());
		
		//pop
		System.out.println("Item popped - " + stack.pop());
		
		//peek
		System.out.println("Element at top of stack - " + stack.peek());
		
		
		
	}

}
