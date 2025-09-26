package ud01.tareas._03_E_S.extra;

import java.util.Scanner;

	public class _02a_Cilindro {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Introduce el radio del cilindro: ");
	        double radio = sc.nextDouble();

	        System.out.print("Introduce la altura del cilindro: ");
	        double altura = sc.nextDouble();

	        double area = 2 * Math.PI * radio * (radio + altura);
	        double volumen = Math.PI * radio * radio * altura;

	        System.out.println("Área del cilindro: " + area);
	        System.out.println("Volumen del cilindro: " + volumen);
	    }
	}
