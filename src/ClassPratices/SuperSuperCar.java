package ClassPratices;

public class SuperSuperCar extends SuperCar {

	public SuperSuperCar(int l, int f) {
		super(l, f);
		// TODO Auto-generated constructor stub
	}

	void fly () {
		if (l < 5) {
			run();
		} else {
			len += Math.pow(f, 2);
			l -= 5;
		}
	}
}
