package common;

public class VisibilidadMismoPaquete {
	public static void main(String[] args) {
		System.out.println("Pertenezco a la misma clase que los métodos saluda");
		Visibilidad.saludaPublic();
		Visibilidad.saludaProtected();
		Visibilidad.saludaDefault();
//		Visibilidad.saludaPrivate(); // No puedo ejecutarlo
	}
}
