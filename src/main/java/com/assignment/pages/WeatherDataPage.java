package com.assignment.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.base.Base;

public class WeatherDataPage extends Base {

	public WeatherDataPage() throws IOException {
		PageFactory.initElements(driver, this);
			
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//button[text()='Accept all cookies']")
	public WebElement acceptCookiesBtn;

	@FindBy(xpath="//a[@class='nav-link text-nowrap' and text()='Weather Data']")
	WebElement weatherDataLink;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='Enter a location']")
	WebElement enterLocation;
	
	@FindBy(xpath="//button[@type='submit' and text()='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//button[text()='F']")
	public WebElement farenheit;
	
	@FindBy(xpath="//div[text()='Max temp']/following-sibling::div")
	public WebElement maxTemp;
	
	@FindBy(xpath="//div[text()='Min temp']/following-sibling::div")
	public WebElement minTemp;


	public void acceptcookies() {
		acceptCookiesBtn.click();
	   	
	}

	public void selectWeatherData() {
		weatherDataLink.click();
	}
	
	public void enterCity(String city) {
		enterLocation.sendKeys(city);
	}
	
	public void search() {
		searchBtn.click();
	}
	
	public void farenheitOption()
	{
		farenheit.click();
	}
	
	public String getMaxTemp()
	{
		return maxTemp.getText();
	}
	
	public String getMinTemp()
	{
		return minTemp.getText();
	}
	

}
