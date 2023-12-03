package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InheritanceClass {

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
        	int amount = sc.nextInt();
        	if (s.equals("food")) {
        		customers.get(index).orderFood(amount);
        	} else if (s.equals("softdrink")) {
        		customers.get(index).orderSoftDrink(amount);
			} else if (s.equals("alcohol")) {
				customers.get(index).orderAlcohol(amount);
			}
        }
        sc.close();
        
        for (Customer cus : customers) {
        	System.out.println(cus.total);
        }
	}

}


/*
 * 入力例1
2 5
59
5
2 food 1223
1 alcohol 4461
1 alcohol 4573
1 alcohol 1438
2 softdrink 1581

出力例1
10472
2804

入力例2
7 7
62
91
29
33
79
15
91
2 food 3134
7 alcohol 2181
6 softdrink 4631
3 softdrink 3120
4 softdrink 4004
6 alcohol 1468
6 alcohol 1245

出力例2
0
3134
3120
4004
0
4631
2181
 * */
 