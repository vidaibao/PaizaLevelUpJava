package ClassPratices;

public class SuperSuperSuperCar extends SuperCar {

	public SuperSuperSuperCar(int l, int f) {
		super(l, f);
		// TODO Auto-generated constructor stub
	}

	void fly() {
		if (l < 5) {
			run();
		} else {
			len += 2 * Math.pow(f, 2);
			l -= 5;
		}
	}
	
	void teleport() {
		if (l < Math.pow(f, 2)) {
			fly();
		} else {
			len += Math.pow(f, 4);
			l -= Math.pow(f, 2);
		}
		
	}
}
