package ud01.ejemplos;
public class _2_DesbordamientoByte {
    public static void main(String[] args) {
        byte a = 120;
        byte b = 10;
        byte c = (byte)(a + b); // Esto provoca un overflow

        System.out.println("Resultado esperado: 130");
        System.out.println("Resultado real con byte: " + c);
    }
}
