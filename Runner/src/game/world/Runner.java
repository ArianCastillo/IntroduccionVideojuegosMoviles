package game.world;

public class Runner {
	public static final int ACTION_1 = 0;//Correr
	public static final int ACTION_2 = 1;//Saltar
	public static final int ACTION_3 = 2;//Slash
	
	public int x,y,action;
	
	
	public Runner(int x, int y){
		action = ACTION_1;
		this.x = x;
		this.y = y;
	}
	
	public void Run(){
		action = ACTION_1;
		
	}
	
	public void Jump(){
		action = ACTION_2;
		
	}
	
	public void Slash(){
		action = ACTION_3;
		
	}
}
