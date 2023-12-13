package PaizaRankB;

import java.util.Scanner;

public class ChocolateDiv {

	/*
	 * B068:チョコの分割
	 * 
	 * アリスとボブは 2 人兄妹です。今日、2 人はお母さんからお菓子としてチョコを貰いました。

	アリス達がもらったチョコは H 行 W 列の正方形状のかけらに分割されています。
	それぞれのかけらには「糖度」という整数の値が決められています。 i 行 j 列目 (1 ≦ i ≦ H, 1 ≦ j ≦ W) のかけらの糖度は a_{i, j} です。
	
	アリスとボブは、チョコレートを平等に分け合いたいと考えています。そのときに、次の 2 つのルールに従ってチョコを分けるようにします。
	
	1. それぞれの行ごとに、アリスとボブが得る糖度の和が等しくなるようにチョコを分けます。
	2. それぞれの行ごとに、左端から連続したかけらをアリスがもらうようにします。残りはボブがもらうようにします。
	
	上の 2 つの条件を満たすようにチョコを分割できるかを判定してください。
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt(); int W = sc.nextInt();
		//int[][] sugars = new int[H][W];
		int[][] S = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			S[i][0] = sc.nextInt();
			for (int j = 1; j < W; j++) {
				S[i][j] = S[i][j-1] + sc.nextInt();
			}
		}
		sc.close();

		boolean yesNo = false;
		String[] result = new String[H];

		for (int i = 0; i < H; i++) {
			yesNo = false;
			for (int j = 0; j < W-1; j++) {
				if (S[i][j] == S[i][W-1] - S[i][j]) {
					yesNo = true;
					char[] charArray = new char[W];
					for (int k = 0; k < W; k++) {
						charArray[k] = (k <= j) ? 'A' : 'B';
					}
					//System.out.println(new String(charArray));
					result[i] = new String(charArray);
					continue;
				}
			}
		}
		
		if (yesNo) {
			System.out.println("Yes");
			for (int i = 0; i < H; i++) {
				System.out.println(result[i]);
			}
		} else {
			System.out.println("No");
		}
	}

}
