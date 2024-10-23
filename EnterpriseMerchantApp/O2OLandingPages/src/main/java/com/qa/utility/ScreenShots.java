package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.TestBase.TestBase;

public class ScreenShots extends TestBase {

	public static void takeScreenShotWhenFail() {
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "_");
		try {
			String path = "C:\\Enterprise Application FrameWork\\FrameWork_For_Pract\\ScreenShots Folder"
					+ screenshotfilename +".png";
			File ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File f = new File(path);

			FileHandler.copy(ts, f);
		}

		catch (IOException e) {

			e.printStackTrace();
			System.out.println("Exception While Screenshot");
		}
	}

}
