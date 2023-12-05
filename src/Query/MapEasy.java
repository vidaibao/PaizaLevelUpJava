package Query;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEasy {

	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();

		Map<Integer, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int key = sc.nextInt();
			String value = sc.next();
			map.put(key, value);
		}
		
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			System.out.println(map.get(num));
		}
		
		sc.close();
	}

	// map normal
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();

		Map<Integer, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			map.put(sc.nextInt(), sc.next());
		}
		
		for (int i = 0; i < K; i++) {
			String condition = sc.next();
			if (condition.equals("join")) {
				map.put(sc.nextInt(), sc.next());
			} else if (condition.equals("leave")) {
				map.remove(sc.nextInt());
			} else if (condition.equals("call")) {
				System.out.println(map.get(sc.nextInt()));
			}
		}
		
		sc.close();
	}
}
