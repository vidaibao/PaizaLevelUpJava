package Query;

import java.util.Scanner;

public class SingleInsert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt(); int Q = sc.nextInt(); 
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			System.out.println(a);
			if (i == K - 1) System.out.println(Q);
		}
	}

}
