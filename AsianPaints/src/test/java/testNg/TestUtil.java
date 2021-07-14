package testNg;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;






import pageFactory.AsianPaintsPageFactory;
import stepDefinition.BaseClass;

import org.testng.annotations.DataProvider;



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


public class TestUtil 
{
	
	 
	public static ArrayList<Object[]>getDataFromExcel(String SheetName) throws IOException
	{
		InputStream reader = new FileInputStream("E:\\EclipseOG\\Workspace\\AsianPaints\\src\\test\\resources\\Configuration\\config.properties");
		
		Properties properties = new Properties();
		properties.load(reader);
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		String pincod= null;
		properties.load(reader);
		String filePath= properties.getProperty("filePath");
		String fileName= properties.getProperty("fileName");
		String sheetName= properties.getProperty("Sheet1"); 
		File file = new File(filePath + "\\" + fileName);
		System.out.println(filePath);
		FileInputStream inp = new FileInputStream(file);

		FileOutputStream out = null;
		Workbook wBook = null;

		String fileExtn = fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtn);

		if(fileExtn.equals(".xlsx"))
		{
			
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
			pincod= row.getCell(0).getStringCellValue();
			System.out.println(pincod);
			System.out.println("*******************************************************************");
			
			Object obj[]={pincod};
			myData.add(obj);

			// System.out.println(pincod ); 
		}
		wBook.close();
		inp.close();
		return myData;
	}
	
	
	public static ArrayList<Object[]>getExcelData(String sheetName) throws IOException
	{
		InputStream reader = new FileInputStream("E:\\EclipseOG\\Workspace\\AsianPaints\\src\\test\\resources\\Configuration\\config.properties");
		
		Properties properties = new Properties();
		properties.load(reader);
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		String pincod= null;
		properties.load(reader);
		String filePath= properties.getProperty("filePath");
		String fileName= properties.getProperty("fileName");
		//String sheetName= properties.getProperty("Sheet1"); 
		File file = new File(filePath + "\\" + fileName);
		System.out.println(filePath);
		FileInputStream inp = new FileInputStream(file);

		FileOutputStream out = null;
		Workbook wBook = null;

		String fileExtn = fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtn);

		if(fileExtn.equals(".xlsx"))
		{
			
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
			pincod= row.getCell(0).getStringCellValue();
			System.out.println(pincod);
			System.out.println("*******************************************************************");
			
			Object obj[]={pincod};
			myData.add(obj);

			// System.out.println(pincod ); 
		}
		wBook.close();
		inp.close();
		return myData;
	}
	
	public static int getRowCount(String sheetName) throws IOException
	{
InputStream reader = new FileInputStream("E:\\EclipseOG\\Workspace\\AsianPaints\\src\\test\\resources\\Configuration\\config.properties");
		
		Properties properties = new Properties();
		properties.load(reader);
		properties.load(reader);
		String filePath= properties.getProperty("filePath");
		String fileName= properties.getProperty("fileName");
		//String sheetName= properties.getProperty("Sheet1"); 
		File file = new File(filePath + "\\" + fileName);
		System.out.println(filePath);
		FileInputStream inp = new FileInputStream(file);

		FileOutputStream out = null;
		Workbook wBook = null;

		String fileExtn = fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtn);

		if(fileExtn.equals(".xlsx"))
		{
			
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
		return rows;
	}
}

