package ud01.tareas._05_PM;

import java.util.Calendar;
import java.util.Scanner;

public class _05_Cumpleanyos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int edad;

		// Obtiene la fecha actual
		Calendar calendario = Calendar.getInstance();
		int anioActual = calendario.get(Calendar.YEAR);
		int mesActual = calendario.get(Calendar.MONTH) + 1; // Enero = 0
		int diaActual = calendario.get(Calendar.DAY_OF_MONTH);

		int[] fechaNacimiento = obtenerFechaNacimiento(sc);
		edad = anioActual - fechaNacimiento[2];

		if (fechaNacimiento[1] == mesActual && fechaNacimiento[0] == diaActual) {
			System.out.println("¡Feliz " + edad + " cumpleaños!");
		} else {
			System.out.printf("Tienes %d años -> método 1%n",
					edad + ajustarEdad_v1(fechaNacimiento[0], fechaNacimiento[1], diaActual, mesActual));
			System.out.printf("Tienes %d años -> método 2%n",
					edad + ajustarEdad_v2(fechaNacimiento[0], fechaNacimiento[1], diaActual, mesActual));
		}
	}

	// Función que devuelve true si el año es bisiesto
	public static boolean esBisiesto(int anio) {
		return (anio % 4 == 0) && (anio % 100 != 0 || anio % 400 == 0);
	}

	private static int[] obtenerFechaNacimiento(Scanner sc) {
	    // Índices descriptivos
	    final int DIA = 0;
	    final int MES = 1;
	    final int ANIO = 2;

	    int[] fechaNacimiento = new int[3];
	    int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    boolean ok;

	    sc.useDelimiter("/|\\n|\\r\\n");

	    do {
	        ok = true;
	        System.out.print("Introduce tu fecha de nacimiento (dd/mm/aaaa): ");

	        for (int i = 0; i < 3; i++) {
	            if (sc.hasNextInt()) {
	                fechaNacimiento[i] = sc.nextInt();
	            } else {
	                ok = false;
	                System.out.println("Formato incorrecto. Usa el formato dd/mm/aaaa.");
	                sc.nextLine(); // limpiar buffer
	                break;
	            }
	        }

	        if (!ok)
	            continue;

	        sc.nextLine(); // limpiar salto de línea restante

	        int dia = fechaNacimiento[DIA];
	        int mes = fechaNacimiento[MES];
	        int anio = fechaNacimiento[ANIO];

	        // Validar mes
	        if (mes < 1 || mes > 12) {
	            System.out.println("Mes inválido. Debe estar entre 1 y 12.");
	            continue;
	        }

	        // Ajustar febrero si el año es bisiesto
	        diasPorMes[1] = esBisiesto(anio) ? 29 : 28;

	        // Validar día
	        int maxDiasMes = diasPorMes[mes - 1]; // los meses van de 1-12 pero el array va de 0-11
	        if (dia < 1 || dia > maxDiasMes) {
	            System.out.println("Día inválido para este mes.");
	            continue;
	        }

	        // Validar año
	        if (anio < 1900) {
	            System.out.println("Año inválido.");
	            continue;
	        }

	        break; // fecha válida → salir del bucle

	    } while (true);

	    return fechaNacimiento;
	}

	private static int ajustarEdad_v1(int dia, int mes, int diaActual, int mesActual) {
		int ajuste = 0;

		if (mes < mesActual) {
			ajuste = 0;
		} else if (mes > mesActual) {
			ajuste = -1;
		} else { // mes == mesActual
			if (dia < diaActual) {
				ajuste = 0;
			} else if (dia > diaActual) {
				ajuste = -1;
			}
		}
		return ajuste;
	}

	private static int ajustarEdad_v2(int dia, int mes, int diaActual, int mesActual) {
		int ajuste = -1;

		if (mes < mesActual || (mes == mesActual && dia < diaActual)) {
			ajuste = 0;
		}
		return ajuste;
	}
}