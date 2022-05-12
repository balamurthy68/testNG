package Util;

import java.util.regex.*;

public class RegularExpressions {
	
	// Patternmatcher
	public static boolean patternMatch(String exampleString, Pattern p) {

		
		System.out.println("Example string is " + exampleString + " to match against pattern:"+ p.toString());
		
		Matcher m = p.matcher(exampleString);

		boolean b = m.matches();

		return b;

	}
}
