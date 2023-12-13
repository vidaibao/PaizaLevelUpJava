package DynamicProgrramming;

import java.util.Arrays;
import java.util.Scanner;

public class LISContinuousDecrease {

	// 連続列】最長減少連続部分列
	/*n 人が横一列に並んでいます。左から i 番目の人を人 i と呼ぶことにします。人 i の身長は a_i [cm]です。

	人 l ,人 l+1, ... , 人 r からなる区間 [l, r] について、すべての l ≦ i < r に対して a_i ≧ a_{i+1} が
	成り立っているとき、区間 [l, r] は逆背の順であると呼ぶことにします。また、区間 [l, r] の長さを r-l+1 とします。
	
	逆背の順であるような区間のうち、最長であるものの長さを出力してください。*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (a[i-1] >= a[i]) {
				dp[i] = dp[i-1] + 1;
			} else {
				dp[i] = 1;
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}

}
