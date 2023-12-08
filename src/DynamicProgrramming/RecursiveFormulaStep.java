package DynamicProgrramming;

import java.util.Scanner;

public class RecursiveFormulaStep {

	// PASSED
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt(); int d = sc.nextInt(); int k = sc.nextInt();
		sc.close();
		
		int[] dp = new int[k];
		dp[0] = x;
		for(int i = 1; i < k; i++) {
			dp[i] = dp[i-1] + d;
		}
		
		System.out.println(dp[k-1]);
	}
	
	
	
	// PASSED
	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt(); int d = sc.nextInt(); 
		int Q = sc.nextInt();
		for(int j = 0; j < Q; j++) {
			int k = sc.nextInt();
			int[] dp = new int[k];
			
			dp[0] = x;
			for(int i = 1; i < k; i++) {
				dp[i] = dp[i-1] + d;
			}
			
			System.out.println(dp[k-1]);
		}
		sc.close();
		
		
	}
	
	
	
	
	
	// recursive_formula_step2
	// 特殊な2項間漸化式 1
	/*整数 x, d_1, d_2, k が与えられます。次のように定められた数列の k 項目の値を出力してください。

	・ a_1 = x 
	・ a_n = a_{n-1} + d_1 (n が奇数のとき、n ≧ 3) 
	・ a_n = a_{n-1} + d_2 (n が偶数のとき)*/
	public static void main0(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt(); int d1 = sc.nextInt(); int d2 = sc.nextInt(); int k = sc.nextInt();

		int[] dp = new int[k+1];
		
		dp[0] = 0; dp[1] = x;
		for(int i = 2; i <= k; i++) {
			int d = i % 2 == 0 ? d2 : d1;
			dp[i] = dp[i-1] + d;
		}
		
		System.out.println(dp[k]);

		sc.close();
		
		
	}
	
	
	
	/* recursive_formula_step3
	 * 特殊な2項間漸化式 2
	 * */
	public static void main01(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt(); int d1 = sc.nextInt(); int d2 = sc.nextInt(); 
		int Q = sc.nextInt();
		
		for(int j = 0; j < Q; j++) {
			int k = sc.nextInt();

			int[] dp = new int[k+1];
			
			dp[0] = 0; dp[1] = x;
			for(int i = 2; i <= k; i++) {
				int d = i % 2 == 0 ? d2 : d1;
				dp[i] = dp[i-1] + d;
			}
			
			System.out.println(dp[k]);
		}
		
		sc.close();
	}
	
	
	
	
	// finaboshi
	/*フィボナッチ数列と呼ばれる有名な数列です。

	・ a_1 = 1 
	・ a_2 = 1 
	・ a_n = a_{n-2} + a_{n-1} (n ≧ 3)*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Q = sc.nextInt();	
		
		for(int j = 0; j < Q; j++) {
			int k = sc.nextInt();
			
			int[] dp = new int[k+1];
			
			dp[0] = 0; dp[1] = 1; 
			if (k > 1) dp[2] = 1;
			for(int i = 3; i <= k; i++) {
				dp[i] = dp[i-2] + dp[i-1];
			}
			
			System.out.println(dp[k]);
		}
		
		
		sc.close();
	}

}
