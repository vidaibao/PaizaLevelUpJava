package ClassPratices;

public class MazeLocation {
	String name;
	int[] routes;
	public MazeLocation(String name, int r1, int r2) {
		super();
		this.name = name;
		this.routes = new int[] {r1, r2};
	}
	
}
