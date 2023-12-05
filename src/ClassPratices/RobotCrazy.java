package ClassPratices;

import java.util.Scanner;

public class RobotCrazy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(); int W = sc.nextInt(); 
		int N = sc.nextInt(); int K = sc.nextInt(); 
		int[] tbX = new int[10]; int[] tbY = new int[10];
		Robot[] robots = new Robot[N];
		// tool boxes coordinate
		for (int i = 0; i < 10; i++) {
			tbX[i] = sc.nextInt(); tbY[i] = sc.nextInt();
		}
		// robots
		for (int i = 0; i < N; i++) {
			robots[i] = new Robot(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		// moves
		for (int i = 0; i < K; i++) {
			int index = sc.nextInt() - 1;
			String direct = sc.next();
			robots[index].move(direct, tbX, tbY, H, W);
		}
		sc.close();
		
		// results
		for (int i = 0; i < robots.length; i++) {
			System.out.println(robots[i].toString());
		}
	}

}
