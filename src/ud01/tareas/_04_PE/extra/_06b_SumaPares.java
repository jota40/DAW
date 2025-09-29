package ud01.tareas._04_PE.extra;

public class _06b_SumaPares {
    public static void main(String[] args) {
        int n = 2;
        int suma = 0;

        do {
            suma = suma + n;
            System.out.print(n + " ");
            n = n + 2;
        } while (n <= 100);

        System.out.println("= " + suma);
    }
}
