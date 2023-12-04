package ClassPratices;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperSuperCarDriven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); int K = sc.nextInt();
		ArrayList<SuperCar> cars = new ArrayList<SuperCar>();
		
		for (int i = 0; i < N; i++) {
			String kind = sc.next();
			if (kind.equals("supercar")) {
				cars.add(new SuperCar(sc.nextInt(), sc.nextInt()));
			} else if (kind.equals("supersupercar")) {
				cars.add(new SuperSuperCar(sc.nextInt(), sc.nextInt()));
			} else if (kind.equals("supersupersupercar")) {
				cars.add(new SuperSuperSuperCar(sc.nextInt(), sc.nextInt()));
			}
		}

		for (int i = 0; i < K; i++) {
			int index = sc.nextInt() - 1;
			String func = sc.next();
			if (func.equals("run")) {
				cars.get(index).run();
			} else if (func.equals("fly")) {
				cars.get(index).fly();
			} else if (func.equals("teleport")) {
				cars.get(index).teleport();
			}
		}
		
		sc.close();
		
		cars.forEach(car -> System.out.println(car.len));
	}

}
