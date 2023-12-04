package ClassPratices;

import java.util.Scanner;

public class RPGGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); int K = sc.nextInt();
		Hero[] heros = new Hero[N];
		
		for (int i = 0; i < N; i++) {
			heros[i] = new Hero(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		// event
		for (int i = 0; i < K; i++) {
			int index = sc.nextInt() - 1;
			String event = sc.next();
			
			switch (event) {
			case "levelup":
				heros[index].levelUp(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				break;

			case "muscle_training":
				heros[index].muscle_training(sc.nextInt(), sc.nextInt());
				break;

			case "running":
				heros[index].running(sc.nextInt(), sc.nextInt());
				break;

			case "study":
				heros[index].study(sc.nextInt());
				break;

			case "pray":
				heros[index].pray(sc.nextInt());
				break;

			default:
				break;
				
			}
		}
		sc.close();
		
		for (int i = 0; i < heros.length; i++) {
			System.out.println(heros[i].toString());
		}
	}

}
