package game.world;

public class Obstacle {
	public static final int TYPE_1 = 0;
	public static final int TYPE_2 = 1;
	
	public int x,y,type;
	
	public Obstacle(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
