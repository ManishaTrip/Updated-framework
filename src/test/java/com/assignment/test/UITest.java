package com.assignment.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.base.Base;
import com.assignment.pages.WeatherDataPage;

public class UITest extends Base {
	
	Logger log = Logger.getLogger(UITest.class);
	WeatherDataPage page;
	String maxtemp;
	String mintemp;

	public UITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
@BeforeMethod

  public void initialization() throws IOException {
	
//	Base.setup();
	
	page=new WeatherDataPage();
	page.acceptcookies();
	page.selectWeatherData();
	page.enterCity("Pune");
	page.search();

}

@Test
public void testWeatherDataInCelsius() throws InterruptedException {
	
	
    // Verify max temp
	Thread.sleep(2000);
	maxtemp= page.getMaxTemp();
	mintemp=page.getMinTemp();
    if(maxtemp.contains("℃")) {
    	log.info("Maximum temperature displayed in Celsius is:" + maxtemp);
    }
    
    // Verify min temp
    if(mintemp.contains("℃")) {
    	log.info("Minimum temperature displayed in Celsius is:" + mintemp );
    }
    
    
}
@Test
public void testWeatherDataInFarenheit() throws InterruptedException {
	
	
	Thread.sleep(2000);
	page.farenheitOption();
	
    // Verify max temp
	Thread.sleep(2000);
	maxtemp= page.getMaxTemp();
	mintemp=page.getMinTemp();
	
    if(maxtemp.contains("℉")) {
    	log.info("Maximum temperature displayed in Farenheit is:" + maxtemp);
    }
    
    // Verify min temp
    if(mintemp.contains("℉")) {
    	log.info("Minimum temperature displayed in Farenheit is:" + mintemp );
    }
    
    
}




@AfterMethod

public void tearDown() {
	
	driver.quit();
		
}

}
