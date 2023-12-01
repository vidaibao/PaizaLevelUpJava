package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pratice01 {

	public static void main00(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int N = Integer.parseInt(line);
        String[] temp;
        List<User> users = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            temp = sc.nextLine().split(" ");
            users.add( new User(temp[0], Integer.parseInt(temp[1]), temp[2], temp[3]) );
        }
        
        for (User u : users) {
            u.printAll();
        }
        
        sc.close();
	}

}
