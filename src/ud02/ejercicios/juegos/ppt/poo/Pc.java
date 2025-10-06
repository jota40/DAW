package ud02.ejercicios.juegos.ppt.poo;

import java.util.Random;

public class Pc {
	private String[] jugadas;
	Random random;
	private int jugada;

	public Pc(String[] jugadas) {
		this.jugadas = jugadas;
		random = new Random();
	}

	public void juega() {
		jugada =  random.nextInt(3);
	}

	public int getJugada() {
		return jugada;
	}

	public String getJugadaStr() {
		return jugadas[jugada];
	}
}