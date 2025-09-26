import java.util.Scanner;

public class dummy {
    static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        System.out.println("\n=== Entrada con Scanner ===");
        System.out.print("Introduce un entero, real, palabra: ");
        if (sc.hasNextInt()) {
        int entero = sc.nextInt();
        String texto = sc.nextLine();
        double real = sc.nextDouble();
        System.out.printf("Introducido: %d, %f, %s%n",entero, real, texto);
        }
      /*
      System.out.print("Introduce un text: ");
        String texto2 = sc.nextLine();

        System.out.printf("Introducido despues:%s%n",texto2);
	*/}
}
