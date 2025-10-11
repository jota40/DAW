package common;
public class Visibilidad {
	public static void main(String[] args) {
		System.out.println("Pertenezco a la misma clase que los métodos saluda");
		saludaPublic();
		saludaProtected();
		saludaDefault();
		saludaPrivate();
	}

	public static void saludaPublic() {
		System.out.println("Hola, soy un método público");
	}
	protected static void saludaProtected() {
		System.out.println("Hola, soy un método protected");
	}
	static void saludaDefault() {
		System.out.println("Hola, soy un método default");
	}
	private static void saludaPrivate() {
		System.out.println("Hola, soy un método privado");
	}
}
