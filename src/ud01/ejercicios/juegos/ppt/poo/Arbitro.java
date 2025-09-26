package ud01.ejercicios.juegos.ppt.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arbitro {
	public static Scanner sc = new Scanner(System.in);

	private List<String> jugadas = new ArrayList<>(List.of("piedra", "papel", "tijera"));
	private List<String> siNo = new ArrayList<>(List.of("si", "no"));
	private Jugador jugador;
	private Pc pc;

	public Arbitro() {
		jugador = new Jugador(jugadas);
		pc = new Pc(jugadas);
	}

	public void empezar() {
		String otraPartida;
		System.out.println(
				"Hola soy un árbitro profesional de Piedra, Papel, Tijera\ny estas a punto de enfrentarte con este PC\n");
		do {
			do {
				jugador.juega();
				pc.juega();
				mostrarJugadas();
			} while (calcularResultado());
			System.out.print("\n¿Quieres que arbitre otra partida? ");
			otraPartida = sc.nextLine().toLowerCase();
			while (!siNo.contains(otraPartida)) {
				System.out.print("No entiendo tu respuesta. Repite por favor: ");
				otraPartida = sc.nextLine().toLowerCase();
			}
			System.out.println();
		} while (otraPartida.equals("si"));
		System.out.println("Hasta la próxima partida");

	}

	private boolean calcularResultado_v2() {
		String jugadaJugador = jugador.getJugadaStr();
		String jugadaPc = pc.getJugadaStr();

		boolean empate = false;
		if (jugadaJugador.equals(jugadaPc)) {
			System.out.println("\nLa partida no puede quedar en un EMPATE");
			empate = true;
		} else if (jugadaJugador.equals(jugadas.get(0)) && jugadaPc.equals(jugadas.get(1))
				|| jugadaJugador.equals(jugadas.get(1)) && jugadaPc.equals(jugadas.get(2))
				|| jugadaJugador.equals(jugadas.get(2)) && jugadaPc.equals(jugadas.get(0))) {
			System.out.println("Has perdido");
			System.out.print("\n¿Quieres que te de la revancha? ");
		} else {
			System.out.println("Has ganado");
			System.out.print("\n¿Me das la revancha? ");
		}
		return empate;
	}

	private boolean calcularResultado() {
		int jugadaJugador = jugador.getJugada();
		int jugadaPc = pc.getJugada();
		if (jugadaJugador == jugadaPc) {
			System.out.println("\nLa partida no puede quedar en un EMPATE");
			return true;
		} else if (jugadaJugador % 3 == (jugadaPc - 1) % 3) {
			System.out.println("Has perdido");
		} else {
			System.out.println("Has ganado");
		}
		return false;
	}

	private void mostrarJugadas() {
		System.out.printf("Jugador = %s vs PC = %s\n", jugador.getJugadaStr(), pc.getJugadaStr());
	}
}