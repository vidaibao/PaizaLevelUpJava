package Query;

public class Historian implements Comparable<Historian> {
	int year;
	String name;
	
	public Historian(int year, String name) {
		super();
		this.year = year;
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Historian [year=" + year + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Historian o) {
		int yearComparison = Integer.compare(this.year, o.year);
		if (yearComparison != 0) return yearComparison;
		return this.name.compareTo(o.name);
	}
	
	
}
