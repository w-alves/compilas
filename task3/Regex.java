
public class Regex {
	public static boolean is_Digit(String token) {
		if (token != null) {
			return token.matches("[0-9]+");
		}
		return false;
	}
	
	public static boolean is_Operator(String token) {
		if (token != null) {
			return token.matches("\\*|\\-|\\+|\\/]");
		}
		return false;
	}
}