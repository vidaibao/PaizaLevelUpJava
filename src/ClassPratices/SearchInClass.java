package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchInClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        int N = Integer.parseInt(line);
        String[] temp;
        List<Student> students = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            temp = sc.nextLine().split(" ");
            students.add( new Student(temp[0], Integer.parseInt(temp[1]), temp[2], temp[3]) );
        }
        
        int K = Integer.parseInt(sc.nextLine());
        
        for (Student st : students) {
            if (st.old == K) {
				System.out.println(st.name);
				break;
			}
        }
        //System.out.println(K);
        sc.close();
	}

}
