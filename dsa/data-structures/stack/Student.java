package practice.stack;

public class Student {
	private String name;
	private String rollNo;
	
	public Student(String name, String rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}
	
	
}
