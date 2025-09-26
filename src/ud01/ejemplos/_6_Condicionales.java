package ud01.ejemplos;
import java.util.Scanner;

public class _6_Condicionales {

    // Scanner declarado como variable de clase
    static Scanner entrada;

    public static void main(String[] args) {
        // Instanciamos Scanner dentro del main
        entrada = new Scanner(System.in);

        if_simple();
        if_else();
        if_else_if();
        ternario();
        switch_dia();

        entrada.close();
    }

    // 1. IF -> ¿Es negativo?
    public static void if_simple() {
        int numero;
        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        if (numero < 0) {
            System.out.println("El número es negativo");
        }
    }

    // 2. IF - ELSE -> ¿Es negativo o positivo?
    public static void if_else() {
        int numero;
        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        if (numero < 0) {
            System.out.println("El número es negativo");
        } else {
            System.out.println("El número es positivo");
        }
    }

    // 3. IF - ELSE IF - ELSE -> ¿Negativo, positivo o cero?
    public static void if_else_if() {
        int numero;
        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        if (numero < 0) {
            System.out.println("El número es negativo");
        } else if (numero > 0) {
            System.out.println("El número es positivo");
        } else {
            System.out.println("El número es cero");
        }
    }

    // 4. Operador Ternario -> ¿Negativo, positivo o cero?
    public static void ternario() {
        int numero;
        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        String resultado = (numero < 0) ? "Negativo"
                          : (numero > 0) ? "Positivo"
                          : "Cero";
        System.out.println("El número es: " + resultado);
    }

    // 5. SWITCH -> Día de la semana
    public static void switch_dia() {
        System.out.print("Introduce un día de la semana (ej: Lunes): ");
        entrada.nextLine(); // limpiar buffer
        String dia = entrada.nextLine();

        switch (dia) {
            case "Lunes": 
                System.out.println("Inicio de semana"); break;
            case "Martes": 
                System.out.println("Segundo día de la semana"); break;
            case "Miércoles": 
                System.out.println("Mitad de la semana"); break;
            case "Jueves": 
                System.out.println("Casi viernes"); break;
            case "Viernes": 
                System.out.println("Fin de semana cerca"); break;
            case "Sábado": 
            case "Domingo": 
                System.out.println("Es fin de semana"); break;
            default: 
                System.out.println("Día inválido"); break;
        }
    }
}
