import java.lang.IllegalArgumentException;
import java.util.Calendar;


public class DescuentoBlackFriday {
	// @param precioOriginal es el precio de un producto marcado en la etiqueta
	// porcentajeDescuento es el descuento a aplicar expresado como un porcentaje que ha de ser >= 0
	// @return el precio final teniendo en cuenta que si es black friday (29 de noviembre) se aplica
	// un descuento de porcentajeDescuento
	// @throws IllegalArgumentException si precioOriginal es negativo o porcentajeDescuento es negativo

	public double precioFinal
	(double precioOriginal, double porcentajeDescuento, Calendar fecha) throws IllegalArgumentException{
		 //Comprobamos si el porcentaje de descuento es válido
		 if (porcentajeDescuento > 100 || porcentajeDescuento < 0) {
			 throw new IllegalArgumentException("DescuentoBlackFriday.precioFinal");
		 }
		 
		 //Comprobamos si el precio original es válido
		 if (precioOriginal < 0) {
			 throw new IllegalArgumentException("DescuentoBlackFriday.precioFinal");
		 }

		 //Month en Calendar empieza con January en 0!!
		 if ((fecha.get(Calendar.MONTH) == 10) && (fecha.get(Calendar.DAY_OF_MONTH) == 29)) {
			 
			 double precioNuevo = precioOriginal*(1-(porcentajeDescuento/100.00));			 
			 return precioNuevo;
			 
		 } else {
			 
			 return precioOriginal;
			 
		 }
	}
}
