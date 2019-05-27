package tenis;

public class Jugador {
	
	private int juegosGanados;
	private int setsGanados;
	
	public Jugador(){
		this.juegosGanados = 0;
		this.setsGanados = 0;
	}
	
	public void incrementaJuegosGanados(){
		this.juegosGanados++;
	}
	
	public void incrementarSetsGanados(){
		this.setsGanados++;
	}
	
	public void resetearJuegos(){
		this.juegosGanados = 0;
	}
	
	public int obtenerJuegosGanados(){
		return this.juegosGanados;
	}
	
	public int obtenerSetsGanados(){
		return this.setsGanados;
	}
	
}
