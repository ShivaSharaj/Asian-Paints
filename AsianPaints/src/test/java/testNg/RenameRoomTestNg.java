package testNg;

import org.testng.annotations.Test;

import pageFactory.AsianPaintsPageFactory;
import stepDefinition.BaseClass;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class RenameRoomTestNg 
{
	public WebDriver driver;
	AsianPaintsPageFactory  asianPaints;
	InputStream reader;
	Properties properties;
	
  @Test
  public void RenamingRoomFunctionality() throws InterruptedException, IOException 
  {
	  String room = null;
	  asianPaints.paintBugetCalc();
	  asianPaints.advCalcTab(); 
	  properties.load(reader);
      String filePath= properties.getProperty("filePath");
      String fileName= properties.getProperty("fileName");
      String sheetName= properties.getProperty("Sheet3"); 
      File file = new File(filePath + "\\" + fileName);
      System.out.println(filePath);
      FileInputStream inp = new FileInputStream(file);
     
      FileOutputStream out = null;
      Workbook wBook = null;
     
      String fileExtn = fileName.substring(fileName.indexOf("."));
      System.out.println(fileExtn);
     
      if(fileExtn.equals(".xlsx"))
      {
      	System.out.println("Hello");
      	wBook = new XSSFWorkbook(inp);
          System.out.println(wBook);
      }
      else
      {
          wBook = new HSSFWorkbook(inp);
      }
     
    //  Sheet sheet = wBook.getSheet(sheetName);
      Sheet sheet =wBook.getSheet(sheetName);
      System.out.println(sheet);
      int rows = sheet.getLastRowNum() - sheet.getFirstRowNum();
      int cols = sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();
     
      System.out.println("No. of rows = " + rows + " and No. of columns = " + cols);
      
      for (int i = 1; i <= rows; i++)
      {
          Row row = sheet.getRow(i);
          room= row.getCell(0).getStringCellValue();
          asianPaints.click_Pen_And_Rename(room);
      }
      
      asianPaints.user_sees_the_renamed_room();
	  
	  
	  
	  
	  
	  ///////////////////////////
	  /*asianPaints.paintBugetCalc();
	  asianPaints.advCalcTab(); 
	  asianPaints.click_Pen_And_Rename(Room);
	  asianPaints.user_sees_the_renamed_room();*/
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
