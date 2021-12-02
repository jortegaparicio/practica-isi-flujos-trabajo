package embotelladora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmbotelladoraTest {

	/*
	 * CASO BASE
	 * Se puede embotellar con una combinaci�n de botellas grandes y peque�as
	 */
	@Test
	void testCombinacion() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, 50);
			assertEquals(10, res);
			res = embotelladora.calculaBotellasPequenas(100, 8, 50);
			assertEquals(10, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepci�n");
		} catch (Exception e2) {
			fail("No se esperaba excepci�n");
		}
	}
	
	/*
	 * Se puede embotellar con una combinaci�n de botellas grandes y peque�as, pero
	 * el numero de litros no es v�lido
	 */
	@Test
	void testLitrosInvalidos() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, 0);
			fail("Se espera una excepci�n");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * Se puede embotellar con una combinaci�n de botellas grandes y peque�as, y 
	 * s�lo con botellas grandes
	 */
	@Test
	void testCombinacionYBotellasGrandes() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 6, 30);
			assertEquals(0, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepci�n");
		} catch (Exception e2) {
			fail("No se esperaba excepci�n");
		}
	}
	
	/*
	 * Se puede embotellar con una combinaci�n de botellas grandes y peque�as, y 
	 * s�lo con botellas peque�as
	 */
	@Test
	void testCombinacionYBotellasPeque�as() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 2, 10);
			assertEquals(0, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepci�n");
		} catch (Exception e2) {
			fail("No se esperaba excepci�n");
		}
	}
	
	/*
	 * Se puede embotellar con una combinaci�n de botellas grandes y peque�as, pero
	 * el numero de litros es negativo
	 */
	@Test
	void testLitrosNegativos() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, -10);
			fail("Se espera una excepci�n");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * No tenemos suficientes botellas
	 */
	@Test
	void testSinBotellas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(4, 9, 50);
			fail("Se espera una excepci�n");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * El n�mero de botellas que tenemos no es v�lido
	 */
	@Test
	void testBotellasNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(-1, -1, 10);
			fail("Se espera una excepci�n");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * El n�mero de botellas grandes que tenemos no es v�lido
	 */
	@Test
	void testBotellasGrandesNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, -1, 10);
			fail("Se espera una excepci�n");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * El n�mero de botellas peque�as que tenemos no es v�lido
	 */
	@Test
	void testBotellasPeque�asNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(-1, 2, 10);
			fail("Se espera una excepci�n");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
}
