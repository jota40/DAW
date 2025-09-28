package ud01.ejemplos.m02; // Ruta donde se encuentra la clase

import java.util.Random; // Importa una clasw de otra librería
                         // Ahorra escribir la ruta completa cada vez

// public: Hace la clase es accesible desde otras clases
    // class: Crea una clase
public class _1_Programa { // Java requiere que todo el código esté dentro de una clase

 // public: Hace la funcion es accesible desde cualquier parte del código
       //  static = Permite ejecutar el método sin instanciar la clase
               // void = No devuelve ningún valor
                         // String[] args = Variable con la informacion recibida desde el CLI
    public static void main(String[] args) { // Main = Punto de incio del programa
   
        Random generador = new Random(); // Crear un objeto de la clase Random
        int numero = generador.nextInt(10); // Genera un número aleatorio entre 0 y 9
        
        System.out.println("Número aleatorio: " + numero); // Imprime información en la consola
    }
}

