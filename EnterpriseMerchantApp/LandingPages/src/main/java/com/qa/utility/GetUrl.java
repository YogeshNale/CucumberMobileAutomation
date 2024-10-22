package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.qa.testBase.TestBase;

public class GetUrl extends TestBase {

	
	public static  String getURL(String URL) throws IOException {
		Properties prop = new Properties();
		String url= System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"qa"+File.separator+"utility"+File.separator+"global.Properties";
		FileInputStream fis = new FileInputStream(url);
	    prop.load(fis);
	    return prop.getProperty(URL);
	}
	
	
}
