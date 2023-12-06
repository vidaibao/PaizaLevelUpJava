package Query;

public class BankCustomer {
	String name;
	String pass;
	int balance;
	
	public BankCustomer(String name, String pass, int balance) {
		super();
		this.name = name;
		this.pass = pass;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void withdraw(int w) {
		balance -= w;
	}
	
	public String printNameBalance() {
		return this.name + " " + this.balance;
	}
}
