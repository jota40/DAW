package ud01.tareas._05_PM.extra;

import java.util.Scanner;

import common.Utils;

public class _09_DecimalABinario {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número
        System.out.print("Introduce un número decimal: ");
        int numero = Utils.leerEntero(sc);

        System.out.printf("%0b", numero);

        // Convertir a hexadecimal
        String hexadecimal = Integer.toHexString(numero).toUpperCase();

        StringBuilder binario = new StringBuilder();

        // Recorrer cada carácter del string hexadecimal
        for (int i = 0; i < hexadecimal.length(); i++) {
            char c = hexadecimal.charAt(i);
            int nibble = Character.digit(c, 16); // Carácter hex a decimal

            // Convertir el valor decimal a binario usando AND
            for (int bit = 3; bit >= 0; bit--) { // Cada dígito hexadecimal son 4 bits
                int bitValor = (nibble >> bit) & 1;
                binario.append(bitValor);
            }

            binario.append(" "); // Separador por dígito hexadecimal
        }

        System.out.println("Número decimal: " + numero);
        System.out.println("Número hexadecimal: " + hexadecimal);
        System.out.println("Número binario por dígito hex: " + binario.toString());

        sc.close();
    }
}
