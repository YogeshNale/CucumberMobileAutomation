package com.qa.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.pageLayer.AUBankLoanReapyment;
import com.qa.pageLayer.CommonElements;
import com.qa.pageLayer.MerchantGenericPage;
import com.qa.pageLayer.MerchantGenericPageNew;
import com.qa.pageLayer.SMFGCreditFinace;
import com.qa.pageLayer.SMFGHomeFinance;
import com.qa.pageLayer.TataMerchantPage;
import com.qa.pageLayer.TryNowPage;
import com.qa.pageLayer.UATTataMerchantPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static CommonElements common;
	public static TataMerchantPage Merchant;
	public static MerchantGenericPage generic;
	public static TryNowPage trynow;
	public static UATTataMerchantPage uatMerchant;
	public static MerchantGenericPageNew merchantNew;
	public static AUBankLoanReapyment AULoan;
	public static SMFGHomeFinance SMFG;
	public static SMFGCreditFinace SMFGCredit;

	public static WebDriver driver;
	protected static Logger log;

	public TestBase() {
		PageFactory.initElements(driver, this);
	}

	@Parameters("Br")
	@BeforeTest
	public void setUp(String br) throws Exception {
		log = Logger.getLogger("");
		PropertyConfigurator.configure("Log4j.Properties");
		if (br.equalsIgnoreCase("Chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			log.info("chrome browser launch");

		} else if (br.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (br.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			System.out.println("Please Provide Correct Browser Name");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		common = new CommonElements();
		Merchant = new TataMerchantPage();
		generic = new MerchantGenericPage();
		trynow = new TryNowPage();
		uatMerchant = new UATTataMerchantPage();
		merchantNew=new MerchantGenericPageNew();
        AULoan = new AUBankLoanReapyment();
        SMFG = new SMFGHomeFinance();
        SMFGCredit = new SMFGCreditFinace();
	}

}
