package game.world;

public class Enemy {
	public static final int TYPE_1 = 0;//FLY
	public static final int TYPE_2 = 1;//Slime
	
	public int x,y,type;
	
	public Enemy(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public void advanced(){
		
	}
}