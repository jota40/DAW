package ud01.tareas._05_PM;

import java.util.Scanner;

public class _03_Unknown {

    // Función para leer un número validado (sin mensaje)
    public static int leerNumero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Entrada no válida. Introduce un número entero.");
            sc.nextLine(); // descartamos entrada incorrecta
        }
        return sc.nextInt();
    }

    // Función para leer una respuesta válida del usuario (sin mensaje)
    public static String leerRespuestaValida(Scanner sc, String[] respuestas) {
        String respuesta = sc.nextLine().trim().toLowerCase();
        while (!esRespuestaValida(respuestas, respuesta)) {
            System.out.print("No entiendo tu respuesta. Repite por favor: ");
            respuesta = sc.nextLine().trim().toLowerCase();
        }
        return respuesta;
    }

    // Función que comprueba si la respuesta está en el array
    public static boolean esRespuestaValida(String[] respuestas, String respuesta) {
        for (String r : respuestas) {
            if (r.equals(respuesta)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] respuestas = {"mayor", "menor", "si"};

        Scanner sc = new Scanner(System.in);
        int min, max, num = 0, oldNum = -1, intentos;

        System.out.println("Piensa un número y pulsa Enter.");
        sc.nextLine();

        // Pedir límites validando que sean números
        do {
            System.out.print("Dime el límite inferior del número que has pensado: ");
            min = leerNumero(sc);

            System.out.print("Dime el límite superior del número que has pensado: ");
            max = leerNumero(sc);
            max++; // para incluir el límite superior

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

            // Usamos la función para leer una respuesta válida
            String respuesta = leerRespuestaValida(sc, respuestas);

            if (respuesta.equals("si")) break;

            if (respuesta.equals("mayor")) min = num+1;
            else if (respuesta.equals("menor")) max = num-1;

            if (oldNum == num) {
                System.out.println("No me engañes");
            } else {
                intentos++;
            }
            oldNum = num;
        } while (min != max);

        System.out.println("\nAcerté\nSolo he necesitado " + intentos + " intento(s) para acertar.");

        sc.close();
    }
}
