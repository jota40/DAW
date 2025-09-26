package ud01.ejercicios._3_bucles;

public class Bucles {

	public static void t1(int size) {
		for (int i = 0; i < size; i++) {
			int j;
			for (j = 0; j < size - i; j++) {
				System.out.print(" ");
			}
			for (; j <= size; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void t2(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void t3(int size) {
		for (int i = 0; i < size; i++) {
			int j;
			for (j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (; j <= size; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void t4(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int size = 6;
		t1(size);
		t2(size);
		t3(size);
		t4(size);
	}
}
