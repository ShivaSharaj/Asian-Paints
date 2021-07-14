package testNg;


import org.testng.annotations.Test;

import pageFactory.AsianPaintsPageFactory;
import stepDefinition.BaseClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ContractorBasedOnPinTestNg {
	public WebDriver driver;
	AsianPaintsPageFactory  asianPaints;
	InputStream reader;
	Properties properties;
	@DataProvider
	public Iterator<Object[]> retrievingValidPin() throws IOException
	{
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel("validPincode");
		return testData.iterator();
	}
	@Test(priority=1,dataProvider="retrievingValidPin")
	public void validPincode(String pincod) throws IOException 
	{
		
		
			asianPaints.FindContractor();
			asianPaints.validPincode(pincod);
			asianPaints.searchPin();
			asianPaints.contractorDetail();
			System.out.println("*******************************************************************");	

	}
	@DataProvider
	public Iterator<Object[]> retrievingInvalidPin() throws IOException
	{
		ArrayList<Object[]> testData = TestUtil.getExcelData("invalidPincode");
		return testData.iterator();
	}


	

	@Test(priority=2,dataProvider="retrievingInvalidPin")
	public void invalidPincode(String pincod) throws IOException, InterruptedException 
	{
		
			asianPaints.FindContractor();
				
			
			asianPaints.invalidPincode(pincod);
			asianPaints.searchPin();
			asianPaints.conDetailNotVisible();
			System.out.println("*******************************************************************");      
			

	}


	

	@BeforeTest
	public void launchApplication() throws IOException 
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
