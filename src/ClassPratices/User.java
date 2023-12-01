package ClassPratices;

public class User {
	String nickname;
    Integer old;
    String birth;
    String state;
    
    public User (String nickname,Integer old, String birth, String  state){
        this.nickname = nickname;
        this.old = old;
        this.birth = birth;
        this.state = state;
    }
    
    public void printAll() {
        System.out.println("User{");
        System.out.println("nickname : " + this.nickname);
        System.out.println("old : " + this.old);
        System.out.println("birth : " + this.birth);
        System.out.println("state : " + this.state);
        System.out.println("}");
    }
    
    public String toString(){
    	return this.nickname + " " + this.old + " " + this.birth + " " + this.state;
    }
}
