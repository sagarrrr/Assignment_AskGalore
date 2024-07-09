package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testbase {

	public static WebDriver driver;
	public static Properties prop;
	FileInputStream file = null;

	public testbase() {

		prop = new Properties();

		try {
			file = new FileInputStream("C:/Users/admin/eclipse-workspace/AskGaloreDigitalIndia/src/main/java/configure/properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {

		}
	}
		public static void initiliaze() {

			String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equals("firefox")) {
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutil.page_load));
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
}
