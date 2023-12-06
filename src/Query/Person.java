package Query;

public class Person implements Comparable<Person> {
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	// order by age then by name
	public int compareTo(Person otherPerson) {
		int ageComparison = Integer.compare(this.age, otherPerson.age);
		
		if (ageComparison != 0) return ageComparison;
		
		return this.name.compareTo(otherPerson.name);
	}
}
