
@SuppressWarnings("serial")
class NoSolution extends Exception{
	
	String msg;
	
	public NoSolution(String str) {
		msg = str;
	}
	
	public String toString(){
		return ("NoSolution: " + msg) ;
	}

}
