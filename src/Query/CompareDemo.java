package Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareDemo {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Eve", 22));
        people.add(new Person("Sushi", 22));

        // Sorting via Comparable
        Collections.sort(people);

        System.out.println("Sorting by age, if same age then by name:");
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }

        // Sorting by Comparator
        Collections.sort(people, new AgeNameComparator());

        System.out.println("\nSorting descending by Comparator (age, then by name):");
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }

	}

}
