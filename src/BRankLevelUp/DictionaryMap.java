package BRankLevelUp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void fortuneTelling() {
//		Scanner sc = new Scanner(System.in);
//		sc.close();
		
		// LinkedHashMap keep order when put data
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("Kyoko", "B");
		map.put("Rio", "O");
		map.put("Tsubame", "AB");
		map.put("KurodaSensei", "A");
		map.put("NekoSensei", "A");
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + " " + val);
		}
	}
	
	
	// STEP: 58 ユーザーの血液型のデータ処理
	public static void fortuneTelling01() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// LinkedHashMap keep order when put data
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String key = sc.next();
			String val = sc.next();
			map.put(key, val);
		}
		sc.close();
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + " " + val);
		}
	}
	
	
	
	// STEP: 59 1人の血液型
	public static void fortuneTelling02() {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int n = sc.nextInt();
		// HashMap NO keep order when put data
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String key = sc.next();
			String val = sc.next();
			map.put(key, val);
		}
		sc.close();
		
		System.out.println(name + " " + map.get(name));
		
	}

	
	// STEP: 60 1つの血液型を占う
	public static void fortuneTelling03() {
		Scanner sc = new Scanner(System.in);
		String type = sc.next();
		int m = sc.nextInt();
		// HashMap NO keep order when put data
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < m; i++) {
			String key = sc.next();
			String val = sc.next();
			map.put(key, val);
		}
		sc.close();
		
		System.out.println(map.get(type));
		
	}
	
	
	// STEP: 61 1人の占い結果
	public static void fortuneTelling04() {
		Scanner sc = new Scanner(System.in);
		String U = sc.next();
		int n = sc.nextInt();
		// HashMap NO keep order when put data
		Map<String, String> users = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String key = sc.next();
			String val = sc.next();
			users.put(key, val);
		}
		
		int m = sc.nextInt();
		Map<String, String> luckies = new HashMap<String, String>();
		for (int i = 0; i < m; i++) {
			String key = sc.next();
			String val = sc.next();
			luckies.put(key, val);
		}
		sc.close();
		
		String lucky = users.get(U);
		System.out.println(luckies.get(lucky));
		
	}
	
	
	// STEP: 62 占い結果
	public static void fortuneTelling09() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// LinkedHashMap keep order when put data
		Map<String, String> userBloodMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String key = sc.next();
			String val = sc.next();
			userBloodMap.put(key, val);
		}
		
		int m = sc.nextInt();
		Map<String, String> fortuneMap = new HashMap<String, String>();
		for (int i = 0; i < m; i++) {
			String key = sc.next();
			String val = sc.next();
			fortuneMap.put(key, val);
		}
		sc.close();
		
		for (Map.Entry<String, String> entry : userBloodMap.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + " " + fortuneMap.get(val));
		}
		
	}
	
	
	
	
	
}
