package com.qa.TestBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.qa.pageLayer.AgentLandingPage;
import com.qa.pageLayer.AjemerO2OLandingPage;
import com.qa.pageLayer.BillAmount;
import com.qa.pageLayer.CommonBiller;
import com.qa.pageLayer.CommonBillerCommonElement;
import com.qa.pageLayer.CommonBillerPagelayer;
import com.qa.pageLayer.CommonElement;
import com.qa.pageLayer.HoneyPot;
import com.qa.pageLayer.JharkhandO2OLandingePage;
import com.qa.pageLayer.KashtBhanjanTrust;
import com.qa.pageLayer.RefLandingePage;
import com.qa.pageLayer.TataMerchantO2OPage;
import com.qa.pageLayer.TataPowerLandingPage;
import com.qa.pageLayer.TryLandingepage;

import com.qa.utility.ScrollDown;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.qa.utility.Listeners.class)
public class TestBase {
	public static WebDriver driver;
	public static CommonElement common;
	public static TataPowerLandingPage tata;
	public static ScrollDown scroll;
	public static KashtBhanjanTrust sarangpur;
	public static AgentLandingPage agent;
	public static TataMerchantO2OPage merchant;
	public static BillAmount amount;
	public static JharkhandO2OLandingePage jharkhand;
	public static TryLandingepage tryPage;
	public static RefLandingePage ref;
	public static HoneyPot honey;
	public static AjemerO2OLandingPage ajmer;
	public static CommonBillerCommonElement commonE;
	public static CommonBiller commonB;
	public static CommonBillerPagelayer com;
	
	

	protected static Logger log;
	@Parameters({"Br"})
	
	
	@BeforeTest
	public void setUp(String br) throws Exception {
		
		// MyScreenRecorder.startRecording("setup");
		 log = Logger.getLogger("");
		PropertyConfigurator.configure("Log4j.Properties");
		if (br.equalsIgnoreCase("Chrome")) {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setBrowserName("chrome");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
		     //WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			log.info("chrome browser launch");

		} 
		else if (br.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} 
		else if (br.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		else {
			System.out.println("Please Provide Correct Browser Name");
		}

		// driver.get("https://www.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		common = new CommonElement();
		scroll = new ScrollDown();
		tata = new TataPowerLandingPage();
		sarangpur = new KashtBhanjanTrust();
		agent =new AgentLandingPage();
		merchant = new TataMerchantO2OPage();
		amount = new BillAmount();
		jharkhand = new JharkhandO2OLandingePage();
		tryPage =new TryLandingepage();
		ref = new RefLandingePage();
		honey =new HoneyPot();
		ajmer = new AjemerO2OLandingPage();
		commonE= new CommonBillerCommonElement();
		commonB=new CommonBiller();
		com = new CommonBillerPagelayer();

	}



}
