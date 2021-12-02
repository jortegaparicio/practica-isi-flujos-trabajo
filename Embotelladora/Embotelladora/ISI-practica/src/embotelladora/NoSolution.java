package embotelladora;

class NoSolution extends Exception {
	String msg;

	NoSolution(String str) {
		msg = str;
	}

	public String toString() {
		return ("NoSolution: " + msg);
	}
}
