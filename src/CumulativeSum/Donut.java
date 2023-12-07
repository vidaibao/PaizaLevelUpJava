package CumulativeSum;

import java.util.Scanner;

public class Donut {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int H = sc.nextInt(); int W = sc.nextInt(); int N = sc.nextInt();

		int[][] C = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				C[i][j] = sc.nextInt();
			}
		}
		
		int[][] sumC = calculateCumulativeSum(C);
		
		// 
		for (int i = 1; i <= N; i++) {
			int y = sc.nextInt() - 1; int x = sc.nextInt() - 1;
			int B = sc.nextInt(); int S = sc.nextInt();
			
			int topLeftRow = y - S/2;
	        int topLeftCol = x - S/2;
	        int bottomRightRow = y + S/2;
	        int bottomRightCol = x + S/2;
	        int innerSum = calculateIntervalSum(sumC, topLeftRow, topLeftCol, bottomRightRow, bottomRightCol);
	        
	        topLeftRow = y - B/2;
	        topLeftCol = x - B/2;
	        bottomRightRow = y + B/2;
	        bottomRightCol = x + B/2;
	        int outerSum = calculateIntervalSum(sumC, topLeftRow, topLeftCol, bottomRightRow, bottomRightCol);
	        
	        
	        System.out.println(outerSum - innerSum);
		}
				
		sc.close();
	}
	
	
	// S(i,j) = S(i-1,j) + S(i,j-1) - S(i-1,j-1) + A[i][j]
	private static int[][] calculateCumulativeSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int[][] cumSum = new int[rows][cols];

        // Cumulative Sum from first row
        cumSum[0][0] = arr[0][0];
        for (int j = 1; j < cols; j++) {
            cumSum[0][j] = cumSum[0][j - 1] + arr[0][j];
        }

        // Cumulative Sum from first Column
        for (int i = 1; i < rows; i++) {
            cumSum[i][0] = cumSum[i - 1][0] + arr[i][0];
        }

        // Cumulative Sum for the rest of array
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                cumSum[i][j] = cumSum[i - 1][j] + cumSum[i][j - 1] - cumSum[i - 1][j - 1] + arr[i][j];
            }
        }

        return cumSum;
    }
	
	// S({a,b},{c,d}) = S(a,d) - S(a,b)
	private static int calculateIntervalSum(int[][] cumSum, int topLeftRow, int topLeftCol, int bottomRightRow, int bottomRightCol) {
        int sum = cumSum[bottomRightRow][bottomRightCol];

        if (topLeftRow > 0) {
            sum -= cumSum[topLeftRow - 1][bottomRightCol];
        }

        if (topLeftCol > 0) {
            sum -= cumSum[bottomRightRow][topLeftCol - 1];
        }

        if (topLeftRow > 0 && topLeftCol > 0) {
            sum += cumSum[topLeftRow - 1][topLeftCol - 1];
        }

        return sum;
    }

}
