package ud01.tareas._04_Bucles.extra;

import java.util.Scanner;

public class _04b_Sumar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero1, numero2, suma;

        System.out.print("Introduce el 1er sumando: ");
        numero1 = scanner.nextInt();

        System.out.print("Introduce el 2º sumando: ");
        numero2 = scanner.nextInt();

        suma = numero1 + numero2;

        System.out.println("La suma es: " + suma);

        scanner.close();
    }
}
