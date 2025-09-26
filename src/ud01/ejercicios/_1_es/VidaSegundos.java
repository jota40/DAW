package ud01.ejercicios._1_es;
import java.util.Scanner;

public class VidaSegundos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir nombre
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        // Pedir edad
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        // Calcular segundos aproximados
        long segundosVividos = (long) edad * 365 * 24 * 60 * 60;

        // Mostrar resultado
        System.out.println(nombre + ", has vivido " + segundosVividos + " segundos, aproximadamente");
        System.out.printf("%s, has vivido %d segundos, aproximadamente%n", nombre, segundosVividos);

        sc.close();
    }
}
