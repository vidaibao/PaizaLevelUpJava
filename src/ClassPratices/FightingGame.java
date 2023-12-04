package ClassPratices;

import java.util.Scanner;

public class FightingGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); int K = sc.nextInt();
		
		Player[] players = new Player[N + 1];
		
		for (int i = 1; i <= N; i++) {
			players[i] = new Player(sc.nextInt(), sc.nextInt(), sc.nextInt(),
					sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		// combat
		for (int i = 1; i <= K; i++) {
			int p1 = sc.nextInt(); int t1 = sc.nextInt();
			int p2 = sc.nextInt(); int t2 = sc.nextInt();
			
			if (!players[p1].isEnable() || !players[p2].isEnable()) continue;
			
			combat(players, p1, t1, p2, t2);
		}
		sc.close();
		
		int count = 0;
		for (int i = 1; i < players.length; i++) {
			if (players[i].isEnable()) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	static void combat(Player[] players, int p1, int t1, int p2, int t2) {
		Player pl1 = players[p1];
		Player pl2 = players[p2];
		Techno tec1 = pl1.techno[t1];
		Techno tec2 = pl2.techno[t2];
		
		boolean p1Enhance = tec1.frame == 0 && tec1.attack == 0;
		boolean p2Enhance = tec2.frame == 0 && tec2.attack == 0;
		
		if (p1Enhance && p2Enhance) {
			pl1.enhance();
			pl2.enhance();
		} else if (p1Enhance) {
			pl1.enhance();
			pl1.takeDamage(tec2.attack);
		} else if (p2Enhance) {
			pl2.enhance();
			pl2.takeDamage(tec1.attack);
		} else {
			if (tec1.frame > tec2.frame) {
				pl1.takeDamage(tec2.attack);
			} else if (tec1.frame < tec2.frame) {
				pl2.takeDamage(tec1.attack);
			}
		}
	}
	
}
