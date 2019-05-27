package tenis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Partido {
	
	private int cantidadJuegos;
	private int setsParaGanarPartido;
	private int juegosParaGanarSet;
	private int diferenciaMinima;
	private char[] resultados;
	private Jugador jugadorA;
	private Jugador jugadorB;
	
	public Partido(Scanner entrada) {
		this.cantidadJuegos = entrada.nextInt();
		this.setsParaGanarPartido = entrada.nextInt();
		this.juegosParaGanarSet = entrada.nextInt();
		this.diferenciaMinima = entrada.nextInt();
		this.resultados = new char[this.cantidadJuegos];
		entrada.nextLine();
		String linea = entrada.nextLine();
		for(int i=0; i<this.cantidadJuegos; i++){
			this.resultados[i] = linea.charAt(i);
		}
		this.jugadorA = new Jugador();
		this.jugadorB = new Jugador();
	}
	
	private boolean huboGanador(){
		if(this.jugadorA.obtenerJuegosGanados() >= this.juegosParaGanarSet &&
			this.jugadorA.obtenerJuegosGanados()-this.jugadorB.obtenerJuegosGanados() >= this.diferenciaMinima){
			return true;
		}
		if(this.jugadorB.obtenerJuegosGanados() >= this.juegosParaGanarSet &&
				this.jugadorB.obtenerJuegosGanados()-this.jugadorA.obtenerJuegosGanados() >= this.diferenciaMinima){
				return true;
		}
		return false;
	}
	
	private boolean ganoA(){
		return this.jugadorA.obtenerJuegosGanados() > this.jugadorB.obtenerJuegosGanados();
	}
	
	public void resolver(PrintWriter salida){
		boolean hayGanador = false;
		boolean ganoJugadorA = false;
		for(int i=0; i< this.cantidadJuegos; i++){
			if(hayGanador == false){
				if(this.resultados[i] == 'A')
					this.jugadorA.incrementaJuegosGanados();
				else
					this.jugadorB.incrementaJuegosGanados();
				if(this.huboGanador() == true){
					hayGanador = true;
					if(this.ganoA() == true)
						ganoJugadorA = true;
				}
			}
			if(hayGanador == true){
				if(ganoJugadorA == true)
					this.jugadorA.incrementarSetsGanados();
				else
					this.jugadorB.incrementarSetsGanados();
				ganoJugadorA = false;
				hayGanador = false;
				this.jugadorA.resetearJuegos();
				this.jugadorB.resetearJuegos();
			}
		}
		salida.println(this.jugadorA.obtenerSetsGanados() + " " + this.jugadorB.obtenerSetsGanados());
	}
	
	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(new FileReader("prehistorico5.in"));
		Partido compuTenis = new Partido(entrada);
		entrada.close();
		PrintWriter salida = new PrintWriter("resultado5.out");
		compuTenis.resolver(salida);
		salida.close();
	}
	
}
