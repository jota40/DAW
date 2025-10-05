package ud01.tareas._05_PM.extra;

import java.util.Scanner;

public class calcularMedia {
    public static void main(String[] args) {
        final int SIZE = 5;
        float[] nota = new float[SIZE];
        float acc = 0.0f;
        Scanner sc = new Scanner(System.in);

        // Leer notas
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Nota " + (i + 1) + "? ");
            nota[i] = sc.nextFloat();
        }

        // Calcular suma
        for (int i = 0; i < SIZE; i++) {
            acc += nota[i];
        }

        // Mostrar media
        System.out.println("media = " + (acc / SIZE));

        sc.close();
    }
}
