

public class Embotelladora {

	// @param pequenas: número de botellas en almacén de 1L
	//		  grandes : número de botellas en almacén de 5L
	//        total: número total de litros que hay que embotellar
	//
	// @return número de botellas pequenas necesarias para embotellar el total de lı́quido, teniendo
	//         en cuenta que hay que minimizar el número de botellas pequenas: primero se rellenan las grandes
	//
	// @throws NoSolution si no es posible embotellar todo el lı́quido
	public int calculaBotellasPequenas(int pequenas, int grandes, int total) throws NoSolution {

		int resto = 0;

		if (total <= 0 || pequenas < 0 || grandes < 0) {
			throw new NoSolution("Entries must be positive integers or zero");
		}
		
		if (total > pequenas + grandes*5) {
			throw new NoSolution("Not enough bottles to pack the liquid");
		}

		if (total < grandes*5) {
			return 0;
		}

		if (grandes > 0) {
			resto = total%(grandes*5);
		} else {
			resto = total;
		}
		
		return (int) Math.ceil(resto);
	}

	public static void main(String[] args) {
		
		int result = 0;
		Embotelladora embot = new Embotelladora();
		try {
			result = embot.calculaBotellasPequenas(20,4,20);
		    System.out.println("El numero de botellas pequeñas necesarias es: " + result);
		} catch (NoSolution e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
