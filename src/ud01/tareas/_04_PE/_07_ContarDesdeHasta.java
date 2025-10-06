package ud01.tareas._04_PE;

import java.util.Scanner;

public class _07_ContarDesdeHasta {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el número inicial: ");
		int inicio = sc.nextInt();

		System.out.print("Introduce el número final: ");
		int fin = sc.nextInt();

		for (int numero = inicio; numero <= fin; numero++) {
			System.out.printf("%4d ", numero);
			if (numero % 50 == 0)
				System.out.println();
		}
	}
}
