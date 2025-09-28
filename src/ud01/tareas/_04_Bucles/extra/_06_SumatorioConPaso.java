package ud01.tareas._04_Bucles.extra;

import java.util.Scanner;

public class _06_SumatorioConPaso {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int suma = 0, inicio, paso, fin;

		System.out.print("Introduce el valor inicial: ");
		inicio = scanner.nextInt();

		System.out.print("Introduce el valor de incremento: ");
		paso = scanner.nextInt();

		System.out.print("Introduce el valor final: ");
		fin = scanner.nextInt();

		System.out.print(inicio);
		suma = inicio;
		for (int i = inicio + paso; i <= fin; i += paso) {
			suma += i;
			System.out.print(" + " + i);
		}

		System.out.println(" = " + suma);

		scanner.close();
	}
}
