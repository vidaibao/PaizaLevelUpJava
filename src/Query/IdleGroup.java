package Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IdleGroup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();
		
		List<String> names = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			names.add(sc.next());
		}
		
		for (int i = 0; i < K; i++) {
			String cond = sc.next();
			if (cond.equals("join")) {
				names.add(sc.next());
			} else if (cond.equals("leave")) {
				names.remove(sc.next());
			} else if (cond.equals("handshake")) {
				Collections.sort(names);
				names.forEach(x -> System.out.println(x));
			}
		}

		sc.close();
	}

}
