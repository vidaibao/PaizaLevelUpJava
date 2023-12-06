package CumulativeSum;

import java.util.Scanner;

public class TwoDIntervalCumSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int H = sc.nextInt(); int W = sc.nextInt(); int N = sc.nextInt();

		int[][] A = new int[H][W];
		// 
		
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		int[][] S = calculateCumulativeSum(A);
		
		// 
		for (int i = 1; i <= N; i++) {
			int topLeftRow = sc.nextInt() - 1;
	        int topLeftCol = sc.nextInt() - 1;
	        int bottomRightRow = sc.nextInt() - 1;
	        int bottomRightCol = sc.nextInt() - 1;
	        int result = calculateIntervalSum(S, topLeftRow, topLeftCol, bottomRightRow, bottomRightCol);
	        System.out.println(result);
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

/*
 * H 行 W 列 の行列 A の 2 つの行・列番号の組 {a , b} , {c , d} における区間和 
 * S({a,b} , {c,d}) (a ≦ c , b ≦ d) を以下の数式・図の通り定義します。
 * 以後 A の y 行 x 列の要素を A[y][x] と表すことにします。

S({a,b} , {c,d}) = 
A[a][b] + A[a][b+1] + ... + A[a][d] + A[a+1][1] + ... + A[a+1][d] + 
			... + A[c][1] + ... + A[c][d]
 */