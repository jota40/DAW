package ud01.ejercicios.juegos;

import java.io.Console;
import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) {
        Console console = System.console();
        Scanner sc = new Scanner(System.in);

        String secreto;

        if (console != null) {
            // Pedir palabra secreta sin mostrarla
            char[] secretoChars = console.readPassword("Jugador 1, introduce la palabra secreta: ");
            secreto = new String(secretoChars);
        } else {
            // Fallback con Scanner si no hay console
            System.out.print("Jugador 1, introduce la palabra secreta (se mostrará): ");
            secreto = sc.nextLine();
        }

        char[] solucion = new char[secreto.length()];
        for (int i = 0; i < solucion.length; i++) {
            solucion[i] = '_';
        }

        int aciertos = 0;
        int longitud = secreto.length();

        System.out.println("\nJuego del ahorcado.");
        System.out.println("La palabra a adivinar tiene " + longitud + " letras");
        for (char c : solucion) System.out.print(c + " ");
        System.out.println("\n");

        do {
            System.out.print("Dime una letra: ");
            char letra = sc.next().charAt(0);

            boolean aciertoEnEstaRonda = false;
            for (int i = 0; i < longitud; i++) {
                if (letra == secreto.charAt(i) && solucion[i] != secreto.charAt(i)) {
                    solucion[i] = secreto.charAt(i);
                    aciertos++;
                    aciertoEnEstaRonda = true;
                }
            }

            for (char c : solucion) System.out.print(c + " ");
            System.out.println("\n");

            if (!aciertoEnEstaRonda) {
                System.out.println("Esa letra no está en la palabra.");
            }

        } while (aciertos < longitud);

        System.out.println("¡Felicidades! Has adivinado la palabra: " + secreto);
        sc.close();
    }
}
