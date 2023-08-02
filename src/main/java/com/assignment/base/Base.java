package com.assignment.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.assignment.utilities.Utilities;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Utilities utility;
	
	
@BeforeSuite
	public static void setup() throws IOException {
		
		prop=new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\VisualCrossingProject\\properties\\config.properties");
		prop.load(ip);

		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			
		
			 System.setProperty("webdriver.firefox.driver", "C:\\firefoxdriver_win32\\firefoxdriver.exe");
		     driver=new FirefoxDriver();
	    }
	  
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get(prop.getProperty("url"));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_Load_Timeout));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicit_Timeout));
	    
	    
	
	}
}
