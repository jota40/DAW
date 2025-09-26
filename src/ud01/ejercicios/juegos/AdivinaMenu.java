package ud01.ejercicios.juegos;

import java.util.Random;
import java.util.Scanner;

public class AdivinaMenu {

	public static void partida() {
		Random rand = new Random();
		int secreto = rand.nextInt(100) + 1; // números aleatorios entre 1 y 100
		Scanner sc = new Scanner(System.in);
		int num;

		do {
			System.out.print("\nIntroduce un número (entre 1 y 100): ");
			num = sc.nextInt();

			if (secreto > num)
				System.out.println("Es mayor");
			else if (secreto < num)
				System.out.println("Es menor");
		} while (secreto != num);

		System.out.println("\n¡Has acertado!");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc;
		Random rand = new Random();

		do {
			System.out.println("\nAdivinar número");
			System.out.println("1 - Comenzar");
			System.out.println("2 - Salir");
			System.out.print("\nIntroduce una opción: ");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				partida();
				break;
			case 2:
				System.out.println("\nFIN");
				break;
			default:
				System.out.println("\nOpción incorrecta");
				break;
			}

		} while (opc != 2);

		sc.close();
	}
}
