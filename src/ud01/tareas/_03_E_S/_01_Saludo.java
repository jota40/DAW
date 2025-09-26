package ud01.tareas._03_E_S;

import java.util.Scanner;

public class _01_Saludo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola, soy tu PC.");
        System.out.print("¿Cuál es tu nombre? ");
        String nombre = sc.nextLine();

        System.out.print("Buenos días " + nombre + "\n");
        System.out.println("Buenos días " + nombre);
        System.out.printf("Buenos días %s%n", nombre);
    }
}
