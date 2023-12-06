package Query;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Accounting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();

		Map<String, List<Recipt>> accs = new LinkedHashMap<>(); 

		
		for (int i = 0; i < N; i++) {
			List<Recipt> receipts = new ArrayList<Recipt>();
			accs.put(sc.next(), receipts);
		}
		
		for (int i = 0; i < K; i++) {
			String key = sc.next();
			String orderNum = sc.next();
			int money = sc.nextInt();
			List<Recipt> receipts = accs.get(key);
			receipts.add(new Recipt(orderNum, money));
			accs.put(key, receipts);
		}
		
		sc.close();
		
		// print result
		for (Map.Entry<String, List<Recipt>> entry : accs.entrySet()) {
			String departmentName = entry.getKey();
			List<Recipt> rr = entry.getValue();
			System.out.println(departmentName);
			for (Recipt r : rr) {
				System.out.println(r.toString());
			}
			System.out.println("-----");
		}

	}

}



class Recipt {
	String p; // order number
	int m; // money
	public Recipt(String p, int m) {
		super();
		this.p = p;
		this.m = m;
	}
	@Override
	public String toString() {
		return p + " " + m;
	}
	
}
