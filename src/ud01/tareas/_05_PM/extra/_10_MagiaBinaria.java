package ud01.tareas._05_PM.extra;

import java.util.Scanner;

import common.Utils;

public class _10_MagiaBinaria {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] respuestas = {"si","no"};
        final int MAX = 100;
        int solucion = 0, mask;
        

        System.out.printf("Piensa un número del 1 al %d%nPulsa intro para empezar", MAX);
        sc.nextLine();
        
        int paginas = (int) Math.ceil(Math.log(MAX+1)/Math.log(2));
		for ( int bit = 0 ; bit < paginas ;bit++) {
			mask = 1 << bit;
			for ( int numero = 1, contador=0; numero <= MAX; numero++) {
				if ( (numero & mask) > 0 ) {
					System.out.printf("%3d ", numero);
					contador++;
					if ( contador % 5 == 0 ) {
						System.out.println();
					}
				}
			}
	        System.out.print("\n¿El número que has pensado está aqui? ");
	        String respuesta = Utils.leerPalabraValida(sc, respuestas);
	        if (respuesta.equals("si") ) {
	        	solucion |= mask;
	        }
		}
        System.out.printf("\nEl número que has pensado es el %d",solucion);
        sc.close();
    }
}
