package BRankLevelUpNew;

import java.util.Scanner;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		repeatedSideJump();
	}

	private static void repeatedSideJump() {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong(); long X = sc.nextLong(); long K = sc.nextLong();
		sc.close();
		
		//
		if (K % 4 == 3) {
			System.out.println(2*X*((K-4*N)/4)+X);
		} else {
			System.out.println(2*X*((K-4*N)/4));
		}
		
		
	}

}
