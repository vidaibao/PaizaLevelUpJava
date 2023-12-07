package CumulativeSum;

import java.util.Scanner;

public class WordCountCumSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // number of pages
		int K = sc.nextInt(); // number of range
		int[] S = new int[N + 1];
		S[0] = 0;
		for (int i = 1; i <= N; i++) {
			S[i] = S[i-1] + sc.nextInt();
		}

		String result = "";
		for (int i = 0; i < K; i++) {
			result = ""; 
			int A_left = sc.nextInt(); int A_right = sc.nextInt();
			int B_left = sc.nextInt(); int B_right = sc.nextInt();
			
			// check constrain illegal
			boolean illegal = false;
			if ((A_right - A_left + 1) * 3 >= N && (B_right - B_left + 1) * 3 >= N ) {
				result = "DRAW"; illegal = true;
			} else if ((A_right - A_left + 1) * 3 >= N) {// && (B_right - B_left + 1) * 3 < N ) {
				result = "B"; illegal = true;
			} else if ((B_right - B_left + 1) * 3 >= N ) {
				result = "A"; illegal = true;
			}
			
			if (illegal) {
				System.out.println(result);
				continue;
			}
			
			// calculate word
			int sumA = S[A_right] - S[A_left - 1];
			int sumB = S[B_right] - S[B_left - 1];
			
			result = (sumA == sumB)	? "DRAW"
					: sumA > sumB ? "A" : "B";
			
			System.out.println(result);
		}
		sc.close();
	}

}
