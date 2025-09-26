package ud01.ejercicios.juegos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdivinaReverse {

	    public static void main(String[] args) {
			List<String> respuestas = new ArrayList<>(List.of("mayor", "menor", "si"));
			String respuesta;

	        Scanner sc = new Scanner(System.in);
	        int min, max, num = 0, oldNum = -1, fallo, intentos;
	        char tecla;

	        System.out.println("Piensa un número y pulsa Enter.");
	        sc.nextLine();

	        // Pedir límites
	        do {
	            System.out.print("Dime el límite inferior del número que has pensado: ");
	            min = sc.nextInt();
	            System.out.print("Dime el límite superior del número que has pensado: ");
	            max = sc.nextInt();
	            max++;

	            if (min > max) {
	                System.out.println("El límite superior debe ser mayor que el inferior. Prueba otra vez.");
	            }
	        } while (min > max);
			sc.nextLine(); // limpiar buffer

	        System.out.println("\nResponde:");
	        System.out.println("menor, si el número que has pensado es menor");
	        System.out.println("si, si he acertado el número");
	        System.out.println("mayor, si el número que has pensado es mayor\n");

	        intentos = 1;

	        do {
	            num = (min + max) / 2;
	            System.out.print("¿Es el " + num + "? ");
    			respuesta = sc.nextLine().toLowerCase();
				while (!respuestas.contains(respuesta)) {
					System.out.print("No entiendo tu respuesta. Repite por favor: ");
	    			respuesta = sc.nextLine().toLowerCase();
				}
				if (respuesta.equals(respuestas.get(2))) break;

				if (respuesta.equals(respuestas.get(0))) min = num;
	            else if (respuesta.equals(respuestas.get(1))) max = num;

                if (oldNum == num) {
                    System.out.println("No me engañes");
                } else {
                    intentos++;
                }

	            oldNum = num;
	        } while (true);

	        System.out.println("\nSolo he necesitado " + intentos + " intento(s) para acertar.");

	        sc.close();
	    }
	}
