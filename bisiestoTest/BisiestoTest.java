import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class BisiestosTest

	private int year;
	
	@Test public void base_TTT() 
   {
		//Multiplo de 4, 100 y 400
		
		year = 1600;
		assertTrue(Bisiestos.esBisiesto(year));

   }
   
	@Test public void base_TFF() 
   {
		//Multiplo de 4 pero no de 100 y 400
		
		year = 24;
		assertTrue(Bisiestos.esBisiesto(year));

   }
   
   @Test  public void test_TTF()
   {
		//Multiplo de 4 y 100 pero no de 400
		
		year = 2500;
		assertFalse(Bisiestos.esBisiesto(year));
   }
   
   @Test public void test_limiteCero() 
   {
		//Año 0, caso límite
		
		year = 0;
		assertTrue(Bisiestos.esBisiesto(year));

   }
	
   @Test public void test_TTI()
   {
	    //Número invalido (negativo) multiplo de 4 y 100 pero no de 400
	    
		year = -100;
		try {
			Bisiestos.esBisiesto(year);
		}catch (IllegalArgumentException e) {
			return;
		}
		fail ("IllegalArgument Exception expected");
   }
   
   @Test public void test_TIT()
   {
	    //Número invalido (negativo) multiplo de 4 y 400
	    
		year = -400;
		try {
			Bisiestos.esBisiesto(year);
		}catch (IllegalArgumentException e) {
			return;
		}
		fail ("IllegalArgument Exception expected");
   }

	
	
