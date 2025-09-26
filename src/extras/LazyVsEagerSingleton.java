package extras;

/**
 * Ejemplo para ver la diferencia entre Lazy (Bill Pugh) y Eager (JNA) Singleton
 */
public class LazyVsEagerSingleton {

    // -------------------------
    // Eager Singleton (JNA-style)
    // -------------------------
    public static class EagerSingleton {
        // Se inicializa al cargar la clase
        public static final EagerSingleton INSTANCE = new EagerSingleton();

        private EagerSingleton() {
            System.out.println("EagerSingleton creado");
        }
    }

    // -------------------------
    // Lazy Singleton (Bill Pugh)
    // -------------------------
    public static class LazySingleton {

        private LazySingleton() {
            System.out.println("LazySingleton creado");
        }

        private static class Holder {
            private static final LazySingleton INSTANCE = new LazySingleton();
        }

        public static LazySingleton getInstance() {
            return Holder.INSTANCE;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Programa iniciado");

        System.out.println("\n== Clase EagerSingleton cargada ==");
        // La clase se carga al hacer referencia a la clase
        Class<?> eagerClass = EagerSingleton.class;
        System.out.println("No se ha accedido a INSTANCE aún, pero ya se ejecutó el constructor");
        Thread.sleep(1000);

        System.out.println("\n== Clase LazySingleton cargada ==");
        Class<?> lazyClass = LazySingleton.class;
        System.out.println("Clase cargada, pero el constructor no se ejecuta aún");
        Thread.sleep(1000);

        System.out.println("\n== Accediendo a LazySingleton por primera vez ==");
        LazySingleton lazy = LazySingleton.getInstance(); // Aquí se crea la instancia
        System.out.println("Ahora se ejecutó el constructor de LazySingleton");
    }
}
