package practice.test;

public class Person {
	private String name;
	private int ssn;
	private String employment;
	private String address;
	private String phone;
	
	public Person(String name, int ssn, String employment, String address, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.employment = employment;
		this.address = address;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", ssn=" + ssn + ", employment=" + employment + ", address=" + address
				+ ", phone=" + phone + "]";
	}
}
