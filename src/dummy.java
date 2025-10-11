

import java.lang.Math;

class dummy {
	public static void main(String[] args) {
		System.out.println(Math.log(1)/Math.log(2));
		for ( int i = 0 ; i <256 ;i++) {
			System.out.println(i + ": " + Math.ceil(Math.log(i+1)/Math.log(2)));
			
		}
		
		dummy.saluda();
	}
	
	protected static void saluda() {
		System.out.print("Hola");
	}
}
