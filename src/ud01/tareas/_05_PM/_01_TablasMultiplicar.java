package ud01.tareas._05_PM;

import java.util.Scanner;

import common.Utils;

public class _01_TablasMultiplicar {

	// Función que verifica si la cadena es un número entero
	public static boolean esNumero(String texto) {
		if (texto.isEmpty()) {
			return false;
		}
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (!Character.isDigit(c) && c != '-') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tablaStr;
		int tabla, cantidadMultiplicandos;

		System.out.println("=== GENERADOR DE TABLAS DE MULTIPLICAR ===");

		do {

			System.out.print("\nElige que tabla quieres que genere o 'fin' para terminar: ");
			tablaStr = sc.nextLine().trim().toLowerCase();
			while (!esNumero(tablaStr) && !tablaStr.equals("fin")) {
				System.out.print("Elige que tabla quieres que genere o 'fin' para terminar: ");
				tablaStr = sc.nextLine().trim().toLowerCase();
			}
			tabla = Integer.parseInt(tablaStr); 
					
			// Pregunta cuántos multiplicandos
			System.out.print("\n¿Hasta qué número quieres multiplicar? ");
			cantidadMultiplicandos = Utils.leerEntero(sc);
			while (cantidadMultiplicandos < 1) {
				System.out.print("¿Hasta qué número quieres multiplicar? ");
				cantidadMultiplicandos = Utils.leerEntero(sc);
			}

			System.out.printf("%nTabla de multiplicar del %d hasta %d:%n", tabla, cantidadMultiplicandos);
			for (int cont = 1 ; cont <= cantidadMultiplicandos ; cont++ ) {
				System.out.printf("%d * %d = %d%n", tabla, cont, tabla * cont);
			}

		} while (!tablaStr.equals("fin"));

		System.out.println("\n¡Gracias por usar el programa!");
		sc.close();
	}
}
