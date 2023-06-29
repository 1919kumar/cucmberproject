package utiles;

import java.util.Date;

public class CommonUtils {
	
	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "sai"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
