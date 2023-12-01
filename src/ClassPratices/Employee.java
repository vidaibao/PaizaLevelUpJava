package ClassPratices;

public class Employee {
	Integer number;
	String name;
	
	public Employee(Integer number, String name) {
		this.number = number;
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return number + " "  + name;
	}
}
