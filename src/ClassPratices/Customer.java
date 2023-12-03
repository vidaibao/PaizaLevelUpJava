package ClassPratices;

public class Customer {
	int total;
	static int absent;
	
	public void orderFood(int amount) {
		this.total += amount;
	}
	
	public void orderSoftDrink(int amount) {
		this.total += amount;
	}
	
	public void orderAlcohol(int amount) {}
	
	public void orderAlcohol() {
		orderAlcohol(500);
	}
}
