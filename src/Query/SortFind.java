package Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortFind {

	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int X = sc.nextInt(); int P = sc.nextInt();

		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		
		sc.close();
		
		arr.add(X); arr.add(P);
		
		arr.sort( (a, b) -> a - b );
		
		System.out.println(arr.indexOf(P) + 1);
		
	}
	
	// multiple
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt(); int P = sc.nextInt();

		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		arr.add(P);
		
		for (int i = 0; i < K; i++) {
			String cond = sc.next();
			if (cond.equals("join")) {
				arr.add(sc.nextInt());
			} else if (cond.equals("sorting")) {
				arr.sort( (a, b) -> a - b );
				System.out.println(arr.indexOf(P) + 1);
			}
		}
		
		sc.close();
			
	}

}
