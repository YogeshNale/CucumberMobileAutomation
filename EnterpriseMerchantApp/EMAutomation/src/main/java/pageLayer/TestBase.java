package pageLayer;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;


	public static void main(String[] args) throws Exception {

		for (int i = 0; i <13; i++) {

			try {
				//Thread.sleep(2000);
				DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.setBrowserName("chrome");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				chromeOptions.addArguments("--incognito");
				// WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver(chromeOptions);
				driver.get("https://uatenterprise.merchant.localdomain:9316/login");
			driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				WebElement merchantID=driver.findElement(By.xpath("//input[@id='m_id']"));
				merchantID.click();
				merchantID.sendKeys(TestData.MerchantDetails(0, i+1, 0));
				WebElement merchantNumber=driver.findElement(By.xpath("//input[@id='f_id']"));
				merchantNumber.click();
				merchantNumber.sendKeys(TestData.MerchantDetails(0, i+1, 1));
				WebElement nextButton=driver.findElement(By.xpath("//button[text()='Next']"));
				nextButton.click();
				System.out.println("userlogin "+i);
				

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}
	
	
	public void enterLoginDetails() throws InterruptedException {
		
		
		
	}

}
