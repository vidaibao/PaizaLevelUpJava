package Query;

import java.util.Comparator;

public class AgeNameComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		int ageComparison = Integer.compare(p2.age, p1.age);
		if (ageComparison != 0) return ageComparison;
		return p2.getName().compareTo(p1.getName());
	}
}
