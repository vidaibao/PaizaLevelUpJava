package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortInClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int N = Integer.parseInt(line);
        String[] temp;
        List<User> users = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            temp = sc.nextLine().split(" ");
            users.add( new User(temp[0], Integer.parseInt(temp[1]), temp[2], temp[3]) );
        }
        
        users.sort((a, b) -> a.old - b.old );
        
        for (User u : users) {
            System.out.println(u.toString());
        }
        
        sc.close();
		

	}
	
	

}
