package ud01.ejemplos.m02;

import java.util.Date; // Importa una clase externa

// public: Hace la clase es accesible desde otras clases
    // class: Crea una clase
public class _1_App { // Java requiere que todo el código esté dentro de una clase

    // public: Hace el método accesible desde cualquier sitio
          //  static = Permite ejecutar el método crera un objeto
                  // void = El método no devuelve ningún valor
                            // String[] args = Contiene la informacion enviada desde el CLI
       public static void main(String[] args) { // Punto de incio del programa
            Date fecha = new Date(); // Crea un objeto de tipo Date
            System.out.println("Hoy es: " + fecha); // Imprime información en la consola
    }
}
