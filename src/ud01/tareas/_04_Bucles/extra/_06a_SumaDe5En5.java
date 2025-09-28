package ud01.tareas._04_Bucles.extra;

public class _06a_SumaDe5En5 {
    public static void main(String[] args) {
        int n = 5;
        int suma = 0;

        do {
            suma = suma + n;
            System.out.print(n + " ");
            n = n + 5;
        } while (n <= 100);

        System.out.println("= " + suma);
    }
}
