package Query;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SinglePop {

	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			queue.add(sc.nextInt());
		}

		queue.poll();
		
		queue.forEach(x -> System.out.println(x));
		
		sc.close();
	}
	
	// multi pop
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		int N = sc.nextInt(); int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			queue.add(sc.nextInt());
		}

		for (int i = 0; i < K; i++) {
			String s = sc.next();
			if (s.equals("pop")) {
				queue.poll();
			} else if (s.equals("show")) {
				queue.forEach(x -> System.out.println(x));
			}
		}
		
		sc.close();
	}

}
