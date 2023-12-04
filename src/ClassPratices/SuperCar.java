package ClassPratices;

public class SuperCar {
	int f, l;
	int len;
	
	public SuperCar(int l, int f) {
		super();
		this.f = f;
		this.l = l;
	}

	void run () {
		if (l <= 0) return;
		len += f;
		l--;
	}
	
	void fly() {}
	
	void teleport() {}
}
