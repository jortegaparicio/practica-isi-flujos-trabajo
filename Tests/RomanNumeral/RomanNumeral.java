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
     * Number from type 5 are not allowed to subtract
     * @param s
     * @param pos
     */
    private static void firstRule(String s, int pos){
    	if (s.charAt(pos) == 'V' || s.charAt(pos) == 'L' || s.charAt(pos) == 'D' ) { 
    		throw new IllegalArgumentException();
    	}
    }
    
    /**
     * If a number from type one is subtracting, it can appear at the right position of a bigger number
     * @param s
     * @param pos
     */
    private static void secondRule(String s, int pos) {
	    Map<Character, Integer> romanM = getRomaMap();
        int currentValue = romanM.get(s.charAt(pos));

    	if (s.charAt(pos) == 'I' || s.charAt(pos) == 'X' || s.charAt(pos) == 'C' || s.charAt(pos) == 'M' ) { 
    		String sub = s.substring(pos+1);
    		if(sub.length()>1) {
    			if(currentValue <= romanM.get(sub.charAt(1))) {
    				throw new IllegalArgumentException();
    			}
    		}
    	}
    }
    
    /**
     * If a number from type one appears subtracting, it is only permitted that its repetition is at the right side and not adyacent
     * to the subtracting symbol
     * @param s
     * @param pos
     */
    private static void thirdRule(String s, int pos) {
	    Map<Character, Integer> romanM = getRomaMap();
        int currentValue = romanM.get(s.charAt(pos));
    	if (s.charAt(pos) == 'I' || s.charAt(pos) == 'X' || s.charAt(pos) == 'C' || s.charAt(pos) == 'M' ) {
    		if(pos>=1) {
    			if(currentValue == romanM.get(s.charAt(pos - 1))) {
    				throw new IllegalArgumentException();
    			}
    		}
    	}
    }
    
    /**
     * Subtraction of a number from type one is only permitted over the first bigger number from type one or five
     * @param s
     * @param pos
     */
    private static void fourthRule(String s, int pos) {
    	if (s.charAt(pos) == 'I') {
    		if (s.charAt(pos+1) != 'V' && s.charAt(pos+1) != 'X') {
    			throw new IllegalArgumentException();
    		}
    	}
    	if (s.charAt(pos) == 'X') {
    		if (s.charAt(pos+1) != 'L' && s.charAt(pos+1) != 'C') {
    			throw new IllegalArgumentException();
    		}
    	}
    	if (s.charAt(pos) == 'C') {
    		if (s.charAt(pos+1) != 'D' && s.charAt(pos+1) != 'M') {
    			throw new IllegalArgumentException();
    		}
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
	            if (romanM.containsKey(s.charAt(i+1))) {
	            	nextValue = romanM.get(s.charAt(i + 1));
	            }else {
	            	throw new IllegalArgumentException();
	            }
	            if(currentValue < nextValue) {
	            	firstRule(s, i);
	            	secondRule(s, i);
	            	thirdRule(s, i);
	            	fourthRule(s, i);	            	
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
	    
	    if (s == "") {
	    	throw new IllegalArgumentException();
	    }
	    
	    s = s.toUpperCase();
	    
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
	private static Map<Character,Integer> getRomaMap(){
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
	    System.out.println(RomanNumeral.convierte("XII"));
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


