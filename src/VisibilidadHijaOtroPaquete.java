import common.Visibilidad;

public class VisibilidadHijaOtroPaquete extends Visibilidad {
	public static void main(String[] args) {
		System.out.println("Pertenezco a un paquete distinto al que pertenece la clase que tiene los métodos saluda, pero soy hija suya");
		Visibilidad.saludaPublic();
		Visibilidad.saludaProtected();
//		Visibilidad.saludaDefault(); // No puedo ejecutarlo
//		Visibilidad.saludaPrivate(); // No puedo ejecutarlo
	}
}
