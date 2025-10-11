import common.Visibilidad;

public class VisibilidadOtroPaquete {
	public static void main(String[] args) {
		System.out.println("Pertenezco a un paquete distinto al que pertenece la clase que tiene los métodos saluda");
		Visibilidad.saludaPublic();
//		Visibilidad.saludaProtected(); // No puedo ejecutarlo
//		Visibilidad.saludaDefault(); // No puedo ejecutarlo
//		Visibilidad.saludaPrivate(); // No puedo ejecutarlo
	}
}
