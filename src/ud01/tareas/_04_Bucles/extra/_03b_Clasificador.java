package ud01.tareas._04_Bucles.extra;

import java.util.Scanner;

public class _03b_Clasificador {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero;

		do {
			System.out.print("Introduce un número: ");
			numero = scanner.nextInt();

			if (numero <= 30) {
				System.out.println("Es menor o igual que 30");
			} else if (numero >= 50 && numero <= 75) {
				System.out.println("Está entre 50 y 75 ambos incluidos");
			} else if (numero >= 80) {
				System.out.println("Es mayor o igual que 80");
			}

		} while (numero != 0);

		scanner.close();
	}
}
