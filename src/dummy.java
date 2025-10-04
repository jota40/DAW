class dummy {

	public static void main(String[] args) {
		String a = "Hola";
		String b = a.toUpperCase(); // ¿Cambia a?
		String c = new String("Hola");
		System.out.println(a); // "Hola" (no cambia)
		System.out.println(b); // "HOLA"
		System.out.println(a == c); // no
		System.out.println(a.equals(c)); // si
	}
}
