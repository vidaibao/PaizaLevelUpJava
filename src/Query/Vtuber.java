package Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Vtuber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt();
		
		Map<String, Integer> sChats = new TreeMap<>(Collections.reverseOrder());
		List<String> members = new ArrayList<String>();
		// Retrieve data
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			String event = sc.next();
			Integer donated = 0;
			//System.out.println(name + " " +  event);
			if (event.equals("join")) {
				members.add(name); sc.next(); // membership!
			} else if (event.equals("give")) {
				if (sChats.containsKey(name)) {
					donated = sChats.get(name);
				}
				donated += sc.nextInt(); 
				sChats.put(name, donated);
				sc.next(); // !
			}
		}
		sc.close();
		
		// Sorting descending by value donate then descending z -> a by key name
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(sChats.entrySet());
		entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
				//.thenComparing(Map.Entry.<String, Integer>comparingByKey()));
				.thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed()));
		// Sorting members ascending a - z
		Collections.sort(members);
		
		// print result
		entryList.forEach(x -> System.out.println(x.getKey()));
		members.forEach(x -> System.out.println(x));
	}

}

