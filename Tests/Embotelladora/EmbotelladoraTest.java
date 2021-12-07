import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.lang.Exception;

public class EmbotelladoraTest {

	/*
	 * CASO BASE
	 * Se puede embotellar con una combinacion de botellas grandes y pequenas
	 */
	@Test
	public void testCombinacion() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, 50);
			assertEquals(10, res);
			res = embotelladora.calculaBotellasPequenas(100, 8, 50);
			assertEquals(10, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepcion");
		} catch (Exception e2) {
			fail("No se esperaba excepcion");
		}
	}

	/*
	 * Se puede embotellar con una combinacion de botellas grandes y pequenas, pero
	 * el numero de litros no es valido
	 */
	@Test
	public void testLitrosInvalidos() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, 0);
			fail("Se espera una excepcion");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}

	/*
	 * Se puede embotellar con una combinacion de botellas grandes y pequenas, y
	 * solo con botellas grandes
	 */
	@Test
	public void testCombinacionYBotellasGrandes() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 6, 30);
			assertEquals(0, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepcion");
		} catch (Exception e2) {
			fail("No se esperaba excepcion");
		}
	}

	/*
	 * Se puede embotellar con una combinacion de botellas grandes y pequenas, y
	 * solo con botellas pequenas
	 */
	@Test
	public void testCombinacionYBotellasPequenas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 2, 10);
			assertEquals(0, res);
		} catch (NoSolution e1) {
			fail("No se esperaba excepcion");
		} catch (Exception e2) {
			fail("No se esperaba excepcion");
		}
	}

	/*
	 * Se puede embotellar con una combinacion de botellas grandes y pequenas, pero
	 * el numero de litros es negativo
	 */
	@Test
	public void testLitrosNegativos() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, 8, -10);
			fail("Se espera una excepcion");
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
	public void testSinBotellas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(4, 9, 50);
			fail("Se espera una excepcion");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}

	/*
	 * El numero de botellas que tenemos no es valido
	 */
	@Test
	public void testBotellasNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(-1, -1, 10);
			fail("Se espera una excepcion");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}

	/*
	 * El numero de botellas grandes que tenemos no es valido
	 */
	@Test
	public void testBotellasGrandesNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(10, -1, 10);
			fail("Se espera una excepcion");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}

	/*
	 * El numero de botellas pequenas que tenemos no es valido
	 */
	@Test
	public void testBotellasPequenasNegativas() {
		Embotelladora embotelladora = new Embotelladora();
		try {
			int res = embotelladora.calculaBotellasPequenas(-1, 2, 10);
			fail("Se espera una excepcion");
		} catch (NoSolution e1) {
			assertTrue(true);
		} catch(Exception e2) {
			assertTrue(true);
		}
	}

}
