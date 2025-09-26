package ud01.ejercicios.juegos.ppt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PPT_func {
	public static void main(String[] args) {
		List<String> jugadas = new ArrayList<>(List.of("piedra", "papel", "tijera"));
		List<String> siNo = new ArrayList<>(List.of("si", "no"));

		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String jugadaJugadorStr, jugadaPcStr;
		int jugadaJugador, jugadaPc;
		boolean empate;
		String revancha;

		do {
			do {
				jugadaJugadorStr = jugadaJugador(sc, jugadas);
				jugadaJugador = jugadas.indexOf(jugadaJugadorStr);

				jugadaPc = jugadaPC(random);
				jugadaPcStr = jugadas.get(jugadaPc);
				
				mostrarJugadas(jugadaJugadorStr, jugadaPcStr);
//				mostrarJugadas(jugadaJugador, jugadaPC);

				empate = calcularResultado(jugadas, jugadaJugadorStr, jugadaPcStr);
//				empate = calcularResultado(jugadaJugador, jugadaPc);

			} while (empate);
			revancha = sc.nextLine().toLowerCase();
			while (!siNo.contains(revancha)) {
				System.out.print("No entiendo tu respuesta. Repite por favor: ");
				revancha = sc.nextLine().toLowerCase();
			} 
		} while (revancha.equals("si"));
		System.out.println("\nHasta la próxima partida");
	}

	private static boolean calcularResultado(List<String> jugadas, String jugadaJugadorStr, String jugadaPcStr) {
		boolean empate = false;
		if (jugadaJugadorStr.equals(jugadaPcStr)) {
			System.out.println("\nLa partida no puede quedar en un EMPATE");
			empate = true;
		} else if (jugadaJugadorStr.equals(jugadas.get(0)) && jugadaPcStr.equals(jugadas.get(1))
				|| jugadaJugadorStr.equals(jugadas.get(1)) && jugadaPcStr.equals(jugadas.get(2))
				|| jugadaJugadorStr.equals(jugadas.get(2)) && jugadaPcStr.equals(jugadas.get(0))) {
			System.out.println("Has perdido");
			System.out.print("\n¿Quieres que te de la revancha? ");
		} else {
			System.out.println("Has ganado");
			System.out.print("\n¿Me das la revancha? ");
		}
		return empate;
	}

	private static boolean calcularResultado(int jugadaJugador, int jugadaPc) {
		boolean empate = false;
		if (jugadaJugador == jugadaPc) {
			System.out.println("\nLa partida no puede quedar en un EMPATE");
			empate = true;
		} else if (jugadaJugador % 3 == (jugadaPc - 1) % 3) {
			System.out.println("Has perdido");
			System.out.print("\n¿Quieres que te de la revancha? ");
		} else {
			System.out.println("Has ganado");
			System.out.print("\n¿Me das la revancha? ");
		}
		return empate;
	}

	private static void mostrarJugadas(int jugadaJugador, int jugadaPc) {
		System.out.printf("Jugador = %d vs PC = %d\n", jugadaJugador, jugadaPc);
	}

	private static void mostrarJugadas(String jugadaJugador, String jugadaPc) {
		System.out.printf("Jugador = %s vs PC = %s\n", jugadaJugador, jugadaPc);
	}

	public static String jugadaJugador(Scanner sc, List<String> jugadas) {
		String jugadaJugadorStr;
		do {
			System.out.print("¿Piedra, Papel o Tijera? ");
			jugadaJugadorStr = sc.nextLine().toLowerCase();
		} while (!jugadas.contains(jugadaJugadorStr));
		return jugadaJugadorStr;
	}

	public static int jugadaPC(Random random) {
		return random.nextInt(3);
	}

}
