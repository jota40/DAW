package ud01.tareas._06_Final;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PPT {
	public static void main(String[] args) {
		List<String> jugadas = new ArrayList<>(List.of("piedra", "papel", "tijera"));
		List<String> siNo = new ArrayList<>(List.of("si", "no"));

		Scanner sc = new Scanner(System.in);
		String jugadaJugadorStr, jugadaPCStr;
		int jugadaJugador, jugadaPC;
		boolean empate;
		String revancha;

		do {
			do {
				do {
					System.out.print("¿Piedra, Papel o Tijera? ");
					jugadaJugadorStr = sc.nextLine().toLowerCase();
				} while (!jugadas.contains(jugadaJugadorStr));
				jugadaJugador = jugadas.indexOf(jugadaJugadorStr);

				Random random = new Random(System.currentTimeMillis());
				jugadaPC = random.nextInt(3);
				jugadaPCStr = jugadas.get(jugadaPC);

//				System.out.printf("Jugador = %d vs PC = %d\n", jugadaJugador, jugadaPC);
				System.out.printf("Jugador = %s vs PC = %s\n", jugadaJugadorStr, jugadaPCStr);
/*
				if (jugadaJugador == jugadaPC) {
					System.out.println("Empate");
				} else if (jugadaJugador % 3 == (jugadaPC - 1) % 3) {
					System.out.println("Has perdido");
				} else {
					System.out.println("Has ganado");
				}
*/
				empate = false;
				if (jugadaJugadorStr.equals(jugadaPCStr)) {
					System.out.println("\nLa partida no puede quedar en un EMPATE");
					empate = true;
				} else if (jugadaJugadorStr.equals(jugadas.get(0)) && jugadaPCStr.equals(jugadas.get(1))
						|| jugadaJugadorStr.equals(jugadas.get(1)) && jugadaPCStr.equals(jugadas.get(2))
						|| jugadaJugadorStr.equals(jugadas.get(2)) && jugadaPCStr.equals(jugadas.get(0))) {
					System.out.println("Has perdido");
					System.out.print("\n¿Quieres que te de la revancha? ");
				} else {
					System.out.println("Has ganado");
					System.out.print("\n¿Me das la revancha? ");
				}
			} while (empate);
			revancha = sc.nextLine().toLowerCase();
			while (!siNo.contains(revancha)) {
				System.out.print("No entiendo tu respuesta. Repite por favor: ");
				revancha = sc.nextLine().toLowerCase();
			} 
		} while (revancha.equals("si"));
		System.out.println("\nHasta la próxima partida");
	}
}
