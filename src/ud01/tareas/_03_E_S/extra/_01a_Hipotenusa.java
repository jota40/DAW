package ud01.tareas._03_E_S.extra;

import java.util.Scanner;

public class _01a_Hipotenusa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer cateto: ");
        double cateto1 = sc.nextDouble();

        System.out.print("Introduce el segundo cateto: ");
        double cateto2 = sc.nextDouble();

        double hipotenusa = Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
        System.out.println("La hipotenusa del triángulo es: " + hipotenusa);
    }
}
