package Query;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HistoryMaker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();

		TreeMap<Integer, String> map = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
		}
		
		for (int i = 0; i < K; i++) {
			map.put(sc.nextInt(), sc.next());
		}
		
		sc.close();

		// Creating a custom comparator
        Comparator<Map.Entry<Integer, String>> customComparator = Comparator
                .comparing(Map.Entry<Integer, String>::getKey)
                .thenComparing(Map.Entry::getValue);
		
     // Sorting the entries using the custom comparator
        List<Map.Entry<Integer, String>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort(customComparator);

        
		//System.out.println("Sorted TreeMap (Ascending Order):");
        for (Map.Entry<Integer, String> entry : sortedEntries) {
            //System.out.println(entry.getKey() + ": " + entry.getValue());
        	System.out.println(entry.getValue());
        }
//		sortedEntries.values().forEach(System.out::println);
	}

}
