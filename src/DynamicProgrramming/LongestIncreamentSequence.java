package DynamicProgrramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreamentSequence {

	// 最長増加連続部分列
	// FAILED Time Over n 120k
	//Longest increasing subsequence without contiguous
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int i, j = 0;
		//dp[0] = 1; // Length of sequence of 1 element at position 0 is 1
		for (i = 1; i < n; i++) { // 2 -> n  => i:  1 -> n-1
			for (j = 0; j < i; j++) {// j: 0 -> i-1
				if (A[j] < A[i] && dp[i] < dp[j] + 1) 
					dp[i] = dp[j] + 1;
			}
		}
		
		if (dp.length < 5000) {
			System.out.println(Arrays.stream(dp).max().getAsInt());
		} else {
			System.out.println(findMaxSRD(dp));
		}
		
	}
	
	private static int findMaxSRD(int[] arr) {
		int N = arr.length;
		int blockSize = (int) Math.sqrt(N);
		int numBlocks = (int) Math.ceil((double) N / blockSize);
		int[][] blocks = new int[numBlocks][blockSize];
		
		for (int i = 0; i < N; i++) {
			int bIndex = i / blockSize;
			int innerIndex = i % blockSize;
			blocks[bIndex][innerIndex] = arr[i];
		}
		int max = 0;
		for (int i = 0; i < numBlocks; i++) {
			max = Math.max(max, findMax(blocks[i]));
		}
		return max;
	}
	
	static int findMax(int[] arr){
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) max = arr[i];
		}
		return max;
	}
	
	
	// PASS but 5 	160	178	170	190	191  result = 3 ??? contiguous ok
	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = new int[n+1];
		for (int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n+1];
		
		dp[1] = 1; // Length of sequence of 1 element at position 0 is 1
		for (int i = 2; i <= n; i++) { // 2 -> n 
			if (A[i-1] <= A[i]) { // contiguous subsequence
				dp[i] = dp[i-1] + 1;
			} else {
				dp[i] = 1;
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}

	
	/*
	 * 最長部分増加列
	 * 
	 * n 本の木が横一列に並んでいます。左から i 番目の木を木 i と呼ぶことにします。木 i の高さは a_i [cm] です。
	あなたは、何本かの木を伐採することによって、残った木を左から順に見ると高さが単調増加になっているようにしたいと考えています。つまり、残った木を左から 木 k_1, 木 k_2, ... , 木 k_m とすると、a_{k_1} < a_{k_2} < ... < a_{k_m} が満たされているようにしたいです。なるべく多くの木が残るように、伐採する木を工夫して選んだとき、伐採されずに残る木の本数が最大でいくつになるか求めてください。
	なお、最初から n 本の木が単調増加に並んでいる場合は、1本も伐採しなくてよいものとします。
	
	(ヒント)
	まずは問題を整理しましょう。この問題は、添字の部分列 x1 < x2 < ... < xk であって、a_x1 < a_x2 < ... < a_xk を満たしているようなもの (これを、一般に増加部分列と呼びます) のうち、k が最も大きいもの (これを、一般に最長増加部分列 (Longest Increasing Subsequence, LIS) と呼びます) を求めよという問題に言い換えることができます。
	
	dp[k] を、最後が木 k であるような増加部分列のうち最長であるものの長さとしてみましょう。dp[1] ~ dp[k-1] が求まっているとして、dp[k] とこれらの関係はどのようになっているかを考えてみましょう。
	
	少し考えると、1以上 k 未満の i について a_i < a_k が成り立っているとき、最後が木 i であるような増加部分列の最後に木 k をくっつけることで、新しく長さ dp[i] + 1 の増加部分列を作れることがわかります。そして、最後が木 k であるような最長増加部分列は、このようにして作られる部分列のうち最長のものであることがわかります。
	
	これで、dp[1] ~ dp[k-1] と dp[k] の関係が明らかになりました。自信のある方は自分で漸化式を立ててみましょう。以下の疑似コードに従ってあなたの得意な言語で実装してみましょう。
	
	dp[1] <- 1
	
	for i = 2 to n
	    dp[i] <- 1  // 木 i のみからなる部分列の長さ
	    for j = 1 to i-1
	        if a[j] < a[i] then
	            dp[i] <- max(dp[i], dp[j]+1)    // 最後が木 j であるような増加部分列の末尾に木 i をくっつける
	
	print max({dp[1], ... ,dp[n]})
	 * 
	 * PASSED*/
	public static void main0(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = new int[n+1];
		for (int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n+1];
		
		dp[1] = 1; // Length of sequence of 1 element at position 0 is 1
		for (int i = 2; i <= n; i++) { // 2 -> n 
			dp[i] = 1;
			for (int j = 1; j <= i - 1; j++) {
				if (A[j] < A[i]) 
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
	
	
	
	/*
	 * 【部分列】最長減少部分列
	 * 
	 * n 本の木が横一列に並んでいます。左から i 番目の木を木 i と呼ぶことにします。
	 * 木 i の高さは a_i [cm] です。

	あなたは、何本かの木を伐採することによって、残った木を左から順に見ると高さが単調減少になっているようにしたいと考えています。
	つまり、残った木を左から 木 k_1, 木 k_2, ... , 木 k_m とすると、a_{k_1} > a_{k_2} > ... > a_{k_m} が満たされているようにしたいです。なるべく多くの木が残るように工夫して伐採する木を選んだとき、伐採されずに残る木の本数が最大でいくつになるか求めてください。
	
	なお、最初から n 本の木が単調減少に並んでいる場合は、1本も伐採しなくてよいものとします。
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = new int[n+1];
		for (int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n+1];
		
		dp[1] = 1; // Length of sequence of 1 element at position 0 is 1
		for (int i = 2; i <= n; i++) { // 2 -> n 
			dp[i] = 1;
			for (int j = 1; j <= i - 1; j++) {
				if (A[j] > A[i]) 
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
	
}
