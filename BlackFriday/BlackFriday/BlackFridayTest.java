import static org.junit.Assert.*;
import org.junit.*;
import java.util.Calendar;

public class BlackFridayTest {
	Calendar cal = Calendar.getInstance();
	@Test
	public void TTT() {
		/*
		 * 
		 * Caso base, es el día del black friday y se pone un precio, descuento y fecha correctos
		 * 
		 */
		DescuentoBlackFriday descuentoblackfriday =new DescuentoBlackFriday();
		cal.set(2021,10,29);
	
		double precionuevo = descuentoblackfriday.precioFinal(100.0,80.0,cal);
		assertEquals(20.0,precionuevo,0.1);
		
	}
	
	@Test
	public void ITT() {
		/*
		 * 
		 * Caso precio original <0 siendo el día del black friday
		 * 
		 */
		DescuentoBlackFriday descuentoblackfriday = new DescuentoBlackFriday();
		cal.set(2021,10,29);
	
		try {
			double precionuevo = descuentoblackfriday.precioFinal(-100.0,80.0,cal);
		}catch (IllegalArgumentException e) {
				return;
		}
		fail("IllegalArgument Exception expected");		
	}
	@Test
	public void TFT() {
		/*
		 * 
		 * Caso fecha y precio correctos, pero no hay descuento(es decir, descuento 0)
		 * 
		 */
		DescuentoBlackFriday descuentoblackfriday =new DescuentoBlackFriday();
		cal.set(2021,10,29);
	
		double precionuevo = descuentoblackfriday.precioFinal(100.0,0.0,cal);
		assertEquals(100.0,precionuevo,0.1);
		
	}
	@Test
	public void TIT() {
		/*
		 * 
		 * Caso descuento <0 siendo el día del black friday
		 * 
		 */
		DescuentoBlackFriday descuentoblackfriday = new DescuentoBlackFriday();
		cal.set(2021,10,29);
	
		try {
			double precionuevo = descuentoblackfriday.precioFinal(100.0,-80.0,cal);
		}catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgument Exception expected");		
	}
	
	@Test
	public void TTI() {
		/*
		 * 
		 * Caso fecha diferente del black friday, debería devolver el precio original
		 * 
		 */
		DescuentoBlackFriday descuentoblackfriday =new DescuentoBlackFriday();
		cal.set(2021,10,28);

		double precionuevo = descuentoblackfriday.precioFinal(100.0,20.0,cal);
		assertEquals(100.0,precionuevo,0.1);
	
	}

}
