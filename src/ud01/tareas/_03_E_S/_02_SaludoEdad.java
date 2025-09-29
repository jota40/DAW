package ud01.tareas._03_E_S;

import java.time.Year;
import java.util.Scanner;

public class _02_SaludoEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola, soy tu PC.");
        System.out.print("¿Cuál es tu nombre? ");
        String nombre = sc.nextLine();
/*
		int anyo = 0;
	    System.out.print("¿Cuál es tu año de nacimiento? ");
		while(!sc.hasNextInt()) {
			sc.nextLine(); // vacia el buffer
			System.out.print("Un año es un número.\n¿Cuál es tu año de nacimiento? ");
		} 
*/
	    System.out.print("¿Cuál es tu año de nacimiento? ");
        int anyo = sc.nextInt();

        int edad = Year.now().getValue() - anyo;

        System.out.print("Buenos días " + nombre + ", tienes " + edad + " años\n");
        System.out.println("Buenos días " + nombre + ", tienes " + edad + " años");
        System.out.printf("Buenos días %s, tienes %d años%n", nombre, edad);
    }
}
