package com.qa.utility;

import static org.testng.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImage extends TestBase {

	public CompareImage() {
		PageFactory.initElements(driver, this);
	}

	public static void compareImage(String logoPath, WebElement logoLocation, String billerName) throws IOException {

		try {

			// Capture the screenshot of the logo element from web page

			File logoImageScreenshot = logoLocation.getScreenshotAs(OutputType.FILE);

			// Save the screenshot to a file

			// FileUtils.copyFile(logoImageScreenshot, new File("D:\\Automation
			// Projects\\EnterpriseMerchantApp\\O2OLandingPages\\logos" ));

			// System.out.println("Logo screenshot captured");

			// Specify the expected image file path

			String expectedImagePath = logoPath;

			// Create a File object for the expected image
			File expectedImageFile = new File(expectedImagePath);

			// Verify that the expected image file exists
			if (!expectedImageFile.exists()) {
				fail();
				throw new IOException("Expected image file not found: " + expectedImagePath);
			}

			// Read the expected image and the actual image
			BufferedImage expectedImage = ImageIO.read(expectedImageFile);
			BufferedImage actualImage = ImageIO.read(logoImageScreenshot);

			// Compare the images using ImageDiffer
			ImageDiffer imgDiff = new ImageDiffer();
			ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

			// Check if there is a difference between the images
			if (diff.hasDiff()) {
				log.info(billerName + "logo image not Matched ");
				Date currentdate = new Date();
				String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "_");
                  
				String path = "D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\logoMisMatchedScreenShot" +billerName +screenshotfilename +".jpg";
				FileUtils.copyFile(logoImageScreenshot, new File(path));
				fail();
			} else {
				log.info(billerName + "Logo Image Matched");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
