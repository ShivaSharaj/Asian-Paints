package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.When;

public class AsianPaintsPageFactory {

	public WebDriver driver;
	@CacheLookup

	@FindBy(xpath="//div[@class='columnCrosslinks__body js-columnCrosslinksBody']/a[contains(@href,'paint-budget-calculator')]") WebElement PaintBudgetCalc;
	@FindBy(xpath="//button[text()='I understand']") WebElement Iagree;
	@FindBy(xpath="//ul/li/a[text()='Advanced calculator']") WebElement AdCalcTab;
	@FindBy(xpath="//div[@class='tabs-btn--wrap']/a[@class='editRoomName']") WebElement PenIcon;
	@FindBy(name="ROOM_NAME") WebElement RoomName;
	@FindBy(xpath="//span[@class='spriteIcon-Aprevamp addBorderedIcon']") WebElement AddRoom;
	@FindBy(xpath="//div[@class='header__top-utility-links--right track_header_findstore find_contractor']/a[contains(@href,'contractor-landing-page.html')]/span[@class='iconTextLinks__text']") WebElement FindAConTab;
	@FindBy(xpath="//input[@placeholder='City or Pincode']") WebElement Pincode;
	@FindBy(xpath="//button[text()='Search']") WebElement PincodeSearch;
	@FindBy(xpath="//div[text()='Enter a valid 6 digit Zip Code']") WebElement ErrorMsg;
	@FindBy(xpath="//div[@class='tabs-btn--wrap']/a[@class='editRoomName']/span[@class='spriteIcon-Aprevamp  confirmEditIcon']") WebElement ConfirmEdition;
	@FindBy(xpath="//div[@class='block']/div[@class='form-global form-text-input floating-label form-global--normal form-text-input--normal']/input[@readonly='readonly']") WebElement AddedRoom;
	@FindBy(xpath="//div[@id='room-tabs']/div/div/div/div/input[@name='ROOM_NAME']") WebElement EditedRoomName;
	@FindBy(xpath="//h2[@class='palleteTitle centerAlign']") WebElement AsianPaintsTrainedContractors;
	
	
	
	public AsianPaintsPageFactory(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void paintBugetCalc() throws InterruptedException{
		PaintBudgetCalc.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView(true);", PaintBudgetCalc);

		if (Iagree.isDisplayed()) 
		{
			Iagree.click();
		}
		js.executeScript("arguments[0].click();", PaintBudgetCalc);
		Thread.sleep(5000);
		System.out.println("User clicks on Paint Budget Calculator");
	}

	public void advCalcTab()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",  AdCalcTab);

		if (Iagree.isDisplayed()) {
			Iagree.click();
		}
		boolean status = AdCalcTab.isDisplayed();
		System.out.println(status);

		if (status) {

			js.executeScript("arguments[0].click();", AdCalcTab);
		}

		System.out.println("User clicks on Advanced Calculator tab.");

	}

	public void click_Pen_And_Rename(String room) throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView(true);", PenIcon);

		js.executeScript("arguments[0].click();", PenIcon);
		System.out.println("User clicks on Pen icon.");

		RoomName.clear();
		RoomName.sendKeys(room);
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-250)");
		ConfirmEdition.click();
	}
	
	public void user_sees_the_renamed_room()
	{
		System.out.println("Is Room field displayed? " + EditedRoomName.isDisplayed());

		if (EditedRoomName.isDisplayed())
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String changedValue =  js.executeScript("var value; value = arguments[0].value; return value;", EditedRoomName).toString();
			System.out.println("Room name after renaming is: " + changedValue);
		}
	}

	public void add_room()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",AddRoom);

		js.executeScript("arguments[0].click();",AddRoom);
		System.out.println("User clicks on Add room button");
	}
	
	public void user_sees_the_added_room()
	{
		System.out.println("Is Added Room displayed? " + AddedRoom.isDisplayed());

		if (AddedRoom.isDisplayed())
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String changedValue =  js.executeScript("var value; value = arguments[0].value; return value;", AddedRoom).toString();
			System.out.println("New Room added is: " + changedValue);
		}
		
	}

	public void FindContractor()
	{
		FindAConTab.click();
		System.out.println("User clicks on Find a contractor tab");
	}

	public void validPincode(String pincode)
	{
		Pincode.sendKeys(pincode);
		System.out.println("User entered valid pincode");
	}

	public void searchPin()
	{
		PincodeSearch.click();
		System.out.println("User clicks on search button ");
	}

	public void contractorDetail()
	{
		System.out.println("Contractor detail was found");
		String actualText = AsianPaintsTrainedContractors.getText();
		String expectedText= "Asian Paints Trained Contractors";
		Assert.assertEquals(actualText, expectedText);
		System.out.println(actualText +" were seen");
	}

	public void invalidPincode(String pincode)
	{
		Pincode.sendKeys(pincode);
		System.out.println("User entered invalid pincode");
	}

	public void conDetailNotVisible()
	{
		String actualMsg =ErrorMsg.getText();
		System.out.println("Error message is displayed as "+ actualMsg);
		String expectedMsg = "Enter a valid 6 digit Zip Code";
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	
}