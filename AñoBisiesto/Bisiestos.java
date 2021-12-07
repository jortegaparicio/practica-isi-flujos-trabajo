import java.lang.IllegalArgumentException;

public class Bisiestos {
	// @param a un n ́umero entero positivo
	// @return true si a es un a~no bisiesto
	// false en caso contrario.
	// @throws IllegalArgumentException si a no es un par ́ametro v ́alido.
	public static boolean esBisiesto(int a) throws IllegalArgumentException {
		if(a==0) {
			return true;
		}
		
		if (a<0) {
			 throw new IllegalArgumentException("Negative year");
		}
		
		if((a%4 == 0) && ((a % 100 != 0) || (a % 400 == 0))) {
			return true;
		}else {
			return false;
		}
	}

}
