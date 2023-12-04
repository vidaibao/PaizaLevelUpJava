package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeNoExit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<MazeLocation> locations = new ArrayList<MazeLocation>();
		
		int N = sc.nextInt(); int K = sc.nextInt(); int S = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			locations.add(new MazeLocation(sc.next(), sc.nextInt(), sc.nextInt()));
		}
		
		MazeLocation loc = locations.get(S - 1);
		String result = loc.name;
		for (int i = 1; i <= K; i++) {
			int choice = loc.routes[sc.nextInt() - 1];
			loc = locations.get(choice - 1);
			result += loc.name;
		}
		System.out.println(result);
		sc.close();
	}

}
