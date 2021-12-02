package embotelladora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmbotelladoraTest {

	/*
	 * CASO BASE
	 * Se puede embotellar con una combinación de botellas grandes y pequeñas
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
			fail("No se esperaba excepción");
		} catch (Exception e2) {
			fail("No se esperaba excepción");
		}
	}
	
	/*
	 * Se puede embotellar con una combinación de botellas grandes y pequeñas, pero
	 * el numero de litros no es válido
	 */
	@Test
	void testLitrosInvalidos() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, 0);
			fail("Se espera una excepción");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * Se puede embotellar con una combinación de botellas grandes y pequeñas, y 
	 * sólo con botellas grandes
	 */
	@Test
	void testCombinacionYBotellasGrandes() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 6, 30);
			assertEquals(0, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepción");
		} catch (Exception e2) {
			fail("No se esperaba excepción");
		}
	}
	
	/*
	 * Se puede embotellar con una combinación de botellas grandes y pequeñas, y 
	 * sólo con botellas pequeñas
	 */
	@Test
	void testCombinacionYBotellasPequeñas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 2, 10);
			assertEquals(0, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepción");
		} catch (Exception e2) {
			fail("No se esperaba excepción");
		}
	}
	
	/*
	 * Se puede embotellar con una combinación de botellas grandes y pequeñas, pero
	 * el numero de litros es negativo
	 */
	@Test
	void testLitrosNegativos() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, -10);
			fail("Se espera una excepción");
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
			fail("Se espera una excepción");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * El número de botellas que tenemos no es válido
	 */
	@Test
	void testBotellasNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(-1, -1, 10);
			fail("Se espera una excepción");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * El número de botellas grandes que tenemos no es válido
	 */
	@Test
	void testBotellasGrandesNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, -1, 10);
			fail("Se espera una excepción");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
	/*
	 * El número de botellas pequeñas que tenemos no es válido
	 */
	@Test
	void testBotellasPequeñasNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(-1, 2, 10);
			fail("Se espera una excepción");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}
	
}
