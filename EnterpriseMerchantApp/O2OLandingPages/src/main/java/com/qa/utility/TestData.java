package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class TestData extends TestBase {

	public TestData() {
		PageFactory.initElements( driver,this);
	}
	public static String TataPower (int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\TataPower_O2O.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	
	
	public static String sarangpur (int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\KashtBhanjanTrust.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	
	public static String agent (int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\AgentPage.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	
	public static String tataMerchant (int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\TataPowerMerchant_O2O.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	
	
	public static String  billAmount (int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\BillAmounts.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	public static void writeBillAmount(int sheetNo ,int row,int column,String CellValue  ) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\BillAmounts.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh1 = wb.getSheetAt(sheetNo);
		
		FileOutputStream fos=new FileOutputStream(src);
		
		sh1.createRow(row).createCell(column).setCellValue(CellValue);
		wb.write(fos);
}
	public static String  Jharkhand(int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\Jharkhand_O2O.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	
	public static String  tryPage(int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\TryPage.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	public static String  ref(int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\RefPage.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	
	public static String  honey(int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\HoneyPot.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	// ajmer O2O landinge page Test Data Method 
	public static String  ajmer(int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\Ajmer_O2O.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
	
	// ajmer O2O landinge page Test Data Method 
		public static String  commonBiller(int sheetNo ,int   row,int column) throws IOException {
			File src= new
			File("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\CommonBiller.xlsx");
			
			FileInputStream file=new FileInputStream(src);
			
			XSSFWorkbook book = new XSSFWorkbook(file);
			
			XSSFSheet sheet = book.getSheetAt(sheetNo);
			
			DataFormatter df = new DataFormatter();
			
			String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
			
			return stringvalue;
		}
}