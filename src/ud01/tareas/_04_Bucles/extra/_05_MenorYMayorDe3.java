package ud01.tareas._04_Bucles.extra;

import java.util.Scanner;

public class _05_MenorYMayorDe3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a, b, c;

		System.out.println("Necesito 3 números distintos para calcular cuál es el mayor y cuál es el menor.");

		do {
			System.out.print("\nIntroduce el 1er número: ");
			a = scanner.nextInt();

			System.out.print("Introduce el 2º número: ");
			b = scanner.nextInt();

			if (a == b) {
				System.out.println("El 1er y 2º número son iguales");
			}
		} while (a == b);
		do {
			System.out.print("Introduce el 3er número: ");
			c = scanner.nextInt();

			if (a == c) {
				System.out.println("El 1er y 3er número son iguales");
			}
			if (b == c) {
				System.out.println("El 2º y 3er número son iguales");
			}
		} while (a == c || b == c);

		if (a > b && a > c) {
			System.out.println("El 1º número es el mayor");
			if (b < c) {
				System.out.println("El 2º número es el menor");
			} else {
				System.out.println("El 3er número es el menor");
			}
		} else if (b > a && b > c) {
			System.out.println("El 2º número es el mayor");
			if (a < c) {
				System.out.println("El 1er número es el menor");
			} else {
				System.out.println("El 3er número es el menor");
			}
		} else {
			System.out.println("El 3er número es el mayor");
			if (a < b) {
				System.out.println("El 1er número es el menor");
			} else {
				System.out.println("El 2º número es el menor");
			}
		}

		scanner.close();
	}
}
