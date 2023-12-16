package BRankLevelUp;

import java.util.*;


public class BRankLevelUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void sample(Scanner sc) {
		
		int[] arr = { 1, 3, 5, 6, 3, 2, 5, 23, 2 };
		Arrays.stream(arr).sum();
		
		int[] arr01 = new int[]{ 4, 0, 5, -1, 3, 10, 6, -8 };
		
		Arrays.stream(arr01).filter(x -> x >= 5).sum();
		
		String[] s = sc.nextLine().split(" ");
        int[] intArray = Arrays.stream(s)
                               .mapToInt(Integer::parseInt)
                               .toArray();
        System.out.println(Arrays.stream(intArray).sum());
        Arrays.sort(intArray);
        
        String[] ab = new String[9];
        int a = Integer.parseInt(ab[0]); int b = Integer.parseInt(ab[1]); String S = sc.nextLine();
        
        System.out.println(S.substring(a-1, b));
        
        
        String str = sc.nextLine();
        String head = str.substring(0, a-1);
        String body = str.substring(a-1, b).toUpperCase();
        String footer = str.substring(b);
        System.out.println(head + body + footer);
		
		
//		String s = "asgfdsfgad";
//		s.substring(0, 0);
//		s.toUpperCase();
//		
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == s.charAt(0)) {
//				
//			}
//		}
		
		
		
		int N = Integer.parseInt(sc.nextLine());
        String[] ss = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(ss)
                                .mapToInt(Integer::parseInt)
                                .toArray();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
		
		//s.split(" ")
	}
	
	
	
	static void sortAscending(Scanner sc) {// step 39
		int n = sc.nextInt();
		Map<String, Integer> data = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String s = sc.next(); int d = sc.nextInt();
			data.put(s, d);
		}
		sc.close();
		
		List<Map.Entry<String, Integer>> sortByNumList = 
				new ArrayList<Map.Entry<String,Integer>>(data.entrySet());
