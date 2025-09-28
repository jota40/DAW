package ud01.ejemplos.m02;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class _5_EntradaTeclado {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Entrada con Scanner");
            System.out.println("2. Entrada con BufferedReader");
            System.out.println("3. Entrada con Console");
            System.out.println("4. Entrada con JOptionPane");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    entradaScanner();
                    break;
                case 2:
                    entradaBufferedReader();
                    break;
                case 3:
                    entradaConsole();
                    break;
                case 4:
                    entradaJOptionPane();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        System.out.println("Programa finalizado.");
    }

    // 1. Entrada con Scanner
    static void entradaScanner() {
        System.out.println("\n=== Entrada con Scanner ===");
        System.out.print("Introduce un entero: ");
        int entero = sc.nextInt();
        System.out.print("Introduce un real: ");
        double real = sc.nextDouble();
        System.out.print("Introduce un carácter: ");
        char caracter = sc.next().charAt(0);
        sc.nextLine(); // limpiar buffer
        System.out.print("Introduce un texto: ");
        String texto = sc.nextLine();
        System.out.print("Introduce un booleano (true/false): ");
        boolean bool = sc.nextBoolean();

        mostrarResultados(entero, real, caracter, texto, bool, "Scanner");
    }

    // 2. Entrada con BufferedReader
    static void entradaBufferedReader() throws IOException {
        System.out.println("\n=== Entrada con BufferedReader ===");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduce un entero: ");
        int entero = Integer.parseInt(br.readLine());
        System.out.print("Introduce un real: ");
        double real = Double.parseDouble(br.readLine());
        System.out.print("Introduce un carácter: ");
        char caracter = br.readLine().charAt(0);
        System.out.print("Introduce un texto: ");
        String texto = br.readLine();
        System.out.print("Introduce un booleano (true/false): ");
        boolean bool = Boolean.parseBoolean(br.readLine());

        mostrarResultados(entero, real, caracter, texto, bool, "BufferedReader");
    }

    // 3. Entrada con Console
    static void entradaConsole() {
        System.out.println("\n=== Entrada con Console ===");
        Console console = System.console();

        if (console == null) {
            System.out.println("Console no está disponible en este entorno.");
            return;
        }

        int entero = Integer.parseInt(console.readLine("Introduce un entero: "));
        double real = Double.parseDouble(console.readLine("Introduce un real: "));
        char caracter = console.readLine("Introduce un carácter: ").charAt(0);
        String texto = console.readLine("Introduce un texto: ");
        boolean bool = Boolean.parseBoolean(console.readLine("Introduce un booleano (true/false): "));

        mostrarResultados(entero, real, caracter, texto, bool, "Console");
    }

    // 4. Entrada con JOptionPane
    static void entradaJOptionPane() {
        System.out.println("\n=== Entrada con JOptionPane ===");

        int entero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un entero:"));
        double real = Double.parseDouble(JOptionPane.showInputDialog("Introduce un real:"));
        char caracter = JOptionPane.showInputDialog("Introduce un carácter:").charAt(0);
        String texto = JOptionPane.showInputDialog("Introduce un texto:");
        boolean bool = Boolean.parseBoolean(JOptionPane.showInputDialog("Introduce un booleano (true/false):"));

        mostrarResultados(entero, real, caracter, texto, bool, "JOptionPane");
    }

    // Método auxiliar para mostrar resultados
    static void mostrarResultados(int entero, double real, char caracter, String texto, boolean bool, String metodo) {
        System.out.println("\n--- Resultados usando " + metodo + " ---");
        System.out.println("Entero: " + entero);
        System.out.println("Real: " + real);
        System.out.println("Carácter: " + caracter);
        System.out.println("Texto: " + texto);
        System.out.println("Booleano: " + bool);
    }
}
