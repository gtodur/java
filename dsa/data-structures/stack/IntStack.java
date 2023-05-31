package practice.stack;

public class IntStack {
	
	private int [] stack;
	private int top;
	private int size;
	
	public IntStack() {
		top = -1;
		size = 50;
		stack = new int [50];
	}

	public IntStack(int size) {
		top = -1;
		this.size = size;
		stack = new int [50];
	}
	
	public boolean push(int item) {
		if(!isFull()) {
			top++;
			stack[top] = item;
			return true;
		} else {
			return false;
		}
			
		
	}
	
	public boolean isFull() {
		return (top == stack.length - 1);
	}
	
	
	public int pop() {
		return stack[top--];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	int peek() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        else { 
            int x = stack[top]; 
            return x; 
        } 
    }
}
