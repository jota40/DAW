package ud01.ejemplos;
import java.util.Scanner;

public class _3_VariablesLocales {
    static String nombre = "Variable de clase";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Ámbito");
            System.out.println("2. Constante");
            System.out.println("3. Inicializar");
            System.out.println("4. Enmascaramiento");
            System.out.println("Otra opcion. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ambito();
                    break;
                case 2:
                    constante();
                    break;
                case 3:
                    inicializar();
                    break;
                case 4:
                    enmascaramiento();
                    break;
                default:
                    salir = true;
            }
        }
        sc.close();
        System.out.println("Programa finalizado.");
    }

    // Opción 1: Ámbito
    static void ambito() {
        int x = 10;
        System.out.println("\nDentro del método, x = " + x);
        if (x > 5) {
            int y = 20;
            System.out.println("Dentro del if, y = " + y);
        }
        // ❌ Error y no existe aquí
        // System.out.println(y);
    }

    // Opción 2: Constante
    static void constante() {
        final int LIMITE = 100;
        System.out.println("\nConstante declarada: LIMITE = " + LIMITE);
        // ❌ Error no puedo cambiar el valor de una constante
        // LIMITE = 200;
    }

    // Opción 3: Inicialización
    static void inicializar() {
        int numero;
        // ❌ Error numero está sin inicilizar
        // System.out.println("\nnumero = " + numero);
        numero = 50;
        System.out.println("\nnumero = " + numero);
    }

    // Opción 4: Enmascaramiento
    public static void enmascaramiento() {
        // imprime la de clase
        System.out.println(nombre);

        String nombre = "Variable local";
        // imprime la local
        System.out.println(nombre);
    }
}