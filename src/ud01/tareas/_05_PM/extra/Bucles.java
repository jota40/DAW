package ud01.tareas._05_PM.extra;

public class Bucles {

	public static void printline(int i, int size) {
		int j = 1;
		while (j <= size - i) {
			System.out.print(" ");
			j++;
		}
		while (j <= size) {
			System.out.print("*");
			j++;
		}
	}

	public static void t1(int size) {
		for (int i = 1; i <= size; i++) {
			printline(i, size);
			System.out.println();
		}
	}

	public static void t2(int size) {
		for (int i = 1; i <= size; i++) {
			printline(i, i);
			System.out.println();
		}
	}

	public static void t3(int size) {
		for (int i = size; i > 0; i--) {
			printline(i, size);
			System.out.println();
		}
	}

	public static void t4(int size) {
		for (int i = size; i > 0; i--) {
			printline(i, i);
			System.out.println();
		}
	}

	public static void p1(int size) {
		for (int i = 1; i <= size; i++) {
			printline(i, size);
			printline(i, i);
			System.out.println();
		}
	}

	public static void p2(int size) {
		for (int i = size; i > 0; i--) {
			printline(i, size);
			printline(i, i);
			System.out.println();
		}
	}

	public static void r1(int size) {
		p1(size);
		p2(size);
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
