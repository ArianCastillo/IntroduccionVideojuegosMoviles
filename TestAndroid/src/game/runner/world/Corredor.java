package game.runner.world;

public class Corredor {
	public static final int CORRER = 0;
	public static final int SALTO = 1;
	public static final int RODAR = 2;
	public static final int SLASH = 3;
	
	public int accion;
	
	public Corredor(){
		accion = CORRER;
	}
	
	public void Correr(){
		
	}
	
	public void Saltar(){
		accion = SALTO;
	}
	
	public void Rodar(){
		accion = RODAR;
	}
	
	public void Slash(){
		accion = SLASH;
	}
}