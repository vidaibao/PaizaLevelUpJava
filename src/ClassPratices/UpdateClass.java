package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        
        List<Student> students = new ArrayList<>();
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        for(int i = 1; i <= N; i++) {
        	line = sc.nextLine().split(" ");
            students.add( new Student(line[0], Integer.parseInt(line[1]), line[2], line[3]) );
        }

        for(int i = 1; i <= K; i++) {
        	line = sc.nextLine().split(" ");
        	int index = Integer.parseInt(line[0]);
        	updateNameByIndex(students, index - 1, line[1]); 
        }
        
        for (Student st : students) {
        	System.out.println(st.toString());
        }
        
        sc.close();
	}
	
	
	// Method to update name by index
    public static void updateNameByIndex(List<Student> studentList, int index, String newName) {
        if (index >= 0 && index < studentList.size()) {
            studentList.get(index).name = newName;
        } else {
            System.out.println("Invalid index");
        }
    }
    

}
