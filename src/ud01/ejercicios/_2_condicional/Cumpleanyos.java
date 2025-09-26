package ud01.ejercicios._2_condicional;

import java.util.Calendar;
import java.util.Scanner;

public class Cumpleanyos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int anio, mes, dia;
		int anioActual, mesActual, diaActual;
		int edad;

		// Obtiene la fecha actual
		Calendar calendario = Calendar.getInstance();
		anioActual = calendario.get(Calendar.YEAR);
		mesActual = calendario.get(Calendar.MONTH) + 1; // Enero = 0
		diaActual = calendario.get(Calendar.DAY_OF_MONTH);

		// Pedir fecha de nacimiento
		System.out.print("Año de nacimiento? ");
		anio = sc.nextInt();

		System.out.print("Mes de nacimiento? ");
		mes = sc.nextInt();

		System.out.print("Día de nacimiento? ");
		dia = sc.nextInt();

		// Calcular edad aproximada
		edad = anioActual - anio;

		if (mes < mesActual) {
			System.out.println("Tienes " + edad + " años");
		} else if (mes > mesActual) {
			System.out.println("Tienes " + (edad - 1) + " años");
		} else { // mes == mesActual
			if (dia < diaActual) {
				System.out.println("Tienes " + edad + " años");
			} else if (dia > diaActual) {
				System.out.println("Tienes " + (edad - 1) + " años");
			} else {
				System.out.println("¡Feliz " + edad + " cumpleaños!");
			}
		}
	}
}
