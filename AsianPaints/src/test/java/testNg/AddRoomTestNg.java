package testNg;

import org.testng.annotations.Test;

import pageFactory.AsianPaintsPageFactory;
import stepDefinition.BaseClass;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AddRoomTestNg {
	public WebDriver driver;
	AsianPaintsPageFactory  asianPaints;
	InputStream reader;
	Properties properties;
	
	
  @Test
  public void AddRoomFunctionality() throws InterruptedException 
  {
	  asianPaints.paintBugetCalc();
	  asianPaints.advCalcTab();
	  asianPaints.add_room();
	  asianPaints.user_sees_the_added_room();
  }
  @BeforeTest
  public void beforeTest() throws IOException 
  {
	  	reader = new FileInputStream("E:\\EclipseOG\\Workspace\\AsianPaints\\src\\test\\resources\\Configuration\\config.properties");

		properties = new Properties();
		properties.load(reader);	
		String baseUrl=properties.getProperty("baseUrl");
		String browser = properties.getProperty("browser");
		driver = BaseClass.launchApplication(browser, baseUrl);
		asianPaints=new AsianPaintsPageFactory(driver); 
  }

  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
