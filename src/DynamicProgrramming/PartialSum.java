package DynamicProgrramming;

import java.util.Arrays;
import java.util.Scanner;

public class PartialSum {

	
	/*
	 * 部分和問題 1
	 * 
	 * 1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。
おもりを何個か選んで重さの和が x となるようにすることができるかどうか判定してください。なお、同じおもりを2個以上選ぶことはできません。

(ヒント)
おもり 1 ~ n を用いて重さの和を x となるようにすることができるか、という問題を考えるために、部分問題としておもり 1 ~ n-1 を用いて重さの和を x となるようにすることができるか、という問題を考えてみましょう。

n-1 までのおもりを用いて重さの和を x または x-a_n となるようにすることができれば、おもり 1 ~ n を用いて重さの和を x となるようにすることができることがわかります。よって、最初はおもり 1 のみを使えることにして問題を解き、次にその結果を利用しておもり 1 ~ 2 を使えることにして問題を解く、ということを n まで繰り返せば、元の問題が解けそうです。

dp_k[x] を、おもり k までを用いて重さの和が x となるようにすることができるかどうかを表す真偽値とすると、上で考察した関係は漸化式で表すと dp_k[x] = (dp_{k-1}[x] or dp_{k-1}[x-a_k]) となります。

dp_1, dp_2, ... と順に dp_n まで計算すれば問題の答えが求まります。dp_1 から dp_n のそれぞれに対応する n 本の1次元配列 (もしくはこれに相当する2次元配列) を使って実装してもよいのですが、dp_k[x] を求めるには dp_{k-1}[x] と dp_{k-1}[x-a_k] さえわかっていれば十分であることを踏まえると、ループの回し方を以下の様に工夫することで、これまでと同じように1本の1次元配列で解くことができます。

for i = 0 to x
    dp[i] <- false

dp[0] <- true   // おもりを選ばなければ、重さの和を0とすることができる

for i = 1 to n  // おもり i までのおもりを使って
    for j = x down to a_i    // 重さの和を j とすることができるか？
        if dp[j-a_i] is true then
            dp[j] <- true   

if dp[x] is true then
    print "yes"
else
    print "no"
	 * 
	 * PASSED*/
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int x = sc.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		sc.close();
		
		boolean[] dp = new boolean[x+1];
		Arrays.fill(dp, false);
		dp[0] = true; // select 0 thing is OK
		
		for (int i = 0; i < n; i++) {
			for (int j = x; j >= a[i]; j--) {
				if (dp[j - a[i]])  dp[j] = true;
			}
		}
		
		System.out.println(dp[x] ? "yes" : "no");
	}
	
	
	
	
	
	
	
	// Subset Sum Problem		PASSED
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int x = sc.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		sc.close();
		
