package game.world;

public class Coin {
	public static final int TYPE_1 = 0;//Bronce
	public static final int TYPE_2 = 1;//Plata
	public static final int TYPE_3 = 2;//Oro
	
	public int x,y,type;
	
	public Coin(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
