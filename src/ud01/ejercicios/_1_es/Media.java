package ud01.ejercicios._1_es;
import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir la nota de la primera evaluación
        System.out.print("Introduce la nota de la primera evaluación: ");
        float evaluacion1 = sc.nextFloat();

        // Pedir la nota de la segunda evaluación
        System.out.print("Introduce la nota de la segunda evaluación: ");
        float evaluacion2 = sc.nextFloat();

        // Calcular la media
        float media = (evaluacion1 + evaluacion2) / 2;

        // Mostrar el resultado
        System.out.println("La nota media es: " + media); // toString usa . 
        System.out.printf("La nota media es: %.2f%n", media); // printf usa el locale

        sc.close();
    }
}
