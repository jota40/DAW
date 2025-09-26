package ud01.ejemplos;
public class _2_TamañoTiposPrimitivos {

    public static void main(String[] args) {
        // Tipos enteros
        byte b = 100;
        short s = 10000;
        int i = 100000;
        long l = 10000000000L;

        // Tipos decimales
        float f = 3.14f;
        double d = 3.14159265358979;

        // Tipo carácter
        char c = 'A';

        // Tipo booleano
        boolean bool = true;

        // Mostrar tamaños y valores
        System.out.println("Tipos Enteros:");
        System.out.println("byte:    " + b + " | Tamaño: " + Byte.SIZE + " bits (" + Byte.BYTES + " bytes)");
        System.out.println("short:   " + s + " | Tamaño: " + Short.SIZE + " bits (" + Short.BYTES + " bytes)");
        System.out.println("int:     " + i + " | Tamaño: " + Integer.SIZE + " bits (" + Integer.BYTES + " bytes)");
        System.out.println("long:    " + l + " | Tamaño: " + Long.SIZE + " bits (" + Long.BYTES + " bytes)");

        System.out.println("\nTipos Decimales:");
        System.out.println("float:   " + f + " | Tamaño: " + Float.SIZE + " bits (" + Float.BYTES + " bytes)");
        System.out.println("double:  " + d + " | Tamaño: " + Double.SIZE + " bits (" + Double.BYTES + " bytes)");

        System.out.println("\nTipo Carácter:");
        System.out.println("char:    '" + c + "' | Código Unicode: " + (int)c + " | Tamaño: " + Character.SIZE + " bits (" + Character.BYTES + " bytes)");

        System.out.println("\nTipo Booleano:");
        System.out.println("boolean: " + bool + " | Tamaño: No definido exactamente (usualmente 1 bit o más)");
    }
}
