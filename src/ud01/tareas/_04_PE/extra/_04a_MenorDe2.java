package ud01.tareas._04_PE.extra;

import java.util.Scanner;

public class _04a_MenorDe2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b;

		System.out.println("Necesito 2 números distintos para calcular cuál es el mayor y cuál es el menor.");

		do {
			System.out.print("\nIntroduce el 1er número: ");
			a = scanner.nextInt();

			System.out.print("Introduce el 2º número: ");
			b = scanner.nextInt();

			if (a == b) {
				System.out.println("Los números son iguales");
			}
		} while (a == b);

		if (a < b) {
			System.out.println("El 1º número es el menor");
		} else {
			System.out.println("El 2º número es el menor");
		}

		scanner.close();
	}
}
