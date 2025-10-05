package ud01.tareas._05_PM;
import java.util.Random;
import java.util.Scanner;

public class _02_Adivina {

	public static void partida(Scanner sc, int secreto) {
		int num;

		do {
			System.out.print("\nIntroduce un número (entre 1 y 100): ");

			num = leerNumero(sc);

			if (secreto > num)
				System.out.println("Es mayor");
			else if (secreto < num)
				System.out.println("Es menor");
		} while (secreto != num);

		System.out.println("\n¡Has acertado!");
	}

	// Función para leer un número validado
	public static int leerNumero(Scanner sc) {
		int numero;

		while (!sc.hasNextInt()) {
			System.out.println("Entrada no válida. Introduce un número.");
			sc.next(); // descartamos entrada incorrecta
		}

		numero = sc.nextInt();
		return numero;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\nAdivinar número");
			System.out.println("1 - Comenzar");
			System.out.println("2 - Salir");
			System.out.print("\nIntroduce una opción: ");

			opcion = leerNumero(sc);

			switch (opcion) {
			case 1:
				partida(sc, rand.nextInt(100) + 1); // números aleatorios entre 1 y 100
				break;
			case 2:
				System.out.println("\nFIN");
				break;
			default:
				System.out.println("\nOpción incorrecta");
				break;
			}

		} while (opcion != 2);

		sc.close();
	}
}
