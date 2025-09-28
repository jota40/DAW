package ud01.tareas._04_Bucles.extra;

public class _06c_SumaImpares {
    public static void main(String[] args) {
        int n = 1;
        int suma = 0;

        do {
            suma = suma + n;
            System.out.print(n + " ");
            n = n + 2;
        } while (n <= 300);

        System.out.println("= " + suma);
    }
}
