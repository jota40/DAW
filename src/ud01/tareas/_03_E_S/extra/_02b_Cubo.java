package ud01.tareas._03_E_S.extra;

import java.util.Scanner;

public class _02b_Cubo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el lado del cubo: ");
        double lado = sc.nextDouble();

        double area = 6 * lado * lado;
        double volumen = lado * lado * lado;

        System.out.println("Área del cubo: " + area);
        System.out.println("Volumen del cubo: " + volumen);
    }
}
