package ud02.ejercicios.juegos.ppt.poo;

import common.Utils;

public class Jugador {
	private String[] jugadas;
	private int jugada;

	public Jugador(String[] jugadas) {
		this.jugadas = jugadas;
	}

	public void juega() {
		System.out.print("¿Piedra, Papel o Tijera? ");
		jugada = Utils.leerPoscionPalabraValida(Arbitro.sc, jugadas);
	}

	public int getJugada() {
		return jugada;
	}

	public String getJugadaStr() {
		return jugadas[jugada];
	}
}