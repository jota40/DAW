package ud01.ejercicios._3_bucles;

import java.util.Scanner;

public class DecimalABinario {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número como string
        System.out.print("Introduce un número decimal: ");
        String numeroStr = sc.nextLine();

        // Convertir el número string a entero
        int numero = Integer.parseInt(numeroStr);

        // Convertir a hexadecimal
        String hexStr = Integer.toHexString(numero).toUpperCase();

        StringBuilder resultado = new StringBuilder();

        // Recorrer cada carácter del string hexadecimal
        for (int i = 0; i < hexStr.length(); i++) {
            char c = hexStr.charAt(i);
            int valorDecimal = Character.digit(c, 16); // Carácter hex a decimal

            // Convertir el valor decimal a binario usando AND
            StringBuilder binario = new StringBuilder();
            for (int bit = 3; bit >= 0; bit--) { // Cada dígito hexadecimal cabe en 4 bits
                int bitValor = (valorDecimal >> bit) & 1;
                binario.append(bitValor);
            }

            resultado.append(binario).append(" "); // Separador por dígito hexadecimal
        }

        System.out.println("Número decimal: " + numeroStr);
        System.out.println("Número hexadecimal: " + hexStr);
        System.out.println("Número binario por dígito hex: " + resultado.toString());

        sc.close();
    }
}
