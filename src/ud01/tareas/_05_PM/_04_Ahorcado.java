package ud01.tareas._05_PM;

import java.io.Console;
import java.util.Scanner;

import common.Utils;

public class _04_Ahorcado {

	// Función que imprime la solución actual
	public static void imprimirSolucion(char[] solucion) {
		for (char c : solucion)
			System.out.print(c + " ");
		System.out.println("\n");
	}

	// Función que comprueba si se puede usar Console
	public static boolean sePuedeUsarConsole() {
		return System.console() != null;
	}

	// Función que crea la palabra secreta
	public static String crearSecreto(Scanner sc) {
		String secreto;
		if (sePuedeUsarConsole()) {
			Console console = System.console();
			char[] secretoChars = console.readPassword("Jugador 1, introduce la palabra secreta: ");
			secreto = new String(secretoChars);
		} else {
			System.out.print("Jugador 1, introduce la palabra secreta (se mostrará): ");
			secreto = sc.nextLine();
		}
		return secreto;
	}

	// Función para leer una letra válida (solo A-Z o a-z)
	public static char leerLetraMinuscula(Scanner sc) {
		String entrada = sc.nextLine().trim();
		while (entrada.length() != 1 || !estaEnRangoAZ(entrada.charAt(0))) {
			System.out.print("Entrada inválida. Introduce solo una letra (A-Z o a-z): ");
			entrada = sc.nextLine().trim();
		}
		return Character.toLowerCase(entrada.charAt(0));
	}

	// Función auxiliar para comprobar si un carácter está entre A-Z o a-z
	public static boolean estaEnRangoAZ(char c) {
		int ascii = (int) c;
		return (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122);
	}

	// Función que crea la solución inicial (guiones bajos) según la palabra secreta
	public static char[] crearSolucion(String secreto) {
		char[] solucion = new char[secreto.length()];
		for (int i = 0; i < solucion.length; i++) {
			solucion[i] = '_';
		}
		return solucion;
	}

	// Función del juego
	public static void jugar(Scanner sc) {
		String secreto = crearSecreto(sc);
		String secretoMinuculas = secreto.toLowerCase();

		char[] solucion = crearSolucion(secreto); // usamos la nueva función

		int aciertos = 0;
		int longitud = secreto.length();
		int intentos = 0;

		System.out.println("\nJuego del ahorcado.");
		imprimirSolucion(solucion);

		do {
			System.out.print("Dime una letra: ");
			char letra = leerLetraMinuscula(sc);
			intentos++;

			boolean aciertoEnEstaRonda = false;
			for (int i = 0; i < longitud; i++) {
				if (secretoMinuculas.charAt(i) == letra && solucion[i] == '_') {
					solucion[i] = secreto.charAt(i);
					aciertos++;
					aciertoEnEstaRonda = true;
				}
			}

			imprimirSolucion(solucion);

			if (!aciertoEnEstaRonda) {
				System.out.println("Esa letra no está en la palabra.");
			}

		} while (aciertos < longitud);

		System.out.println("¡Felicidades! Has adivinado la palabra: " + secreto);
		System.out.println("Número de intentos: " + intentos + "\n");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("=== MENÚ AHORCADO ===");
			System.out.println("1 - Jugar");
			System.out.println("2 - Salir");
			System.out.print("Elige una opción: ");

			opcion = Utils.leerEntero(sc);
			switch (opcion) {
			case 1:
				jugar(sc);
				break;
			case 2:
				System.out.println("¡Hasta luego!");
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}

		} while (opcion != 2);

		sc.close();
	}
}
