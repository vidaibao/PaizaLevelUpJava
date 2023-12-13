package DynamicProgrramming;

import java.util.Arrays;
import java.util.Scanner;

public class CheapestApples {

	public static void main00000(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();
		
		int[] dp = new int[n+1];
		
		dp[0] = 0;  dp[1] = a;
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i-1] + a, dp[i-2] + b);
		}
		
		System.out.println(dp[n]);
		
		sc.close();

	}
	
	
	
	/*最安値を達成するには 2
	 * 
	 * 八百屋にて、りんご2個が a 円で、りんご5個が b 円で売られています。
	りんごの買い方を工夫したとき、n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
	なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
	
	(ヒント)
	前問の八百屋ではりんごが1個と2個で売られていましたが、本問の八百屋では2個と5個で売られています。
	この変更により、前問と同じようにして解こうとするとうまくいかなくなりました。理由を考えてみてください。
	
	前問と同じように dp[n] をちょうど n 個のりんごを買うのに必要な金額の最小値とすると、dp[3] の値が
	正しく計算されないことがわかります。これは、りんごは2個ずつか5個ずつでしか買うことが出来ないため、
	3個のりんごをちょうど買う方法が存在しないからです。
	では、どうしたら dp[3] のような、2と5の組合せでは作れないような個数について最安値を計算することが出来るでしょうか。
	
	問題文の最後の文に注目すると、買うりんごの数が3個以上になってもよいことがわかるので、ここで dp2[n] を 
	n 個以上のりんごを買うのに必要な金額の最小値としてみましょう。dp と dp2 の定義から、
	dp2[n] = min(dp[n], dp[n+1], ...) であることがわかります。dp2[n] が求めたい答えになっています。
	
	dp は dp[n] までではなく、余裕をもって dp[n+4] 程度まで計算しておく必要があることに注意しましょう 
	(実はこの問題においては dp[n+2] まで計算しておけば十分なのですが、ある程度多めに計算しておくと安心です) 。
	また、実は新しく dp2 という配列を用意せずとも、dp をうまく書き換えることで答えを求めることもできます。
	余裕があれば考えてみてください (ヒント:ループを回す順番を工夫) 。*/
	// PASSED 7/11
	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();
		
		int[] dp = new int[n+3];
		
		
		dp[0] = 0; //dp[1] = 0; dp[2] = a; dp[3] = 0;
		for (int i = 2; i <= n + 2; i++) {
			int aPrice = (i >= 2) ? dp[i-2] + a : Integer.MAX_VALUE;
			int bPrice = (i >= 5) ? dp[i-5] + b : Integer.MAX_VALUE;
			dp[i] = Math.min(aPrice, bPrice);
		}
		// 買ったりんごが n+1 個以上になってもよいものとします
		System.out.println(dp[n+2]);
		
		sc.close();

	}
	
	
	/*まず、dp[n] をちょうど n 個のりんごを買うのに必要な金額の最小値とすると、dp[0] ~ dp[k-1] と dp[k] の関係は 
 * dp[k] = min(dp[k-2] + a, dp[k-5] + b) となります。まずはこの漸化式に従って dp を小さい方から順に計算しましょう。
	このままでは、2と5の組合せで作れない個数について、答えを正しく計算することができません。そこで、この dp を利用してちょうど 
	n 個ではなく、n 個以上のりんごを買うのに必要な金額の最小値を求めることを考えます。
	dp2[n] を n 個以上のりんごを買うのに必要な金額の最小値とすると、定義から 
	dp2[n] = min(dp[n], dp[n+1], ...) であることがわかります。dp2[n] が問題の答えです。
	ループの回し方を工夫して配列 dp をうまく書き換えると、わざわざ dp2 のような配列を新しく作らなくても答えを求めることができます。
	具体的には、dp2[n] = min(dp[n], dp[n+1], ...) = min(dp[n], dp2[n+1]) であることに注目し、
	dp を添字が大きい方から dp[k] = min(dp[k], dp[k+1]) のように書き換えていけば、dp[n] が 
	n 個以上のりんごを買うのに必要な金額の最小値となります。
	このとき、dp[k]を書き換えた時点では、dp[i (< k) ] はちょうど i 個のりんごを買うのに必要な金額の最小値に、
	dp[i (≧ k) ] は i 個以上のりんごを買うのに必要な金額の最小値 (=dp2[i]) になっています。
	n 個のりんごを最も安く手に入れたいときに n+5 個以上のりんごを買うのは無駄ですから、dp は dp[n+4] 程度まで
	計算しておけば十分です。実は a < b であることから dp[n+2] まで計算しておけば十分であることがわかるのですが、そこまで切り詰める必要はありません。*/
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();
		
		int[] dp = new int[n+5];
		Arrays.fill(dp, 10000000);
		
		dp[0] = 0; //dp[1] = 0; dp[2] = a; dp[3] = 0;
		for (int i = 2; i < n + 5; i++) { // --> dp[n+4]
			if (i >= 2) dp[i] = Math.min(dp[i], dp[i-2] + a);
			if (i >= 5) dp[i] = Math.min(dp[i], dp[i-5] + b);
		}
		// 買ったりんごが n+1 個以上になってもよいものとします
		int[] dp2 = Arrays.copyOfRange(dp, n, dp.length);
		//for (int x : dp) System.out.println(x);
		//System.out.println();
		//for (int x : dp2) System.out.println(x);
		System.out.println(Arrays.stream(dp2).min().getAsInt());
		
		sc.close();

	}
	
	
	
	// 最安値を達成するには 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); 
		int x = sc.nextInt(); int a = sc.nextInt(); 
		int y = sc.nextInt(); int b = sc.nextInt();
		int z = sc.nextInt(); int c = sc.nextInt();
		
		int[] dp = new int[n+z];
		Arrays.fill(dp, 10000000);
		
		dp[0] = 0; 
		for (int i = x; i < n + z; i++) { // dp[n+z-1]
			if (i >= x) dp[i] = Math.min(dp[i], dp[i-x] + a);
			if (i >= y) dp[i] = Math.min(dp[i], dp[i-y] + b);
			if (i >= z) dp[i] = Math.min(dp[i], dp[i-z] + c);
		}
		// 買ったりんごが n+1 個以上になってもよいものとします
		int[] dp2 = Arrays.copyOfRange(dp, n, dp.length);

		System.out.println(Arrays.stream(dp2).min().getAsInt());
		
		sc.close();

	}

}
