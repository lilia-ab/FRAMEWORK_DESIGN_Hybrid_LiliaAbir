package com.Utilities;

import java.util.Date;

public class Utilitie {
	
		
	public static final int ImplicitWait=10;
	public static final int PAGELOADTIMEWAIT = 10;
	public static final int SCRIPTTIMEWAIT = 10;

	
	public static String emailDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "hihello" + timeStamp + "@gmail.com";
		
		
	
}


	
	}
