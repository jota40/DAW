package ud01.tareas._04_PE;

public class _06_ContarHasta1000 {
	public static void main(String[] args) {
		int numero = 1;

		while (numero <= 1000) {
			System.out.printf("%4d ", numero);
			if (numero % 50 == 0)
				System.out.println();
			numero++;
		}
	}
}
