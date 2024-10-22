package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification request;
	public RequestSpecification requestBody() throws IOException {
		if(request==null) {
			PrintStream log = new PrintStream(new FileOutputStream("Logs.txt"));
		 request = new RequestSpecBuilder().setBaseUri(getBaseURL("baseURL"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		 return request;
		}
		return request;
	}
	
	public String getBaseURL(String baseURL) throws IOException {
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream("D:\\Automation Projects\\EnterpriseMerchantApp\\RestThresholdAPI\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(baseURL);
	}
}
