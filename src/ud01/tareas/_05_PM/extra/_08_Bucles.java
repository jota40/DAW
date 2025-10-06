package ud01.tareas._05_PM.extra;

import java.util.Scanner;

import common.Utils;

public class _08_Bucles {

	public static void printline(int asteriscos, int totalCaracteres) {
		int indice = 1;
		// espacios = total - asteriscos
		while (indice <= totalCaracteres - asteriscos) {
			System.out.print(" ");
			indice++;
		}
		// el resto son asteriscos
		while (indice <= totalCaracteres) {
			System.out.print("*");
			indice++;
		}
	}

	public static void t1(int totalLineas) {
		for (int asteriscos = 1; asteriscos <= totalLineas; asteriscos++) {
			printline(asteriscos, totalLineas);
			System.out.println();
		}
	}

	public static void t2(int totalLineas) {
		for (int asteriscos = 1; asteriscos <= totalLineas; asteriscos++) {
			printline(asteriscos, asteriscos);
			System.out.println();
		}
	}

	public static void t3(int totalLineas) {
		for (int asteriscos = totalLineas; asteriscos > 0; asteriscos--) {
			printline(asteriscos, totalLineas);
			System.out.println();
		}
	}

	public static void t4(int totalLineas) {
		for (int asteriscos = totalLineas; asteriscos > 0; asteriscos--) {
			printline(asteriscos, asteriscos);
			System.out.println();
		}
	}

	public static void p1(int totalLineas) {
		p1(totalLineas, 1);
	}

	public static void p1(int totalLineas, int impar) {
		for (int esteriscos = 1; esteriscos <= totalLineas; esteriscos++) {
			printline(esteriscos, totalLineas);
			printline(esteriscos - impar, esteriscos - impar);
			System.out.println();
		}
	}

	public static void p2(int totalLineas) {
		p2(totalLineas, 1);
	}

	public static void p2(int totalLineas, int impar) {

		for (int asteriscos = totalLineas; asteriscos > 0; asteriscos--) {
			printline(asteriscos, totalLineas);
			printline(asteriscos - impar, asteriscos - impar);
			System.out.println();
		}
	}

	public static void r1(int totalLineas) {
		r1(totalLineas, 1);
		
	}
	public static void r1(int totalLineas, int impar) {
		p1(totalLineas, impar);
		p2(totalLineas, impar);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		int size;

		do {
			System.out.println("\n===== MENÚ DE FIGURAS =====");
			System.out.println("1. Triángulo /|");
			System.out.println("2. Triángulo |\\");
			System.out.println("3. Triángulo \\|");
			System.out.println("4. Triángulo |/");
			System.out.println("5. Pirámide /\\");
			System.out.println("6. Pirámide invertida \\/");
			System.out.println("7. Rombo /\\\n         \\/");
			System.out.println("0. Salir");
			System.out.print("Elige una opción: ");
			
			opcion = Utils.leerEntero(sc);

			if (opcion != 0) {
				System.out.print("Introduce el número de lineas, en el rombo serán el doble: ");
				size = Utils.leerEntero(sc);
			} else {
				break;
			}

			switch (opcion) {
				case 1 -> t1(size);
				case 2 -> t2(size);
				case 3 -> t3(size);
				case 4 -> t4(size);
				case 5 -> p1(size);
				case 6 -> p2(size);
				case 7 -> r1(size);
			default -> System.out.println("Opción no válida.");
			}

			System.out.println("\n---------------------------");

		} while (opcion != 0);

		System.out.println("¡Hasta luego!");
		sc.close();
	}
}
