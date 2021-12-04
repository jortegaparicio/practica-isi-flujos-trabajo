import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RomanNumeral {
	
	/**
	 * This method verify that the string given doesn't have characters that 
	 * are repeated more times than Roman Numbers' rule says
	 * @param s
	 */
    private static void verifyRepetedChar(String s) {
    	
        Pattern pat = Pattern.compile(".*I{4,}.*");
        Matcher mat = pat.matcher(s);                                                                           
        if (mat.matches()) {
        	throw new IllegalArgumentException();
        }
        
        pat = Pattern.compile("(.*V.*){2,}");
        mat = pat.matcher(s);                                                                           
        if (mat.matches()) {
        	throw new IllegalArgumentException();
        }
        
        pat = Pattern.compile(".*X{4,}.*");
        mat = pat.matcher(s);                                                                           
        if (mat.matches()) {
        	throw new IllegalArgumentException();
        }
        
        pat = Pattern.compile("(.*L.*){2,}");
        mat = pat.matcher(s);                                                                           
        if (mat.matches()) {
        	throw new IllegalArgumentException();
        }
        
        pat = Pattern.compile(".*C{4,}.*");
        mat = pat.matcher(s);                                                                           
        if (mat.matches()) {
        	throw new IllegalArgumentException();
        }
        
        pat = Pattern.compile("(.*D.*){2,}");
        mat = pat.matcher(s);                                                                           
        if (mat.matches()) {
        	throw new IllegalArgumentException();
        }
    	
        pat = Pattern.compile(".*M{4,}.*");
        mat = pat.matcher(s);                                                                           
        if (mat.matches()) {
        	throw new IllegalArgumentException();
        }
    }
	
    /**
     * This method verify Roman Numbers' rules
     * @param s
     */
	private static void verifyRomanNumeral(String s) {
	    Map<Character, Integer> romanM = getRomaMap();
		int currentValue = 0;
		int nextValue = 0;

        verifyRepetedChar(s);
	    
		for(int i = 0; i < s.length() - 1; i++) {
	        if (romanM.containsKey(s.charAt(i))) {
	            currentValue = romanM.get(s.charAt(i));
	            nextValue = romanM.get(s.charAt(i + 1));
	            if(currentValue < nextValue) {
	            	// Verificamos condiciones de resta
	            	
	            	// Los numeros de tipo 5 no pueden ir restando
	            	if (s.charAt(i) == 'V' || s.charAt(i) == 'L' || s.charAt(i) == 'D' ) { 
	            		throw new IllegalArgumentException();
	            	}
	            	
	            	// Si un simbolo de tipo 1 aparece restando, sólo puede aparecer a su derecha un unico simbolo mayor
	            	if (s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C' || s.charAt(i) == 'M' ) { 
	            		String sub = s.substring(i+1); // Dividimos la cadena a partir del siguiente elemento
	            		if(sub.length()>1) {
	            			if(currentValue <= romanM.get(sub.charAt(1))) {
	            				throw new IllegalArgumentException();
	            			}
	            		}
	            	}
	            	
	            	//Si un símbolo de tipo 1 que aparece restando se repite, sólo se permite que su repetición esté colocada 
	            	// a su derecha y que no sea adyacente al símbolo que resta.
	            	if (s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C' || s.charAt(i) == 'M' ) {
	            		if(i>=1) {
	            			if(currentValue == romanM.get(s.charAt(i - 1))) {
	            				throw new IllegalArgumentException();
	            			}
	            		}
	            	}
	            	
	            	// Sólo se admite la resta de un símbolo de tipo 1 sobre el inmediato mayor de tipo 1 o de tipo 5
	            	if (s.charAt(i) == 'I') {
	            		if (s.charAt(i+1) != 'V' && s.charAt(i+1) != 'X') {
	            			throw new IllegalArgumentException();
	            		}
	            	}
	            	if (s.charAt(i) == 'X') {
	            		if (s.charAt(i+1) != 'L' && s.charAt(i+1) != 'C') {
	            			throw new IllegalArgumentException();
	            		}
	            	}
	            	if (s.charAt(i) == 'C') {
	            		if (s.charAt(i+1) != 'D' && s.charAt(i+1) != 'M') {
	            			throw new IllegalArgumentException();
	            		}
	            	}
	            	
	            }
	        }else {
	        	throw new IllegalArgumentException();
	        }		
		}
	
	}

	/**
	 * This method calculates the Roman Numbers into decimals numbers
	 * @param s String that contains the Roman Number evaluated on this method
	 * @return Decimal number obtained from the Roman Number given
	 * @throws IllegalArgumentException
	 */
	public static int convierte(String s) throws IllegalArgumentException {
	    int result = 0;
	    int length = s.length();
	    Map<Character, Integer> romanM = getRomaMap();
	    
	    verifyRomanNumeral(s);
	
	    for(int i = 0; i < length - 1; i++) {
	        if (romanM.containsKey(s.charAt(i))) {
	            int currentValue = romanM.get(s.charAt(i));
	            if(currentValue < romanM.get(s.charAt(i + 1))) {
	                    result -= currentValue;
	            }else {
	                    result += currentValue;
	            }
	        }else {
	        	throw new IllegalArgumentException();
	        }
	    }
	
	    return result + romanM.get(s.charAt(length-1));
	}

	/**
	 * This method creates a map with the Roman Numbers and its values
	 */
	public static Map<Character,Integer> getRomaMap(){
	    Map<Character,Integer> roman = new HashMap<Character, Integer>();
	    roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
	    return roman;
	}

	public static void main(String[] args) {
	    System.out.println(RomanNumeral.convierte("III"));
	    System.out.println(RomanNumeral.convierte("V"));
	    System.out.println(RomanNumeral.convierte("XLV"));
	    System.out.println(RomanNumeral.convierte("CDXCV"));
	    System.out.println(RomanNumeral.convierte("CDL"));
	    System.out.println(RomanNumeral.convierte("IV"));
	    System.out.println(RomanNumeral.convierte("IX"));
	    System.out.println(RomanNumeral.convierte("XL"));
	    System.out.println(RomanNumeral.convierte("XC"));
	    System.out.println(RomanNumeral.convierte("CD"));
	    System.out.println(RomanNumeral.convierte("CM"));
	    System.out.println(RomanNumeral.convierte("XIX"));
	    System.out.println(RomanNumeral.convierte("CXC"));
	    System.out.println(RomanNumeral.convierte("MCM"));
	    System.out.println(RomanNumeral.convierte("XV"));
	    System.out.println(RomanNumeral.convierte("CL"));
	    System.out.println(RomanNumeral.convierte("MD")); 
	}
	
}

