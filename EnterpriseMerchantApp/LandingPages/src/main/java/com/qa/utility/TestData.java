package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class TestData extends TestBase {

	public TestData() {
		PageFactory.initElements(driver, this);
	}

	public static String TataPower(int sheetNo, int row, int column) throws IOException {
		File src = new File(
				"D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\TestDataSheets\\TataPower_O2O.xlsx");

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}

	public static String UatTataPower(int sheetNo, int row, int column) throws IOException {
		File src = new File(System.getProperty("user.dir") + File.separator + "TestDataSheets" + File.separator
				+ "UATTataPowerMerchant_O2O2.xlsx");

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}

	public static String generic(int sheetNo, int row, int column) throws IOException {
		File src = new File(
				"D:\\Automation Projects\\EnterpriseMerchantApp\\LandingPages\\TestDataSheets\\MerchantGenericPage.xlsx");

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}

	public static String trynow(int sheetNo, int row, int column) throws IOException {

		File src = new File(
				"D:\\Yogesh\\Automation Projects\\EnterpriseMerchantApp\\LandingPages\\TestDataSheets\\TryNowPage.xlsx");

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}

	public static String MerchantGenerciPageNew(int sheetNo, int row, int column) throws IOException {

		String FilePath = System.getProperty("user.dir") + File.separator + "TestDataSheets" + File.separator
				+ "MerchantGenericPageNew.xlsx";
		File src = new File(FilePath);

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}

	public static String AUBank(int sheetNo, int row, int column) throws IOException {

		String FilePath = System.getProperty("user.dir") + File.separator + "TestDataSheets" + File.separator
				+ "UATAUBank.xlsx";
		File src = new File(FilePath);

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}

	public static String SMFG(int sheetNo, int row, int column) throws IOException {

		String FilePath = System.getProperty("user.dir") + File.separator + "TestDataSheets" + File.separator
				+ "SMFGHomeFinance.xlsx";
		File src = new File(FilePath);

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}
	
	public static String SMFGCredit(int sheetNo, int row, int column) throws IOException {

		String FilePath = System.getProperty("user.dir") + File.separator + "TestDataSheets" + File.separator
				+ "SMFGCreditFinance2.xlsx";
		File src = new File(FilePath);

		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheetAt(sheetNo);

		DataFormatter df = new DataFormatter();

		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));

		return stringvalue;
	}
}
