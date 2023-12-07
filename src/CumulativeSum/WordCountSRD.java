package CumulativeSum;

import java.util.Arrays;
import java.util.Scanner;

public class WordCountSRD {

	// 50/100  >>> CumSum
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // number of pages
		int K = sc.nextInt(); // number of range
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
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
			int[] slicedPages = Arrays.copyOfRange(A, A_left - 1, A_right);
			int sumA = calculateSRDSum(slicedPages);
			
			slicedPages = Arrays.copyOfRange(A, B_left - 1, B_right);
			int sumB = calculateSRDSum(slicedPages);
			
			result = (sumA == sumB)	? "DRAW"
									: sumA > sumB ? "A" : "B";
			System.out.println(result);
		}
		
		sc.close();

	}
	
	// Square Root Decomposition
	static int calculateSRDSum(int[] arr) {
		int sum = 0;
		int blockSize = (int) Math.sqrt(arr.length);
		int numBlocks = (int) Math.ceil((double) arr.length / blockSize);
		int[][] blocks = new int[numBlocks][blockSize];
		
		for (int i = 0; i < arr.length; i++) {
			int bIndex = i / blockSize;
			int innerIndex = i % blockSize;
			blocks[bIndex][innerIndex] = arr[i];
		}
		
		for (int i = 0; i < numBlocks; i++) {
			sum += findSum(blocks[i]) ;
		}
		
		return sum;
	}
	
	
	static int findSum(int[] arr){
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}


}
