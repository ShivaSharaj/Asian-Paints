package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.AsianPaintsPageFactory;

public class AsianSteps {

	/*String baseUrl = "https://www.asianpaints.com/";
	WebDriver driver;
	ChromeOptions options;
	JavascriptExecutor js;

	asianPaintsPageFactory asianPaints;*/

	AsianPaintsPageFactory asianPaints;
	WebDriver driver;
	ChromeOptions options;
	JavascriptExecutor js;

	@Before
	public void setUp() throws IOException 
	{
		InputStream reader = new FileInputStream("E:\\EclipseOG\\Workspace\\AsianPaints\\src\\test\\resources\\Configuration\\config.properties");

		Properties properties = new Properties();
		properties.load(reader);	
		String baseUrl=properties.getProperty("baseUrl");
		String browser = properties.getProperty("browser");
		driver = BaseClass.launchApplication(browser, baseUrl);
		asianPaints=new AsianPaintsPageFactory(driver);
	}

	@Given("the user in on asian paints home page")
	public void the_user_in_on_asian_paints_home_page() {

		options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		/*System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(baseUrl);*/

	}

	@When("the user clicks on Paint Budget Calculator link")
	public void the_user_clicks_on_Paint_Budget_Calculator_link() throws InterruptedException 
	{
		asianPaints.paintBugetCalc();

	}

	@When("the user clicks on Advanced Calculator Tab")
	public void the_user_clicks_on_Advanced_Calculator_Tab() 
	{
		asianPaints.advCalcTab();
	}



	@Then("the user is able to see the renamed room")
	public void the_user_is_able_to_see_the_renamed_room() 
	{
		asianPaints.user_sees_the_renamed_room();
		System.out.println("Renamed room is seen.");
	}

	@When("the user clicks on the pen icon to rename room as {string}")
	public void the_user_clicks_on_the_pen_icon_to_rename_room_as(String room) throws InterruptedException   
	{
		asianPaints.click_Pen_And_Rename(room);
	}

	//Adding Room

	@When("the user clicks on Add room button")
	public void the_user_clicks_on_Add_room_button() 
	{
		asianPaints.add_room();    
	}

	@Then("an extra room should be added")
	public void an_extra_room_should_be_added() 
	{
		asianPaints.user_sees_the_added_room();
		System.out.println("An extra room is added.");  
	}

	
	//Finding Contractor

	@When("the user clicks on Find A Contractor tab")
	public void the_user_clicks_on_Find_A_Contractor_tab() 
	{
		asianPaints.FindContractor();
	}

	@When("the user enters the valid pincode as {string}")
	public void the_user_enters_the_valid_pincode_as(String pincode) 
	{
		asianPaints.validPincode(pincode);
	}

	@When("the user clicks on Search button")
	public void the_user_clicks_on_Search_button() 
	{
		asianPaints.searchPin();
	}

	@Then("the contractor details should be visible")
	public void the_contractor_details_should_be_visible() 
	{
		asianPaints.contractorDetail();
	}

	@When("the user enters the invalid pincode as {string}")
	public void the_user_enters_the_invalid_pincode_as(String pincode) 
	{
		asianPaints.invalidPincode(pincode);
	}

	@Then("the contractor details should not be visible")
	public void the_contractor_details_should_not_be_visible() 
	{
		asianPaints.conDetailNotVisible();
	}
	
	@After
	@Then("user closes the browser")
	public void user_closes_the_browser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();

	}


}
