package Query;

import java.util.Arrays;
import java.util.Scanner;

public class SquareRootDecomposition {

	// PASSED
	public static void main000(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = 10000;
		int blockSize = (int) Math.sqrt(N);
		int numBlocks = (int) Math.ceil((double) N / blockSize);
		int[][] blocks = new int[numBlocks][blockSize];
		
		for (int i = 0; i < N; i++) {
			int bIndex = i / blockSize;
			int innerIndex = i % blockSize;
			blocks[bIndex][innerIndex] = sc.nextInt();
		}
		
		sc.close();
		
		// result
		for (int i = 0; i < numBlocks; i++) {
			System.out.println(findMax(blocks[i]));
		}
		
	}
	
	
	
	// Calculate in range
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt(); // number of range
		int N = 10000;
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int h = 0; h < H; h++) {
			int leftIndex = sc.nextInt() - 1; // array based 0
			int rightIndex = sc.nextInt(); // copy until rightIndex - 1
			int[] slicedArray = Arrays.copyOfRange(A, leftIndex, rightIndex);
			System.out.println(calculateSRDMax(slicedArray));
		}

		sc.close();
	}
	
	
	
	static int calculateSRDMax(int[] arr) {
		int max = arr[0];
		int blockSize = (int) Math.sqrt(arr.length);
		int numBlocks = (int) Math.ceil((double) arr.length / blockSize);
		int[][] blocks = new int[numBlocks][blockSize];
		
		for (int i = 0; i < arr.length; i++) {
			int bIndex = i / blockSize;
			int innerIndex = i % blockSize;
			blocks[bIndex][innerIndex] = arr[i];
		}
		
		for (int i = 0; i < numBlocks; i++) {
			max = Math.max(max, findMax(blocks[i])) ;
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

}


/*
 * Square Root Decomposition 
 *
 * Chia dãy số thành các khối có kích thước xấp xỉ căn bậc hai của tổng số phần tử.
Tính tổng của từng khối và lưu trữ lại.
Thực hiện các truy vấn bằng cách tính tổng của các phần tử trong các khối.
Cập nhật giá trị một cách hiệu quả.


 * 平方分割のバケット
 *
 * paiza くんは、長さ N の数列のある区間に含まれる要素の最大値を K 回求めたいのですが、
 * 与えられる区間の要素をいちいち全て調べていては時間計算量にして最大で O(NK) かかってしまいます。
そこで、paiza くんは 平方分割 と言われるアルゴリズムを用いることで、この計算量を減らそうと考えました。
平方分割とは、次のようなアルゴリズムです。

1. 長さ N の配列が与えられたとき、N の平方根 x を求め、配列を長さ x の配列に分割し、それぞれの配列について目的の値を調べておく。
（分割で得られる最後の配列の長さは必ずしも x になるとは限りません）
2. 調べたい区間に完全に含まれている配列についての 1. で求めた値と、その配列以外の部分の値を全て調べて、目的の値を求める。



この問題では、長さ 10,000 の数列 A について手順 1. を行ってみましょう。
10,000 の平方根は 100 なので、先頭から 100 要素ずつの最大値を求めましょう。
 */