package ud01.tareas._04_Bucles;

import java.time.Year;
import java.util.Scanner;

public class _04_MayorDeEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola, soy tu PC.");
        System.out.print("¿Cuál es tu nombre? ");
        String nombre = sc.nextLine();

        System.out.print("¿Cuál es tu año de nacimiento? ");
        int anyo = sc.nextInt();

        int edad = Year.now().getValue() - anyo;
/*
        if (edad >= 18) {
            System.out.println("Buenos días " + nombre + ", eres mayor de edad.");
        } else {
            System.out.println("Buenos días " + nombre + ", NO eres mayor de edad.");
        }
 */
        String no = "\b";
        if (edad < 18) {
        	no = "no";
        }
        System.out.printf("Buenos días %s, %s eres mayor de edad.", nombre, no);
    }
}
