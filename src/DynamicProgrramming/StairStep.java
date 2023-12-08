package DynamicProgrramming;

import java.util.Scanner;

public class StairStep {

	/* 階段の上り方 1
	 * 整数 n が与えられます。
	階段を上るのに、1 歩で 1 段または 2 段を上ることができるとき、n 段の階段を上る方法は何通りあるでしょうか。
	
	(ヒント)
	これまでは問題文中に具体的な漸化式が書かれていましたが、この問題にはありません。自分で漸化式を立てる必要があります。
	
	部分問題として、1 ~ n-1 段の階段を上る方法が何通りあるか、という問題を考えてみましょう。この部分問題の答えが求まっているとして、n 段の階段を上る方法が何通りあるかを考えてみましょう。n 段目に到達するには、n-1 段目から1段上る方法と、n-2 段目から2段上る方法の2種類が考えられます。dp[n] を n 段の階段を上る方法の数とすれば、この関係は dp[n] = dp[n-1] + dp[n-2] で表すことが出来ます。よって、0段の階段を上る方法が1通り (何もしない) であることを踏まえると、以下のようにして答えを求めることが出来ます。
	
	dp[0] <- 1
	
	for i = 1 to n
	    dp[i] <- 0
	    if i >= 1 then
	        dp[i] <- dp[i] + dp[i-1]    // i-1 段目から1段上って i 段へ到達
	    if i >= 2 then
	        dp[i] <- dp[i] + dp[i-2]    // i-2 段目から2段上って i 段へ到達
	
	print dp[n]
	*/
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 0;
			if (i >= 1) dp[i] += dp[i - 1];
			if (i >= 2) dp[i] += dp[i - 2];
		}
		
		System.out.println(dp[n]);
		
		sc.close();

	}
	
	
	
	
	/*整数 n, a, b が与えられます。
	階段を上るのに、1歩で a 段または b 段を上ることができるとき、n 段の階段を上る方法は何通りあるでしょうか。
	
	(ヒント)
	前問とやることは同じです。ただ、n, a, b の値によっては答えが0になることがあるので注意しましょう。
	例えば、n = 4, a = 3, b = 5 のとき、答えは0です。
	(1歩で3段か5段上ることができるとき、ちょうど4段の階段を上る方法は存在しない)*/
	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 0;
			if (i >= a) dp[i] += dp[i - a];
			if (i >= b) dp[i] += dp[i - b];
		}
		
		System.out.println(dp[n]);
		
		sc.close();

	}
	
	
	
	/*整数 n, a, b, c が与えられます。
	階段を上るのに、1歩で a 段または b 段または c 段を上ることができるとき、
	n 段の階段を上る方法は何通りあるでしょうか。*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 0;
			if (i >= a) dp[i] += dp[i - a];
			if (i >= b) dp[i] += dp[i - b];
			if (i >= c) dp[i] += dp[i - c];
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}

}
