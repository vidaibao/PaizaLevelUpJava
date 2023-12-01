package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassMemberUpdate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        List<Employee> employees = new ArrayList<Employee>();
        int N  = Integer.parseInt(line);
        
        for(int i = 1; i <= N; i++) {
        	String[] temp = sc.nextLine().split(" ");

        	int index = Integer.parseInt(temp[1]);
        	if (temp[0].equals("make")) {
        		employees.add(new Employee(index, temp[2]));
			} else if (temp[0].equals("getname")) {
				System.out.println(employees.get(index - 1).getName());
			} else if (temp[0].equals("getnum")) {
				System.out.println(employees.get(index - 1).getNumber());
			} else if (temp[0].equals("change_name")) {
				employees.get(index - 1).setName(temp[2]);
			} else if (temp[0].equals("change_num")) {
				employees.get(index - 1).setNumber(Integer.parseInt(temp[2]));
			}
        }
	}

}
