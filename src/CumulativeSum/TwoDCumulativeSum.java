package CumulativeSum;

import java.util.Scanner;

public class TwoDCumulativeSum {

	// PASSED
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int H = sc.nextInt(); int W = sc.nextInt(); int N = sc.nextInt();

		int[][] A = new int[H+1][W+1];
		// int[][] S = new int[H+1][W+1];
		A[0][0] = 0;
		
		// S(i,j) = S(i-1,j) + S(i,j-1) - S(i-1,j-1) + A[i][j]
		for (int i = 1; i <= H; i++) {
			A[i][0] = 0;
			for (int j = 1; j <= W; j++) {
				A[i][j] = A[i][j-1] + sc.nextInt();
			}
		}
		
		// 
		for (int i = 1; i <= N; i++) {
			int y = sc.nextInt(); int x = sc.nextInt();
			int ans = 0;
			for (int j = 1; j <= y; j++) {
				ans += A[j][x]; 
			}
			System.out.println(ans);
		}
		
		sc.close();
	}

	
	
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
			int y = sc.nextInt(); int x = sc.nextInt();
			
			System.out.println(S[y-1][x-1]);
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
	
}

/*
 * 方針
クエリの問題では、与えられるクエリの数から 1 クエリあたりの計算量を概算するのも効果的です。
例えば、今回の問題では与えられるペアをクエリとみなすことができ、その数は最大で 100,000 であるから、 
1 クエリあたりおおよそ 1000 回未満に抑えたいと気づくことができます。
これらを踏まえて問題をみてみましょう。各クエリの累積和を問題文で与えられた計算式の通り計算を行うと
実行時間制限に間に合わないことがわかると思います。
では、どのように S(y,x) を計算すれば良いのでしょうか。
計算量を落とすためには、事前に値を計算しておいたり、既に計算した値を再利用したりすることが有効です。
A の要素を端から見ていくと同時に、注目している要素の S(y,x) も計算できないかを考えてみます。
行番号が 1 のときの場合に限っては
S(1,1) = A[1][1]
S(1,i) = A[1][1] + ... + A[1][i]
といった具合に 1 次元配列の累積和と同様に扱うことができますが、2 行目以降については同じようには計算できません。
*/
