package CumulativeSum;

import java.util.Arrays;
import java.util.Scanner;

public class ScoreRange {
	// pass 50/100 wrong result
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // number of students
		int K = sc.nextInt(); // number of games
		
		int[] S = new int[N]; // score list
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
		}
		for (int i = 0; i < K; i++) {
			int A_l = sc.nextInt(); int A_r = sc.nextInt();
			int B_l = sc.nextInt(); int B_r = sc.nextInt();
			
			int[] selectedA = Arrays.copyOfRange(S, A_l - 1, A_r);
			int rangeA = squareRootDecompositionRange(selectedA);
			
			int[] selectedB = Arrays.copyOfRange(S, B_l - 1, B_r);
			int rangeB = squareRootDecompositionRange(selectedB);
			
			String result = rangeA == rangeB ? "DRAW"
					: rangeA > rangeB ? "A" : "B";
			System.out.println(result);
		}
		sc.close();
	}
	
	
	private static int squareRootDecompositionRange(int[] arr) {
		int len = arr.length;
		int blockSize = (int) Math.sqrt(len);
		int blockNum = (int) Math.ceil( (double) len / blockSize);
		int[][] blocks = new int[blockNum][blockSize];
		
		for (int i = 0; i < len; i++) {
			int blockIndex = i / blockSize;
			int innerIndex = i % blockSize;
			blocks[blockIndex][innerIndex] = arr[i];
		}
		int max = findMax(blocks[0]);
		for (int i = 1; i < blockNum; i++) {
			int temp = findMax(blocks[i]);
			if (temp > max) max = temp;
		}
		int min = findMin(blocks[0]);
		for (int i = 1; i < blockNum; i++) {
			int temp = findMin(blocks[i]);
			if (temp < min) min = temp;
		}
		return max - min;
	}


	static int findMax(int[] arr){
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) max = arr[i];
		}
		return max;
	}
	
	static int findMin(int[] arr){
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) min = arr[i];
		}
		return min;
	}

}
