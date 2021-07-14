package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver launchApplication(String browser,String baseUrl) {
		WebDriver driver; 
		

		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		}
		
		
		return null;

	}

}
