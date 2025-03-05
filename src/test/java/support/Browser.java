package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static WebDriver launch() {   
		Properties properties = new Properties();
		try {
			 //load a properties file from class path, inside static method
			properties.load(new FileInputStream("app.properties"));

			System.out.println(properties.getProperty("app.browser"));

			String browser = properties.getProperty("app.browser"); 
			if (browser.equals("firefox")) {
				return WebDriverManager.firefoxdriver().create();
			} else if (browser.equals("chrome")) {
				return WebDriverManager.chromedriver().create();
			} else if (browser.equals("msie")) {
				return WebDriverManager.iedriver().create();
			} else {
				throw new RuntimeException("Unrecognized system property 'browser': " + browser);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return WebDriverManager.chromedriver().create();
	}
}