//		boolean result = isSubsetSum(a, n, x);
//        System.out.println(result ? "yes" : "no");
		
		// 部分和問題 2
		// System.out.println(countSubsetSum(a, n, x));
		
		// 部分和問題 3
		//System.out.println(minSubsetSum(a, n, x));
		
		// 部分和問題 4
		System.out.println(bossSubsetSum(a, n, x));
	}
	
	
	static boolean isSubsetSum(int[] arr, int n, int x) {
        // Tạo một bảng 2 chiều để lưu kết quả của các dãy con
        boolean[][] dp = new boolean[n + 1][x + 1];

        // Trường hợp cơ bản: Mọi dãy con có thể có tổng bằng 0 (nếu không chọn phần tử nào)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Lặp qua từng phần tử trong mảng và cập nhật bảng dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                // Nếu phần tử hiện tại lớn hơn tổng cần đạt được (j), không bao gồm nó
            	// Nếu phần tử hiện tại của arr (đánh số từ 0 đến n-1) lớn hơn tổng j, 
            	// điều này có nghĩa là không thể bao gồm phần tử này để có được tổng bằng j. 
            	// Do đó, dp[i][j] giữ giá trị của dp[i-1][j] (không bao gồm phần tử hiện tại).
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
	/*Nếu phần tử hiện tại có thể được sử dụng để có được tổng j, chúng ta có hai trường hợp:
	dp[i - 1][j]: Tổng j đã có thể được tạo ra bằng cách không sử dụng phần tử hiện tại.
	dp[i - 1][j - arr[i - 1]]: Tổng j - arr[i - 1] đã có thể được tạo ra từ các phần tử trước đó, 
	và chúng ta có thể thêm phần tử hiện tại để có được tổng j.
	Do đó, dp[i][j] được cập nhật thành true nếu một trong hai trường hợp trên là true.*/
                    // Nếu có thể có hoặc không bao gồm phần tử hiện tại
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // Kết quả nằm ở góc phải dưới của bảng dp
        return dp[n][x];
    }
	
	
	static boolean isSubsetSum0(int[] a, int n, int x) {
		
		
		boolean[] dp = new boolean[x+1];
		dp[0] = true; // select 0 thing is OK
		
		for (int i = 0; i < n; i++) {
			for (int j = x; j >= a[i]; j--) {
				/*Nếu tổng j - a[i] có thể được tạo ra từ các phần tử trước đó, 
				 thì tổng j cũng có thể được tạo ra bằng cách thêm phần tử hiện tại vào.*/
				if (dp[j - a[i]])  dp[j] = true;
			}
		}
		
		return dp[x];
	}
	
	
	/*
5 19
7
18
5
4
8
	 */
	
	
	
	
	
	
	
	
	
	
	/*
	 * 部分和問題 2 
	 * 
	 * 1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。

おもりを何個か選んで重さの和が x となるようにする方法が何通りあるか求めてください。なお、同じおもりを2個以上選ぶことはできません。

重さが同じおもりが複数存在する場合、それらは区別して別のものとして扱うことにします。

答えは非常に大きくなる可能性があるので、答えを 1,000,000,007 で割った余りで出力してください。
	 * */
	static int countSubsetSum(int[] a, int n, int x) {
		
		int[] dp = new int[x + 1];
        //Arrays.fill(dp, 0);
        dp[0] = 1; // Có một cách để có tổng bằng 0 (chọn 0 phần tử)

        for (int i = 0; i < n; i++) {
        	// xem xét tất cả các tổng có thể được tạo ra từ các phần tử trước đó và 
        	// có thể thêm phần tử hiện tại a[i] vào
        	for (int j = x; j >= a[i]; j--) {
                dp[j] += dp[j - a[i]];
                dp[j] %= 1000000007;
            }
        }

        return dp[x];
	}
	/*
	入力例1
5 10
7
3
4
3
2

	出力例1
	3
	*/	
	
	
	
	
	
	
	
	
	
	/*
	 * 部分和問題 3
	 * 
	 * 1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。

おもりを何個か選んで重さの和が x となるようにする方法を考えたとき、選ぶおもりの個数の最小値を出力してください。
なお、同じおもりを2個以上選ぶことはできません。

なお、重さの和が x となるようにおもりを選ぶ方法が存在しない場合は-1と出力してください。
	 * */

	static int minSubsetSum(int[] a, int n, int x) {
		int[] dp = new int[x + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0; // Có 0 min cách để có tổng bằng 0 (chọn ?min phần tử)

        for (int w : a) {
        	// xem xét tất cả các tổng có thể được tạo ra từ các phần tử trước đó và 
        	// có thể thêm phần tử hiện tại a[i] vào
        	for (int j = x; j >= w; j--) {
        		if (dp[j - w] != n + 1)
        			dp[j] = Math.min(dp[j], dp[j - w] + 1);
            }
        }

        return (dp[x] == n + 1 ? -1 : dp[x]);
	}
	
	
	
	
	
	
	/*
	 * 【部分和】部分和問題 4
	 * 
	 * 1 ~ n の番号がついた n 種類のおもりがあり、おもり i の重さは a_i です。それぞれのおもりは無限個存在しており、
	 * 任意のおもりを任意の個数使うことができます。

	このとき、おもりを選んで重さの和を x となるようにすることができるかどうか判定してください。
	 * */
	static String bossSubsetSum(int[] a, int n, int x) {
		boolean[] dp = new boolean[x + 1];
		Arrays.fill(dp, false);
        dp[0] = true; // Có cách để có tổng bằng 0 (chọn 0 phần tử)

        for (int w : a) {
        	// xem xét tất cả các tổng có thể được tạo ra từ các phần tử trước đó và 
        	// có thể thêm phần tử hiện tại a[i] vào
        	for (int j = w; j <= x; j++) {
        		if (dp[j - w])	dp[j] = true;
            }
        }

        return (dp[x] ? "yes" : "no");
	}
	/*
	 * 
	 * 方針
おもり k までを用いて重さの和が x となるようにおもりを選ぶことができるかどうかがわかっていれば、おもり k+1 までを用いて
重さの和が x となるようにおもりを選ぶことができるかどうかがわかりますから、おもり 1 から始めて順におもり n まで計算していけばよいです。
dp_k[x] を、おもり k までを用いて重さの和が x となるようにおもりを選ぶことができるかどうかを表す真偽値とすると、
dp_{k-1}[0] ~ dp_{k-1}[x], dp_k[0] ~ dp_k[y (< x)] と dp_k[x] の関係は 
dp_k[x] = dp_{k-1}[x] or dp_{k-1}[x-a_k] or dp_k[x-a_k] となります。
dp_1 から dp_k に対応する k 本の1次元配列 (もしくはこれに相当する2次元配列) を用意し、上の漸化式に従って
問題を解いても良いのですが、部分和問題 1 で考察したようにループの回し方を工夫すると1本の1次元配列でこの問題を解くことができます。

 入力例1
5 10
9
3
4
11
8

出力例1
yes
 */	
}


