package ud01.ejercicios.juegos.ppt.poo;

import java.util.List;
import java.util.Random;

public class Pc {
	private List<String> jugadas;
	Random random;
	private int jugada;

	public Pc(List<String> jugadas) {
		this.jugadas = jugadas;
		random = new Random();
	}

	public void juega() {
		jugada = 1;//random.nextInt(3);
	}

	public int getJugada() {
		return jugada;
	}

	public String getJugadaStr() {
		return jugadas.get(jugada);
	}
}