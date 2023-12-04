package ClassPratices;

public class Player {
	int health;
	Techno[] techno = new Techno[4];
	
	public Player(int health, int f1, int a1, int f2, int a2, int f3, int a3) {
		super();
		this.health = health;
		this.techno[1] = new Techno(f1, a1);
		this.techno[2] = new Techno(f2, a2);
		this.techno[3] = new Techno(f3, a3);
	}
	
	// 強化系の技を使った場合、使ったプレイヤーの他の全ての技の発生フレーム（最短 1 フレーム) を -3 , 攻撃力を +5 する。
	// 相手が攻撃技を使っていた場合、その攻撃の攻撃力分 hp が減少する
	void enhance() {
		for (int i = 1; i < 4; i++) {
			if(this.techno[i].frame == 0 && this.techno[i].attack == 0) {
				continue;
			}
			this.techno[i].frame = Math.max(this.techno[i].frame - 3, 1);
			this.techno[i].attack += 5;
		}
	}

	boolean isEnable() {
		return health > 0;
	}
	
	void takeDamage(int dam) {
		this.health -= dam;
	}
}
