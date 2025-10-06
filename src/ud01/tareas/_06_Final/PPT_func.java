package ud01.tareas._06_Final;

import java.util.Random;
import java.util.Scanner;

import common.Utils;

public class PPT_func {
	public static void main(String[] args) {
        String[] jugadas = {"piedra", "papel", "tijera"};
        String[] siNo = {"si", "no"};

		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String jugadaJugadorStr, jugadaPcStr;
		int jugadaJugador, jugadaPc;
		boolean empate;
		String revancha;

		do {
			do {
				System.out.print("¿Piedra, Papel o Tijera? ");
				jugadaJugador = Utils.leerPoscionPalabraValida(sc, jugadas);
				jugadaJugadorStr = jugadas[jugadaJugador];

				jugadaPc = jugadaPC(random);
				jugadaPcStr = jugadas[jugadaPc];
				
				mostrarJugadas(jugadaJugadorStr, jugadaPcStr);
				mostrarJugadas(jugadaJugador, jugadaPc);

				empate = mostrarResultado(jugadas, jugadaJugadorStr, jugadaPcStr);
//				empate = mostrarResultado(jugadaJugador, jugadaPc);

			} while (empate);
			revancha = Utils.leerPalabraValida(sc, siNo);
		} while (revancha.equals("si"));
		System.out.println("\nHasta la próxima partida");
	}

	private static boolean mostrarResultado(String[] jugadas, String jugadaJugadorStr, String jugadaPcStr) {
		boolean empate = false;
		if (jugadaJugadorStr.equals(jugadaPcStr)) {
			System.out.println("\nLa partida no puede quedar en un EMPATE");
			empate = true;
		} else if (jugadaJugadorStr.equals(jugadas[0]) && jugadaPcStr.equals(jugadas[1])
				|| jugadaJugadorStr.equals(jugadas[1]) && jugadaPcStr.equals(jugadas[2])
				|| jugadaJugadorStr.equals(jugadas[2]) && jugadaPcStr.equals(jugadas[0])) {
			System.out.println("Has perdido");
			System.out.print("\n¿Quieres que te de la revancha? ");
		} else {
			System.out.println("Has ganado");
			System.out.print("\n¿Me das la revancha? ");
		}
		return empate;
	}

	private static boolean mostrarResultado(int jugadaJugador, int jugadaPc) {
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
	public static int jugadaPC(Random random) {
		return random.nextInt(3);
	}

}
