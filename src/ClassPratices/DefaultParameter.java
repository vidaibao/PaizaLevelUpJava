package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultParameter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Customer> customers = new ArrayList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();

		for(int i = 1; i <= N; i++) {
        	int age = sc.nextInt();
        	if (age < 20) {
				customers.add(new Customer());
			} else {
				customers.add(new Adult());
			}
        }
		
		for(int i = 0; i < K; i++) {
        	int index = sc.nextInt() - 1;
        	String s = sc.next();
        	
        	if (s.equals("0")) {
				customers.get(index).orderAlcohol();
			} else {
				int amount = sc.nextInt();
				
				if (s.equals("food")) {
					customers.get(index).orderFood(amount);
				} else if (s.equals("softdrink")) {
					customers.get(index).orderSoftDrink(amount);
				} else if (s.equals("alcohol")) {
					customers.get(index).orderAlcohol(amount);
				}
			}
        	
        }
        sc.close();
        
        for (Customer cus : customers) {
        	System.out.println(cus.total);
        }
	}

}
