package ClassPratices;

public class Hero {
	int level;
	int health;
	int attack;
	int defence;
	int speed;
	int clever;
	int fortune;
	
	public Hero(int level, int health, int attack, int defence, int speed, int clever, int fortune) {
		super();
		this.level = level;
		this.health = health;
		this.attack = attack;
		this.defence = defence;
		this.speed = speed;
		this.clever = clever;
		this.fortune = fortune;
	}
	
	void levelUp(int health, int attack, int defence, int speed, int clever, int fortune) {
		this.level++;
		this.health += health;
		this.attack += attack;
		this.defence += defence;
		this.speed += speed;
		this.clever += clever;
		this.fortune += fortune;
	}
	
	void muscle_training(int health, int attack) {
		this.health += health;
		this.attack += attack;
	}
	
	void running(int defence, int speed) {
		this.defence += defence;
		this.speed += speed;
	}
	
	void study(int clever) {
		this.clever += clever;
	}
	
	void pray(int fortune) {
		this.fortune += fortune;
	}

	@Override
	public String toString() {
		return level + " " + health + " " + attack + " " + defence
				+ " " + speed + " " + clever + " " + fortune;
	}
	
}
