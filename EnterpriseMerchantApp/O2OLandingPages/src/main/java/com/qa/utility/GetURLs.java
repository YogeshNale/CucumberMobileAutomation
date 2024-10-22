package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetURLs {

	
	public static  String pageURL(String URL) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Automation Projects\\EnterpriseMerchantApp\\O2OLandingPages\\src\\main\\java\\com\\qa\\utility\\global.properties");
	    prop.load(fis);
	    return prop.getProperty(URL);
	}
}
