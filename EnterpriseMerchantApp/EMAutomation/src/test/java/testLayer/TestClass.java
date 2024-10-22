package testLayer;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageLayer.JavaTodo;

public class TestClass extends JavaTodo {

	public TestClass() {
		PageFactory.initElements(driver, this);
	}

	@Test
	public void testCase1() throws Exception {
		System.out.println("Browser launched ");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");

		// Execute JavaScript to open a new tab
		/*
		 * ((JavascriptExecutor)driver).executeScript("window.open();");
		 * ((JavascriptExecutor)driver).executeScript("window.open();");
		 * 
		 * Set<String> IDS= driver.getWindowHandles(); Iterator<String>
		 * it=IDS.iterator(); it.next(); String ID=it.next();
		 * driver.switchTo().window(ID);
		 */
		System.out.println("testing completed ");

	}

}
