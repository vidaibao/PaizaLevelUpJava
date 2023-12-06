package CumulativeSum;

import java.util.Scanner;

public class CumulativeSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();
		
		int[] A = new int[N + 1];
		A[0] = 0;
		
		// Retrieve data
		for (int i = 1; i <= N; i++) {
			A[i] = A[i-1] + sc.nextInt(); // Cumulative sum
		}
		
		// Retrieve data
		for (int i = 0; i < K; i++) {
			int Q = sc.nextInt();
			System.out.println(A[Q]);
		}
		
		sc.close();
	}

}
