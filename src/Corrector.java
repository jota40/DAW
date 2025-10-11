import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Corrector
 * ==========
 * Programa para automatizar la compilación y ejecución de prácticas Java
 * entregadas por alumnos, registrando los resultados en ficheros de salida.
 *
 * - Busca carpetas de alumnos dentro de un directorio raíz.
 * - Compila todos los archivos .java de cada alumno.
 * - Identifica qué clases corresponden a las prácticas esperadas
 *   según un fichero de filtros ("filtros.txt").
 * - Ejecuta cada práctica con su entrada correspondiente ("entrada1.txt", etc.).
 * - Guarda los resultados en:
 *     _compilar.txt → registro de compilaciones
 *     _salida.txt   → resultados de ejecución
 */
public class Corrector {

    // --- Atributos principales ---
    private Path practicasDir;                // Carpeta raíz con las prácticas
    private String[] nombresPracticas;        // Nombres esperados de clases (desde filtros.txt)
    private Map<Path, String[]> alumnos;      // Mapa: carpeta del alumno → clases detectadas
    private Scanner scanner;                  // Para leer entrada del usuario

    // --- Método principal ---
    public static void main(String[] args) {
        new Corrector(); // Crea y ejecuta el corrector
    }

    // --- Constructor: lógica principal del programa ---
    Corrector() {
        scanner = new Scanner(System.in);

        // --- Paso 1: Seleccionar carpeta raíz de prácticas ---
        if (!setPracticasDir()) {
            System.out.println("❌ No hay ninguna práctica en esa carpeta.");
            return; // No continúa si la ruta no es válida
        }

        // --- Paso 2: Leer nombres de prácticas esperadas desde filtros.txt ---
        try {
            nombresPracticas = Files.readAllLines(
                    practicasDir.resolve("filtros.txt"), StandardCharsets.UTF_8
            ).toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ No se han podido obtener los posibles nombres de las clases Java a ejecutar.");
            return;
        }

        // --- Paso 3: Detectar carpetas de alumnos ---
        if (!setAlumnos()) {
            System.out.println("❌ No hay carpetas de alumnos.");
            return;
        }

        // --- Paso 4: Preparar archivos de salida ---
        Path salida = practicasDir.resolve("salida.txt");
        Path compilar = practicasDir.resolve("compilar.txt");

        try (BufferedWriter salidaWriter = Files.newBufferedWriter(
                salida, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
             BufferedWriter compilarWriter = Files.newBufferedWriter(
                compilar, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            // --- Paso 5: Iterar sobre cada carpeta de alumno ---
            Iterator<Path> it = alumnos.keySet().iterator();
            while (it.hasNext()) {
                Path alumno = it.next();

                // Mostrar por consola y registrar en fichero
                System.out.println(alumno);
                salidaWriter.write(String.format("%s%n", alumno));

                // --- 5.1 Buscar archivos .java dentro de la carpeta del alumno ---
                List<Path> archivosJava = extraerArchivosJava(alumno);
                if (archivosJava.isEmpty()) {
                    compilarWriter.write("No hay archivos Java.%n");
                    continue;
                }              
//                print(archivosJava);
                
                // --- 5.2 Compilar ---
                compilarWriter.write(String.format("Compilando %-65s -> ", alumno.getFileName()));
                if (!compilar(alumno, archivosJava)) {
                    // Si falla la compilación, lo registramos y pasamos al siguiente alumno
                    it.remove();
                    compilarWriter.write("Error.%n");
                    continue;
                }
                compilarWriter.write("Compilado.%n");

                // --- 5.3 Detectar qué archivos corresponden a cada práctica esperada ---
                String[] practicasJava = extraerPracticas(archivosJava, alumno.toString().length());
                alumnos.put(alumno, practicasJava);

                // --- 5.4 Ejecutar cada práctica detectada ---
                for (int indice = 0; indice < practicasJava.length; indice++) {
                    String clase = practicasJava[indice];

                    if (clase == null) {
                        // 💡 Si no se encontró clase que coincida con el filtro correspondiente
                        String msg = String.format("❌ No se ha encontrado clase para la práctica %d%n", indice + 1);
                        System.out.print(msg);
                        salidaWriter.write(msg);
                        continue;
                    }

                    // Mensaje de inicio de ejecución
                    String msg = String.format("▶️ Ejecutando: %s%n", clase);
                    System.out.print(msg);
                    salidaWriter.write(msg);

                    // Archivo de entrada correspondiente (entrada1.txt, entrada2.txt, etc.)
                    Path entrada = practicasDir.resolve("entrada" + (indice + 1) + ".txt");

                    // Crear y ejecutar proceso
                    EjecutarPractica ep = new EjecutarPractica(alumno, clase, entrada, salidaWriter);
                    ep.run(); // ⚙️ Ejecuta el programa del alumno
                }

                // Separador entre alumnos
                salidaWriter.write(System.lineSeparator());
                salidaWriter.flush();
                compilarWriter.flush();
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- Método auxiliar: imprime listas por consola (para depuración) ---
    private void print(Iterable<?> iterable) {
        for (Object object : iterable) {
            System.out.println(object);
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Recorre recursivamente la carpeta del alumno y devuelve todos los archivos .java encontrados.
     */
    private List<Path> extraerArchivosJava(Path alumno) {
        List<Path> archivosJava = new ArrayList<>();
        try {
            // ⚙️ Files.walk() recorre el árbol de directorios
            Files.walk(alumno)
                 .filter(Files::isRegularFile)
                 .filter(p -> p.toString().endsWith(".java"))
                 .forEach(archivosJava::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivosJava;
    }

    /**
     * Establece el directorio principal donde están las carpetas de prácticas.
     * Se puede leer desde consola o establecer manualmente (como aquí, para pruebas).
     */
    private boolean setPracticasDir() {
        System.out.print("Escribe la ruta de la carpeta que contiene las prácticas de los alumn@s: ");
//        practicasDir = Paths.get(scanner.nextLine().trim());

        // ⚙️ Ruta fija para pruebas (puedes descomentar la línea de arriba para hacerlo interactivo)
        practicasDir = Paths.get(
//                "C:\\Users\\Jota\\OneDrive - Conselleria d'Educació\\_2526\\DAW-Semi_Programacion\\Entregas\\04.ProgramaciónEstructurada"
              "C:\\Users\\Jota\\OneDrive - Conselleria d'Educació\\_2526\\DAW-Semi_Programacion\\Entregas\\03.EntradaSalida"
//        		"C:\\Users\\Jota\\OneDrive - Conselleria d'Educació\\_2526\\DAW-Semi_Programacion\\_Snippets\\src"
        );

        System.out.println();
        return Files.exists(practicasDir) && Files.isDirectory(practicasDir);
    }

    /**
     * Busca subcarpetas dentro del directorio principal.
     * Cada carpeta se considera la entrega de un alumno.
     */
    private boolean setAlumnos() {
        alumnos = new HashMap<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(practicasDir)) {
            for (Path alumno : stream) {
                if (Files.isDirectory(alumno)) {
                    alumnos.put(alumno, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return !alumnos.isEmpty(); // ⚙️ true si se han encontrado carpetas
    }

    /**
     * Determina qué archivos Java de un alumno corresponden con los nombres de práctica esperados.
     *
     * @param archivosJava lista de archivos del alumno
     * @param indiceRutaRelativa posición desde la cual extraer la ruta relativa al alumno
     */
    private String[] extraerPracticas(List<Path> archivosJava, int indiceRutaRelativa) {
        String[] resultados = new String[nombresPracticas.length]; // inicialmente todo null

        for (Path archivo : archivosJava) {
            String nombre = archivo.getFileName().toString().toLowerCase();
            for (int i = 0; i < nombresPracticas.length; i++) {
                if (resultados[i] == null) { // solo primera coincidencia
                    String[] subclaves = nombresPracticas[i].split(",");
                    for (String clave : subclaves) {
                        if (nombre.contains(clave.toLowerCase().trim())) {
                            // ⚙️ Guarda la ruta relativa del archivo dentro del directorio del alumno
                            resultados[i] = archivo.toString().substring(indiceRutaRelativa);
                            break;
                        }
                    }
                }
            }
        }
        return resultados;
    }

    /**
     * Compila todos los archivos .java de un alumno.
     *
     * @param alumno carpeta del alumno
     * @param archivosJava lista de archivos .java a compilar
     * @return true si la compilación fue exitosa
     */
    private boolean compilar(Path alumno, List<Path> archivosJava) {
        // --- Construcción del comando de compilación ---
        List<String> comando = new ArrayList<>();
        comando.add("javac"); // compilador Java
        comando.add("-cp");
        comando.add(alumno.toAbsolutePath().toString()); // classpath = carpeta del alumno
        for (Path p : archivosJava)
            comando.add(p.toString()); // añade cada archivo .java

        // --- Configuración del proceso ---
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.redirectErrorStream(true); // une stdout y stderr
        pb.directory(alumno.toFile()); // 💡 ejecuta el proceso desde la carpeta del alumno
        pb.inheritIO(); // muestra la salida del compilador en la consola actual

        // --- Ejecución del proceso ---
        try {
            Process proceso = pb.start(); // inicia el proceso "javac ..."
            int exitCode = proceso.waitFor(); // ⚙️ espera a que termine la compilación
            return exitCode == 0; // 0 = éxito
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return false; // en caso de error
    }
}
