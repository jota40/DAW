package ud01.tareas._04_Bucles;

import java.util.Scanner;

public class _07_ContarDesdeHasta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número inicial: ");
        int inicio = sc.nextInt();

        System.out.print("Introduce el número final: ");
        int fin = sc.nextInt();

        int numero = inicio;
        while (numero <= fin) {
            System.out.println(numero);
            numero++;
        }
    }
}
