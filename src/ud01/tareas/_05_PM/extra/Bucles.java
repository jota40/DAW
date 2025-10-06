package ud01.tareas._05_PM.extra;

public class Bucles {

	public static void printline(int asteriscos, int totalCaracteres) {
		int indice = 1;
		// espacios = total - asteriscos
		while (indice <= totalCaracteres - asteriscos) {
			System.out.print(" ");
			indice++;
		}
		// el resto son asteriscos
		while (indice <= totalCaracteres) {
			System.out.print("*");
			indice++;
		}
	}

	public static void t1(int totalLineas) {
		for (int asteriscos = 1; asteriscos <= totalLineas; asteriscos++) {
			printline(asteriscos, totalLineas);
			System.out.println();
		}
	}

	public static void t2(int totalLineas) {
		for (int asteriscos = 1; asteriscos <= totalLineas; asteriscos++) {
			printline(asteriscos, asteriscos);
			System.out.println();
		}
	}

	public static void t3(int totalLineas) {
		for (int asteriscos = totalLineas; asteriscos > 0; asteriscos--) {
			printline(asteriscos, totalLineas);
			System.out.println();
		}
	}

	public static void t4(int totalLineas) {
		for (int asteriscos = totalLineas; asteriscos > 0; asteriscos--) {
			printline(asteriscos, asteriscos);
			System.out.println();
		}
	}

	public static void p1(int totalLineas) {
		p1(totalLineas, 0);
	}

	public static void p1(int totalLineas, int impar) {
		for (int esteriscos = 1; esteriscos <= totalLineas; esteriscos++) {
			printline(esteriscos, totalLineas);
			printline(esteriscos - impar, esteriscos - impar);
			System.out.println();
		}
	}

	public static void p2(int totalLineas) {
		p2(totalLineas, 0);
	}

	public static void p2(int totalLineas, int impar) {

		for (int asteriscos = totalLineas; asteriscos > 0; asteriscos--) {
			printline(asteriscos, totalLineas);
			printline(asteriscos - impar, asteriscos - impar);
			System.out.println();
		}
	}

	public static void r1(int totalLineas) {
		p1(totalLineas,1);
		p2(totalLineas,1);
	}

	public static void main(String[] args) {
		int size = 4;
		t1(size);
		System.out.println("---------------------");
		t2(size);
		System.out.println("---------------------");
		t3(size);
		System.out.println("---------------------");
		t4(size);
		System.out.println("---------------------");
		p1(size);
		System.out.println("---------------------");
		p2(size);
		System.out.println("---------------------");
		r1(size);
		System.out.println("---------------------");
	}
}
