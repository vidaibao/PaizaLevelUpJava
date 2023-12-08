package CumulativeSum;

import java.util.Scanner;

public class DonutBRank {
	// B138:ドーナツ
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int H = sc.nextInt(); int W = sc.nextInt();

		String[] D = new String[H];
		
		for (int i = 0; i < H; i++) {
			D[i] = sc.next();
		}
		sc.close();
		
		int donutCount = 0;
		for (int i = 0; i < H; i++) { // row
			for (int j = 0; j < W; j++) { // col
				if (D[i].charAt(j) == '.') {
					if (i == 0 || i == H - 1 || j == 0 || j == W - 1) {
						continue; // ignore . at margin
					}
					if (   D[i-1].substring(j-1, j+2).equals("###") 
						&& D[i+1].substring(j-1, j+2).equals("###")
						&& D[i].charAt(j-1) == '#' && D[i].charAt(j+1) == '#') {
						donutCount++;
					}
					
				}
			}
		}
		System.out.println(donutCount);
		
	}

}
/*
6 4
####
#..#
#..#
####
#.##
####
1
*/