package Query;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int Q = sc.nextInt();
		Set<Integer> mySet = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			mySet.add(sc.nextInt());
		}

		for (int i = 0; i < Q; i++) {
			int el = sc.nextInt();
			System.out.println(mySet.contains(el) ? "YES" : "NO" );
		}
		
		sc.close();
	} 

}
