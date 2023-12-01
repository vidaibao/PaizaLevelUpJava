package ClassPratices;

public class Student {
	String name;
    Integer old;
    String birth;
    String state;
    
    public Student (String name,Integer old, String birth, String  state){
        this.name = name;
        this.old = old;
        this.birth = birth;
        this.state = state;
    }
    
    public String toString(){
    	return this.name + " " + this.old + " " + this.birth + " " + this.state;
    }
}
