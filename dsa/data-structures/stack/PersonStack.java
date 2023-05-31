package practice.stack;

public class PersonStack {
	
	private Student [] stack;
	private int top;
	private int size;
	
	public PersonStack() {
		top = -1;
		size = 50;
		stack = new Student [50];
	}

	public PersonStack(int size) {
		top = -1;
		this.size = size;
		stack = new Student [size];
	}
	
	public boolean push(Student item) {
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
	
	
	public Student pop() {
		return stack[top--];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	Student peek() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return null; 
        } 
        else { 
            Student x = stack[top]; 
            return x; 
        } 
    }

}
