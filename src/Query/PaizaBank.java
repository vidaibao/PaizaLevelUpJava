package Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;

public class PaizaBank {

	// Array List
	
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();
		List<BankCustomer> companies = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			companies.add(new BankCustomer(sc.next(), sc.next(), sc.nextInt()));
		}
		
		for (int i = 0; i < K; i++) {
			String name = sc.next();
			String pw = sc.next();
			int w = sc.nextInt();
			// Optional class of Java 8. avoid return null. Optional safety for exits or not.
			// Optional<BankCustomer> c = companies.parallelStream() 50/100
			Optional<BankCustomer> c = companies.stream()	// 75/100
					.filter(x -> x.name.equals(name))
					.findFirst();
			if (c.isPresent()) {
				BankCustomer bc = c.get();
				if (bc.getPass().equals(pw)) {
					bc.withdraw(w);
				}
			}
		}
		
		sc.close();
		
		// result
		companies.forEach(x -> System.out.println(x.printNameBalance()));
	}
	 
	
	
	// Array over time   with 73825 83746	75/100
	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();
		
		BankCustomer[] companies = new BankCustomer[N];

		for (int i = 0; i < N; i++) {
			companies[i] = new BankCustomer(sc.next(), sc.next(), sc.nextInt());
		}
		
		for (int i = 0; i < K; i++) {
			String name = sc.next();
			String pw = sc.next();
			int w = sc.nextInt();

			for(BankCustomer bc : companies) {
				if (bc.getName().equals(name)) {
					if (bc.getPass().equals(pw)) {
						bc.withdraw(w);
					}
					break;
				}
			}
		}
		
		sc.close();
		
		// result
		for(BankCustomer bc : companies) {
			System.out.println(bc.printNameBalance());
		}
	}
	
	
	// HashMap print result failed b/c not guarantee order 25/100
	public static void main0(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();

		Map<String, Customer> customers = new HashMap<String, Customer>(); 


		for (int i = 0; i < N; i++) {
			customers.put(sc.next(), new Customer(sc.next(), sc.nextInt()));
		}
		
		for (int i = 0; i < K; i++) {
			String key = sc.next();
			String pw = sc.next();
			int w = sc.nextInt();

			Customer customer = customers.get(key);
			//System.out.println(customer.toString());
			if (customer == null || !customer.pass.equals(pw)) continue;
				
			customers.put(key, new Customer(pw, customer.balance - w));
		}
		
		sc.close();
		
		// result
		for (Map.Entry<String, Customer> entry : customers.entrySet()) {
			String companyName = entry.getKey();
			int balance = entry.getValue().balance;
			System.out.println(companyName + " " + balance);
		}
	}
	
	// LinkedHashMap PASS
	/*The HashMap class in Java does not guarantee any specific order of elements. 
	 * If you want to maintain the order of elements in a Map, you can use 
	 * LinkedHashMap. LinkedHashMap maintains the order in which elements are 
	 * inserted. When you iterate over the map, the elements will be returned in 
	 * the order in which they were inserted.
	 * 
	 *  If you want to maintain the order based on natural ordering or a custom 
	 *  comparator, you might consider TreeMap*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();

		Map<String, Customer> customers = new LinkedHashMap<String, Customer>(); 


		for (int i = 0; i < N; i++) {
			customers.put(sc.next(), new Customer(sc.next(), sc.nextInt()));
		}
		
		for (int i = 0; i < K; i++) {
			String key = sc.next();
			String pw = sc.next();
			int w = sc.nextInt();

			Customer customer = customers.get(key);
			
			if (customer == null || !customer.pass.equals(pw)) continue;
				
			customers.put(key, new Customer(pw, customer.balance - w));
		}
		
		sc.close();
		
		// result
		for (Map.Entry<String, Customer> entry : customers.entrySet()) {
			String companyName = entry.getKey();
			int balance = entry.getValue().balance;
			System.out.println(companyName + " " + balance);
		}
	}
	
}

class Customer{
	String pass;
	int balance;
	public Customer(String pass, int balance) {
		super();
		this.pass = pass;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [pass=" + pass + ", balance=" + balance + "]";
	}
}
