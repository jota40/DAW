package ud01.ejercicios._1_es;
import java.util.Scanner;

public class RestarEdades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir edad de la madre
        System.out.print("Introduce la edad de tu madre: ");
        int edadMadre = sc.nextInt();

        // Pedir tu edad
        System.out.print("Introduce tu edad: ");
        int edadHijo = sc.nextInt();

        // Calcular diferencia
        int diferencia = edadMadre - edadHijo;

        // Mostrar resultado
        System.out.println("Tu madre tiene " + diferencia + " años más que tú");
        System.out.printf("Tu madre tiene %d años más que tú%n", diferencia);


        sc.close();
    }
}
