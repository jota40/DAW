package ud01.ejemplos.m02;
public class _4_SalidaPantalla {
    public static void main(String[] args) {
        int entero = 42;
        double real = 3.14159;
        String texto = "Hola";
        char letra = 'A';
        boolean bool = true;

        System.out.println("=== Ejemplos de printf() ===");

        // Enteros
        System.out.printf("Entero decimal: %d%n", entero);
        System.out.printf("Entero octal: %o%n", entero);
        System.out.printf("Entero hexadecimal (min): %x%n", entero);
        System.out.printf("Entero hexadecimal (may): %X%n%n", entero);

        // Reales
        System.out.printf("Real por defecto: %f%n", real);
        System.out.printf("Real con 2 decimales: %.2f%n", real);
        System.out.printf("Real notación científica: %e%n", real);
        System.out.printf("Real notación científica (E): %E%n", real);
        System.out.printf("Real corto (g): %g%n%n", real);

        // Otros tipos
        System.out.printf("Cadena: %s%n", texto);
        System.out.printf("Carácter: %c%n", letra);
        System.out.printf("Booleano: %b%n", bool);
        System.out.printf("Imprimir %%: 100%%%n%n");

        // Caracteres especiales
        System.out.println("=== Caracteres de escape ===");
        System.out.println("Salto de línea -> Hola\nMundo");
        System.out.println("Tabulación -> Hola\tMundo");
        System.out.println("Comillas dobles -> \"Hola\"");
        System.out.println("Barra invertida -> C:\\Users\\");
    }
}
