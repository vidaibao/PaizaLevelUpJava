package ClassPratices;

public class Adult extends Customer {
	
	boolean alcoholOrdered;
	
	public void orderAlcohol(int amount) {
		this.total += amount;
		alcoholOrdered = true;
	}
	
	public void orderFood(int amount) {
		if (alcoholOrdered) amount -= 200;
		super.orderFood(amount);
	}
	
}
