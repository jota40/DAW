package common;

import java.util.Scanner;

public class Utils {
	// Función para leer un número validado
	public static int leerNumero(Scanner sc) {
		int numero;

		while (!sc.hasNextInt()) {
			System.out.println("Eso no es un número. Repite por favor: ");
			sc.nextLine(); // descartamos entrada incorrecta
		}

		numero = sc.nextInt();
		sc.nextLine();
		return numero;
	}
	
	 // Lee una palabra, solo si está esta dentro de un array
    public static String leerPalabraValida(Scanner sc, String[] palabrasValidas) {
        return palabrasValidas[leerPoscionPalabraValida(sc, palabrasValidas)];
    }
    
	 // Lee laposicion de una palabra, solo si está esta dentro de un array
    public static int leerPoscionPalabraValida(Scanner sc, String[] palabrasValidas) {
    	int posicion;
        String palabra = sc.nextLine().trim().toLowerCase();
        while ((posicion = posicionPalabra(palabrasValidas, palabra)) == -1) {
            System.out.print("No entiendo tu respuesta. Repite por favor: ");
            palabra = sc.nextLine().trim().toLowerCase();
        }
        return posicion;
    }

    // Devuelve la posición de una palabra dentro de un array, o -1 si no la encuentra
    private static int posicionPalabra(String[] palabrasValidas, String palabra) {
        for (int i = 0; i < palabrasValidas.length; i++) {
            if (palabrasValidas[i].equals(palabra)) {
                return i;
            }
        }
        return -1; // No encontrada
    }

}