//		Collections.sort(sortByNumList, Comparator.comparing(Map.Entry::getValue)); // 
//		Collections.sort(sortByNumList, Comparator.comparing(entry -> entry.getValue())); // ()
		sortByNumList.sort((o1, o2) -> o1.getValue() - o2.getValue());
		
		sortByNumList.forEach(x -> System.out.println(x.getKey()));
	}
	
	
	static void sortAdd() {
		List<String> list = new ArrayList<String>(Arrays.asList("HND", "NRT", "KIX", "NGO", "NGO"));
		Set<String> set = new HashSet<String>();
		set.addAll(list);
		System.out.println(list.size() != set.size() ? "true" : "false");
	}
	
	
	static void sortAdd02() {
		List<String> myList = new ArrayList<String>(Arrays.asList("HND", "NRT", "KIX", "NGO", "NGO", "NGO", "NGO", "NGO"));
		
//		Map<String, Long> collectMap = myList.stream()
//				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Map<String, Integer> elementCountMap = new HashMap<String, Integer>();
		for (String element : myList) {
            elementCountMap.put(element, elementCountMap.getOrDefault(element, 0) + 1);
        }
		
		for(Map.Entry<String, Integer> entry : elementCountMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getValue());
			}
			
		}
	}
	
	
	static void sortAdd03() {
		List<Integer>myList = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 6, 3, 2, 5, 23, 2));
		
		myList.sort( (a, b) -> a - b );
		
		myList.forEach(x -> System.out.println(x));
		
	}
	
	
	/* 
        for (int i = 0; i < n; i++){
            sc.next();
            System.out.println(sc.next());
        }*/
	
	/*
	 * 1行目で整数 n が与えられ、2行目で n 個の整数が与えられます。
n 個の整数を昇順に出力してください。

	 * */
	static void sortAdd05(Scanner sc) { //45
		int n = Integer.parseInt(sc.nextLine());
		
		String[] s = sc.nextLine().split(" ");
		int[] nums = Arrays.stream(s)
		        .mapToInt(Integer::parseInt)
		        .toArray();
		Arrays.sort(nums);

		for (int i = 0; i < n; i++){
            System.out.println(nums[i]);
        }
		
		sc.close();
	}
	
	
	
	/*
	 * 1行目に行数を表す整数 n、続く n 行の各行で「文字」と「整数」の組が空白区切りで入力されます。
n 個の組について、「文字」の値が同じ組同士の数値を足しあわせてまとめ、まとめた数値の降順で、文字とまとめた数値の組を出力してください。
この際、まとめた数値は重複しません。
	 * 
	 * 
入力は以下のフォーマットで与えられます。

n
S_1 D_1
S_2 D_2
...
S_i D_i
...
S_n D_n

S_i は「文字」で、D_i は「整数」です。
	 * */
	static void sortAdd06(Scanner sc) { //46 文字と整数の組のソート2
		Map<String, Integer> collectMap = new HashMap<String, Integer>();
		int n = Integer.parseInt(sc.nextLine());
	
		for (int i = 0; i < n; i++) {
			String key = sc.next(); int value = sc.nextInt();
			collectMap.put(key, collectMap.getOrDefault(key, 0) + value);
			//value += collectMap.containsKey(key) ? collectMap.get(key) : 0;
			//collectMap.put(key, value);
		}
		sc.close();
		
		List<Map.Entry<String, Integer>> sortByNumList = 
				new ArrayList<Map.Entry<String,Integer>>(collectMap.entrySet());
		sortByNumList.sort( (o1, o2) -> o2.getValue() - o1.getValue() );//desc
		sortByNumList.forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
	}
	
	
	
	static void alphabetLargeSmall(Scanner sc) {// 48
		String line = sc.nextLine();
		sc.close();
		for (int i = line.charAt(0); i <= line.charAt(line.length()-1); i++) {
			System.out.println( (char) i );
		}
		
	}
	
	
	static void alphabetHeadTail() {// 49
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		
		String result = line.charAt(0) < line.charAt(line.length()-1) 
				? "true" : "false";
		System.out.println(result);
	}
	
	
	static void alphabetHeadTailV2() {// 50
		Scanner sc = new Scanner(System.in);
		String X = sc.nextLine(); String Y = sc.nextLine(); String C = sc.nextLine();
		sc.close();
		
		String result = X.charAt(0) <= C.charAt(0) && C.charAt(0) <= Y.charAt(0) 
				? "true" : "false";
		System.out.println(result);
	}
	
	
	static void TicTacToe51() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
	
	static void TicTacToe52() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < 5; i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			if (val == 5) {
				System.out.println(key);
				return;
			}
		}
		System.out.println("D");
	}
	
	
	static void TicTacToe52V2() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int count = 1;
		char c = s.charAt(0);
		for (int i = 1; i < 5; i++) {
			if (s.charAt(i) == c) count++;
		}
		if ( count == 5 && (c == 'X' ||  c == 'O') ) {
			System.out.println(c);
		} else {
			System.out.println("D");
		}
	}
	
	
	static void TicTacToe53() {
		Scanner sc = new Scanner(System.in);
		String[] s = new String[5];
		for (int j = 0; j < 5; j++) {
			s[j] = sc.nextLine();
		}
		sc.close();
		
		
		
		for (int col = 0; col < 5; col++) {
			int count = 1;
			char c = s[0].charAt(col);
			for (int row = 1; row < 5; row++) {
				if (s[row].charAt(col) == c) count++;
			}
			if ( count == 5 && (c == 'X' || c == 'O') ) {
				System.out.println(c);
				sc.close();
				return;
			} 
		}
		System.out.println("D");
		
	}
	
	
	static void TicTacToeV3() {
		Scanner sc = new Scanner(System.in);
		String s = "";
		for (int j = 0; j < 5; j++) {
			s = sc.nextLine();
			int count = 1;
			char c = s.charAt(0);
			for (int i = 1; i < 5; i++) {
				if (s.charAt(i) == c) count++;
			}
			if ( count == 5 && (c == 'X' ||  c == 'O') ) {
				System.out.println(c);
				sc.close();
				return;
			} 
		}
		
		sc.close();
		System.out.println("D");
	}
	
	
	
	static void TicTacToeV4Diagonal() {
		Scanner sc = new Scanner(System.in);
		String[] s = new String[5];
		for (int j = 0; j < 5; j++) {
			s[j] = sc.nextLine();
		}
		sc.close();
		
		// leftUpper diagonal
		int count = 1;
		char c = s[0].charAt(0);
		for (int i = 1; i < 5; i++) {
			if (s[i].charAt(i) == c) count++;
		}
		if ( count == 5 && (c == 'X' || c == 'O') ) {
			System.out.println(c);
			sc.close();
			return;
		}
		
		// leftBottom diagonal
		count = 1;
		c = s[4].charAt(0);
		for (int i = 1; i < 5; i++) {
			if (s[4-i].charAt(i) == c) count++;
		}
		if ( count == 5 && (c == 'X' || c == 'O') ) {
			System.out.println(c);
			sc.close();
			return;
		}
		
		
		System.out.println("D");
		
	}
	
	
	
	static void TicTacToeFinal() {
		Scanner sc = new Scanner(System.in);
		String[] s = new String[5];
		for (int j = 0; j < 5; j++) {
			s[j] = sc.nextLine();
		}
		sc.close();
		
		// leftUpper diagonal
		int count = 1;
		char c = s[0].charAt(0);
		for (int i = 1; i < 5; i++) {
			if (s[i].charAt(i) == c) count++;
		}
		if ( count == 5 && (c == 'X' || c == 'O') ) {
			System.out.println(c);
			sc.close();
			return;
		}
		
		// leftBottom diagonal
		count = 1;
		c = s[4].charAt(0);
		for (int i = 1; i < 5; i++) {
			if (s[4-i].charAt(i) == c) count++;
		}
		if ( count == 5 && (c == 'X' || c == 'O') ) {
			System.out.println(c);
			sc.close();
			return;
		}
		// col
		for (int col = 0; col < 5; col++) {
			count = 1;
			c = s[0].charAt(col);
			for (int row = 1; row < 5; row++) {
				if (s[row].charAt(col) == c) count++;
			}
			if ( count == 5 && (c == 'X' || c == 'O') ) {
				System.out.println(c);
				sc.close();
				return;
			} 
		}
		
		// row
		for (int row = 0; row < 5; row++) {
			count = 1;
			c = s[row].charAt(0);
			for (int col = 1; col < 5; col++) {
				if (s[row].charAt(col) == c) count++;
			}
			if ( count == 5 && (c == 'X' || c == 'O') ) {
				System.out.println(c);
				sc.close();
				return;
			} 
		}
		System.out.println("D");
		
	}
	
	

}
