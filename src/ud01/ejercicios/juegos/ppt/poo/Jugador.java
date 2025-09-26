package ud01.ejercicios.juegos.ppt.poo;

import java.util.List;

public class Jugador {
	private List<String> jugadas;
	private int jugada;

	public Jugador(List<String> jugadas) {
		this.jugadas = jugadas;
	}

	public void juega() {
		String jugadaStr;
		do {
			System.out.print("¿Piedra, Papel o Tijera? ");
			jugadaStr = Arbitro.sc.nextLine().toLowerCase();
		} while (!jugadas.contains(jugadaStr));
		jugada = jugadas.indexOf(jugadaStr);
	}

	public int getJugada() {
		return jugada;
	}

	public String getJugadaStr() {
		return jugadas.get(jugada);
	}
}