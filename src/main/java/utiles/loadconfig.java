package utiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class loadconfig {

	public Properties initporprties() {
		Properties prop = new Properties();
		File profile = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\config\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(profile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;
		
	}
}
