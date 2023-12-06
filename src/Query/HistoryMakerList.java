package Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HistoryMakerList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();

		List<Historian> historian = new ArrayList<Historian>();
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
		}
		
		for (int i = 0; i < K; i++) {
			historian.add(new Historian(sc.nextInt(), sc.next()));
		}
		sc.close();
		Collections.sort(historian);
		
		historian.forEach(x -> System.out.println(x.getName()));
	}

}
