package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testfunction {
	
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	 public static boolean  isDigit(String s)
	 {
	  Pattern p = Pattern.compile("\\d+\\.?\\d*");
	  Matcher m = p.matcher(s);
	  return m.matches();
	 }
	 
	public static void main(String[] args) {
		System.out.println("------");
		System.out.println(isNumeric("0.1"));
		System.out.println(isDigit("0.2"));

	}

}
