package ud01.tareas._05_PM;

import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);
		String entrada;
		int num, cont, limite;

		System.out.println("=== GENERADOR DE TABLAS DE MULTIPLICAR ===");

		// Pregunta inicial fuera del bucle
		System.out.print("\nEscribe un número para generar su tabla (o 'fin' para salir): ");
		entrada = scanner.nextLine().trim().toLowerCase();

		while (!entrada.equals("fin")) {

			if (!esNumero(entrada)) {
				System.out.println("Entrada no válida. Por favor, escribe un número o 'fin'.");
			} else {
				num = Integer.parseInt(entrada);

				// Pregunta cuántos multiplicandos
				System.out.print("¿Hasta qué número quieres multiplicar? ");
				String entradaLimite = scanner.nextLine().trim();

				// Comprueba que un número > 1
				if (!esNumero(entradaLimite) || Integer.parseInt(entradaLimite) < 1) {
					System.out.println("Entrada no válida. Por favor, escribe un número mayor que 0.");
					continue;
				} else {
					limite = Integer.parseInt(entradaLimite);

					System.out.printf("%nTabla de multiplicar del %d hasta %d:%n", num, limite);
					cont = 1;

					while (cont <= limite) {
						System.out.printf("%d * %d = %d%n", num, cont, num * cont);
						cont++;
					}
				}
			}

			// Nueva pregunta dentro del bucle
			System.out.print("\nEscribe otro número (o 'fin' para salir): ");
			entrada = scanner.nextLine().trim().toLowerCase();
		}

		System.out.println("\n¡Gracias por usar el programa!");
		scanner.close();
	}
}
