package PaizaRankB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MountainPeek {

	// B091:山頂を探せ
	
	/*あなたは友達の地理学者にプログラムの作成を頼まれました。曰く、地図の中から山頂を見つけて、高い順にその標高を出力してほしい、とのことです。
渡された地図は、格子状に区切られており、それぞれのマスに標高が書かれています。
その地理学者によると、どうやら山頂とは周りの上下左右のマスよりも標高の高いマスと定義できるようです。
それぞれのマスの標高が与えられるので、山頂を標高の高い順に標高を出力してください。

ただし、地図の外の標高は 0 とみなします。

以下は入力例 1 を図示したものです。*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		int N = sc.nextInt();
		int[][] a = new int[N+2][N+2];
		for (int i = 0; i <= N+1; i++) {
			for (int j = 0; j <= N+1; j++)
				a[i][j] = 0;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				a[i][j] = sc.nextInt();
		}
		sc.close();

		ArrayList<Integer> peeks = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				if (	a[i][j] > a[i][j-1] && a[i][j] > a[i][j+1] && 
						a[i][j] > a[i-1][j] && a[i][j] > a[i+1][j]) {
					peeks.add(a[i][j]);
				} 
		}
		
		peeks.sort( (x, y) -> y - x );
		peeks.forEach(x -> System.out.println(x));
	}

	
	
}

/*
 入力例1
3
90 10 10
10 30 20
10 10 20
出力例1
90
30
入力例2
4
50 20 50 20
20 50 20 50
40 20 40 20
30 30 30 30
出力例2
50
50
50
50
40
40
入力例3
5
30 1 1 1 25
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
25 1 1 1 30
出力例3
30
30
25
25
 */
