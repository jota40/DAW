package ud01.tareas._03_E_S.extra;

import java.util.Scanner;

public class _01b_Cuadrado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la longitud del lado del cuadrado: ");
        double lado = sc.nextDouble();

        double area = lado * lado;
        System.out.println("El área del cuadrado es: " + area);
    }
}
