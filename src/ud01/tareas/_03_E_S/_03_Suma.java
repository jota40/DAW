package ud01.tareas._03_E_S;

import java.util.Scanner;

public class _03_Suma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el 1er sumando: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el 2º sumando: ");
        int num2 = sc.nextInt();

        int suma = num1 + num2;

        System.out.println("El resultado es " + suma);
        System.out.println("El resultado es " + (num1 + num2));
        System.out.println("El resultado es " + num1 + num2);
        System.out.printf("%d + %d = %d%n",  num1, num2, suma);
        System.out.printf("%d + %d = %d%n", num1, num2, num1 + num2);
    }
}
