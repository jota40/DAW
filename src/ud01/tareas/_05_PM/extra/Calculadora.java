package ud01.tareas._05_PM.extra;

import java.util.Scanner;

import common.Utils;

public class Calculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numero1, numero2;
		char operacion;

		System.out.print("Operacion +|-|*|/ ? ");
		operacion = sc.next().charAt(0); // Leer un solo caracter

		System.out.print("Primer operando? ");
		numero1 = Utils.leerEntero(sc);

		System.out.print("Segundo operando? ");
		numero2 = Utils.leerEntero(sc);

		int resultado;

		switch (operacion) {
		case '+':
			resultado = numero1 + numero2;
			System.out.println(numero1 + " + " + numero2 + " = " + resultado);
			break;
		case '-':
			resultado = numero1 - numero2;
			System.out.println(numero1 + " - " + numero2 + " = " + resultado);
			break;
		case '*':
			resultado = numero1 * numero2;
			System.out.println(numero1 + " * " + numero2 + " = " + resultado);
			break;
		case '/':
			if (numero2 != 0) {
				resultado = numero1 / numero2;
				System.out.println(numero1 + " / " + numero2 + " = " + resultado);
			} else {
				System.out.println("Error: División entre cero no permitida");
			}
			break;
		default:
			System.out.println("No conozco esa operación");
		}
	}
}
