package ClassPratices;

public class Robot {
	static int[] moves = {0, 1, 2, 5, 10};
	int X; int Y;
	int level;
	
	public Robot(int x, int y, int level) {
		super();
		X = x;
		Y = y;
		this.level = level;
	}
	
	private void levelUp() {
		if (level <= 4) level++;
	}
	// no limit move
	void move(String direct, int[] tbX, int[] tbY, int H, int W) {
		switch (direct) {
		case "N":
			Y -= moves[level];
			break;
		case "S":
			Y += moves[level];
			break;
		case "E":
			X += moves[level];
			break;
		case "W":
			X -= moves[level];
			break;
		}
		
		for (int i = 0; i < 10; i++) {
			if (X == tbX[i] && Y == tbY[i]) {
				levelUp();
				break;
			}
		}
	}

	@Override
	public String toString() {
		return X + " " + Y + " " + level;
	}
	
	
}