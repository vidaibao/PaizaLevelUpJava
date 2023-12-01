package ClassPratices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        List<Employee> list = new ArrayList<Employee>();
        int N  = Integer.parseInt(line);
        
        for(int i = 1; i <= N; i++) {
        	String[] temp = sc.nextLine().split(" ");
        	
        	switch (temp[0]) {
			case "make":
				list.add(new Employee(Integer.parseInt(temp[1]), temp[2]));
				break;
			
			case "getname":
				System.out.println(list.get(Integer.parseInt(temp[1]) - 1).getName());
				break;
			
			case "getnum":
				System.out.println(list.get(Integer.parseInt(temp[1]) - 1).getNumber());
				break;
			
			}
        	/*
        	int index = Integer.parseInt(temp[1]);
        	if (temp[0].equals("make")) {
        		list.add(new Employee(index, temp[2]));
			} else if (temp[0].equals("getname")) {
				System.out.println(list.get(index - 1).getName());
			} else if (temp[0].equals("getnum")) {
				System.out.println(list.get(index - 1).getNumber());
			}*/
        	
        }
        //line = sc.nextLine();
        /*
        for (Employee e : list) {
        	System.out.println(e.toString());
        }
        */
        sc.close();
	}

}
/*
3
make 1 nana
getnum 1
getname 1

7
make 2742 mako
getnum 1
make 2782 taisei
getname 2
make 31 megumi
getname 1
getname 3
 * */

