package pageLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;

public class TestData extends TestBase {

	
	public TestData() {
		PageFactory.initElements( driver,this);
	}
	public static String MerchantDetails(int sheetNo ,int row,int column) throws IOException {
		File src= new
		File("D:\\Automation Projects\\EnterpriseMerchantApp\\EMAutomation\\src\\main\\java\\pageLayer\\TestData.xlsx");
		
		FileInputStream file=new FileInputStream(src);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		
		DataFormatter df = new DataFormatter();
		
		String stringvalue = df.formatCellValue(sheet.getRow(row).getCell(column));
		
		return stringvalue;
	}
}
