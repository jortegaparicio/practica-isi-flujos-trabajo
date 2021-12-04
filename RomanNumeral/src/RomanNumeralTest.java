
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.lang.Exception;

public class RomanNumeralTest {

		// Test 1
	   @Test public void OrderedNonRepeatedSymbols() 
	   {
	      String s = "MDCLXVI";
	      assertEquals("Nonzero in first element", 1666, RomanNumeral.convierte(s));
	   }
	   
	   // Test 2
	   @Test public void NonOrderedNonRepeatedSymbols_1() 
	   {
	      String s = "XIV";
	      assertEquals("Nonzero in first element", 14, RomanNumeral.convierte(s));
	   }

	   // Test 3
	   @Test public void NonOrderedNonRepeatedSymbols_2() 
	   {
		   String s = "IX";
		   assertEquals("Nonzero in first element", 9, RomanNumeral.convierte(s));
	   }
	   
	   // Test 4
	   @Test public void NonOrderedNonRepeatedSymbols_3() 
	   {
		   String s = "XLI";
		   assertEquals("Nonzero in first element", 41, RomanNumeral.convierte(s));
	   }
	   
	   // Test 5
	   @Test public void NonOrderedNonRepeatedSymbols_4() 
	   {
		   String s = "CM";
		   assertEquals("Nonzero in first element", 900, RomanNumeral.convierte(s));
	   }
	   
	   // Test 6
	   @Test public void NonOrderedNonRepeatedSymbols_5() 
	   {
		   String s = "CDI";
		   assertEquals("Nonzero in first element", 401, RomanNumeral.convierte(s));
	   }
	   
	   // Test 7
	   @Test public void NonOrderedRepeatedSymbols_1() 
	   {
		   String s = "XXIV";
		   assertEquals("Nonzero in first element", 24, RomanNumeral.convierte(s));
	   }
	   
	   // Test 8
	   @Test public void NonOrderedRepeatedSymbols_2() 
	   {
		   String s = "XIX";
		   assertEquals("Nonzero in first element", 19, RomanNumeral.convierte(s));
	   }
	   
	   // Test 9
	   @Test public void NonOrderedRepeatedSymbols_3() 
	   {
		   String s = "CDIV";
		   assertEquals("Nonzero in first element", 404, RomanNumeral.convierte(s));
	   }
	   
	   // Test 10
	   @Test public void NonOrderedRepeatedSymbols_4() 
	   {
		   String s = "DCXXV";
		   assertEquals("Nonzero in first element", 625, RomanNumeral.convierte(s));
	   }
	   
	   // Test 11
	   @Test public void NonOrderedRepeatedSymbols_5() 
	   {
		   String s = "MCM";
		   assertEquals("Nonzero in first element", 1900, RomanNumeral.convierte(s));
	   }
	   
	   // Test 12
	   @Test public void CorrectSymbolsBreakRules_1() 
	   {
		   String s = "IIII";
		   
		   try {
			   assertEquals(4, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 13
	   @Test public void CorrectSymbolsBreakRules_2() 
	   {
		   String s = "XXXX";
		   
		   try {
			   assertEquals("Nonzero in first element", 40, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 14
	   @Test public void CorrectSymbolsBreakRules_3() 
	   {
		   String s = "CCCCXXI";
		   
		   try {
			   assertEquals(421, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 15
	   @Test public void CorrectSymbolsBreakRules_4() 
	   {
		   String s = "CMDC";
		   
		   try {
			   assertEquals(1500, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 16
	   @Test public void CorrectSymbolsBreakRules_5() 
	   {
		   String s = "VVII";
		   try {
			   assertEquals(12, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 17
	   @Test public void CorrectSymbolsBreakRules_6() 
	   {
		   String s = "LLV";
		   try {
			   assertEquals(105, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 18
	   @Test public void CorrectSymbolsBreakRules_7() 
	   {
		   String s = "DDDIII";
		   try {
			   assertEquals(1503, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 19
	   @Test public void CorrectSymbolsBreakRules_8() 
	   {
		   String s = "IM";
		   try {
			   assertEquals(999, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 20
	   @Test public void CorrectSymbolsBreakRules_9() 
	   {
		   String s = "XD";
		   try {
			   assertEquals(490, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 21
	   @Test public void CorrectSymbolsBreakRules_10() 
	   {
		   String s = "LC";
		   try {
			   assertEquals(12, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 22
	   @Test public void CorrectSymbolsBreakRules_11() 
	   {
		   String s = "VD";
		   try {
			   assertEquals(495, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 23
	   @Test public void CorrectSymbolsBreakRules_12() 
	   {
		   String s = "LXL";
		   try {
			   assertEquals(90, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 24
	   @Test public void CorrectSymbolsBreakRules_13() 
	   {
		   String s = "CCM";
		   try {
			   assertEquals(1000, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 25
	   @Test public void CorrectSymbolsBreakRules_14() 
	   {
		   String s = "XCD";
		   try {
			   assertEquals(410, RomanNumeral.convierte(s));
			   fail("Roman number rules broken, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 26
	   @Test public void IncorrectSymbols_1() 
	   {
		   String s = "AUYB";
		   try {
			   assertNotEquals(700, RomanNumeral.convierte(s));
			   fail("Roman Number does not exists, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
	   
	   // Test 27
	   @Test public void IncorrectSymbols_2() 
	   {
		   String s = "VOP";
		   try {
			   assertNotEquals(800, RomanNumeral.convierte(s));
			   fail("Roman Number does not exists, expected Exception");
		   } catch (Exception IllegalArgumentException) {}
	   }
}
