package factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driverfactory {

	static WebDriver driver=null;
	public static WebDriver initializeBrowser(String browsername) {
		
		if(browsername.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(browsername.equals("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
