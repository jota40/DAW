package ud01.tareas._04_PE;

import java.util.Scanner;

public class _05_SumarOMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el 1er número: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el 2º número: ");
        int num2 = sc.nextInt();

        sc.nextLine(); // Limpiar buffer
        System.out.print("¿Deseas 'sumar' o 'multiplicar'? ");
        String opcion = sc.nextLine();

        int resultado;
        String operacion;
        if (opcion.equalsIgnoreCase("sumar")) {
        	operacion = "La suma";
            resultado = num1 + num2;
        } else {
        	operacion = "El producto";
            resultado = num1 * num2;
        }

        System.out.println(operacion + " es " + resultado);
        System.out.printf("%s es %d%n", operacion , resultado);
    }
}
