package ud01.tareas._04_Bucles;

import java.util.Scanner;

public class _08_SumarContando {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el 1er sumando: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el 2º sumando: ");
        int num2 = sc.nextInt();

        int resultado = num1;
        int contador = 1;

        while (contador <= num2) {
            System.out.println("El resultado es " + resultado + " por ahora");
            resultado = resultado + 1;
            contador++;
        }

        System.out.println("El resultado es " + resultado);
    }
}
