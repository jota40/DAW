import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

/**
 * EjecutarPractica
 * =================
 * Clase encargada de ejecutar una práctica Java de un alumno ya compilada.
 *
 * - Lanza un proceso separado (usando ProcessBuilder) que ejecuta la clase del alumno.
 * - Redirige la entrada desde un archivo de texto (por ejemplo, "entrada1.txt").
 * - Captura la salida estándar del proceso (y los errores, redirigidos a la misma salida).
 * - Escribe esa salida formateada en un fichero común de resultados.
 *
 * Uso típico: instanciado y ejecutado desde la clase Corrector.
 */
public class EjecutarPractica {

    // --- Atributos principales ---
    private final Path alumno;               // Carpeta raíz del alumno
    private final Path entrada;              // Archivo de entrada (por ejemplo, entrada1.txt)
    private final String clase;              // Nombre (relativo) de la clase a ejecutar
    private final BufferedWriter salidaWriter; // Donde se escribe la salida del programa del alumno

    // --- Constructor ---
    public EjecutarPractica(Path alumno, String clase, Path entrada, BufferedWriter salidaWriter) {
        this.alumno = alumno;
        this.clase = clase;
        this.entrada = entrada;
        this.salidaWriter = salidaWriter;
    }

    /**
     * Ejecuta el programa Java del alumno con la entrada y registra la salida.
     *
     * @return true si el programa terminó con código 0 (éxito)
     */
    public boolean run() {
        try {
            // ⚙️ Se prepara el comando para ejecutar la clase del alumno:
            //     java -Dfile.encoding=UTF-8 -cp [ruta alumno] [nombreClase]
            //
            // 💡 Importante: el nombre de clase debe ser relativo al classpath,
            // no una ruta. Si el alumno tiene subcarpetas, clase debe ser algo
            // como "paquete.NombreClase", no una ruta de fichero.

            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-Dfile.encoding=UTF-8",
                    "-cp", alumno.toString(),
                    alumno.toString() + clase // ⚙️ Se asume que 'clase' ya está en formato válido
            );

            pb.directory(alumno.toFile());  // Ejecuta dentro del directorio del alumno
            pb.redirectErrorStream(true);   // Mezcla stderr con stdout
            pb.redirectInput(entrada.toFile()); // Redirige stdin desde el archivo de entrada

            // ⚙️ Inicia el proceso
            Process proceso = pb.start();

            // --- Captura la salida del proceso ---
            leerSalidaProceso(proceso, salidaWriter);

            // --- Espera a que el proceso termine ---
            int exitCode = proceso.waitFor();
            return exitCode == 0; // 0 = ejecución correcta

        } catch (Exception e) {
            System.err.println("❌ Error ejecutando la práctica: " + e.getMessage());
            return false;
        }
    }

    // ============================================================================================
    // Métodos auxiliares
    // ============================================================================================

    /**
     * Envía manualmente una entrada simulada a un proceso (opcional).
     *
     * 💡 Este método no se usa actualmente, ya que el programa redirige directamente
     * la entrada desde un archivo con `pb.redirectInput()`. Sin embargo, podría servir
     * para enviar texto dinámico (por ejemplo, simular teclado).
     */
    private static void enviarEntradaSimulada(Process proceso, String entrada) throws IOException {
        // Reemplaza los literales "\n" por saltos reales
        String[] lineas = entrada.replace("\\n", "\n").split("\n");

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(proceso.getOutputStream(), StandardCharsets.UTF_8))) {

            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine(); // salto de línea real
            }
            writer.flush();
        }
        // 💡 El close() envía EOF al proceso hijo → le indica que no habrá más entrada
    }

    /**
     * Lee la salida generada por el proceso (stdout y stderr combinados)
     * y la escribe de forma formateada en el writer de salida.
     */
    private static void leerSalidaProceso(Process proceso, Writer salida) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))) {

            // Cabecera decorativa para separar cada ejecución
            salida.write(String.format(
                "┌----------------------------------------------------------------------------------------------------┐%n"
            ));

            String linea;
            while ((linea = reader.readLine()) != null) {
                // ⚙️ Intento de parsear la línea como número (parece usado para cortar largas salidas)
                int num = 0;
                try {
                    num = Integer.parseInt(linea);
                } catch (NumberFormatException ignored) {
                    // No pasa nada, la línea no es numérica
                }

                // Formato de salida:
                // - Si num < 25 → muestra línea normalmente
                // - Si num == 25 → muestra "..." (parece una marca de truncamiento)
                if (num < 25) {
                    salida.write(String.format("| %-98.98s |%n", linea));
                } else if (num == 25) {
                    salida.write(String.format("| %-98.98s |%n", "..."));
                }
            }

            // Pie decorativo
            salida.write(String.format(
                "└----------------------------------------------------------------------------------------------------┘%n"
            ));

        } catch (IOException e) {
            System.err.println("❌ Error leyendo salida del proceso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
