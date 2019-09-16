package com.atmecs.practo.pages;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.practo.constants.Constants;
import com.atmecs.practo.helper.Scrolling;
import com.atmecs.practo.helper.Wait;
import com.atmecs.practo.testbase.PropertyReader;
import com.atmecs.practo.utils.ReadExcel;
import com.atmecs.practo.validation.WebSiteValidation;

public class FindAndBooking extends PropertyReader {
	WebDriver driver;
	 
	@DataProvider
	public Object[][] bookingDetails() throws Exception {
		Object data[][] = ReadExcel.getExcel(Constants.inputFile_path, "Sheet1");
		return data;
	}

	@Test(dataProvider = "bookingDetails")
	public void findAndBooking(String city, String specialist) throws IOException, InterruptedException {

		
		 
		

		Properties property1 = null;
		driver.findElement(By.xpath(property1.getProperty("loc_doctor_xpath_slt"))).click();
		driver.findElement(By.xpath(property1.getProperty("loc_city_xpath_txt"))).clear();
		Wait.implicitWait(driver);
		driver.findElement(By.xpath(property1.getProperty("loc_city_xpath_txt"))).sendKeys(city);
		driver.findElement(By.xpath(property1.getProperty("loc_chennai_xpath_slt"))).click();

		driver.findElement(By.xpath(property1.getProperty("loc_speciality_xpath_txt"))).sendKeys(specialist);

		
		driver.findElement(By.xpath(property1.getProperty("loc_dentist_xpath_slt"))).click();

		String expectedDoctorName = driver.findElement(By.xpath(property1.getProperty("loc_docname_xpath_txt")))
				.getText();
		System.out.println("Expected Doctor name :" + expectedDoctorName);
		driver.findElement(By.xpath(property1.getProperty("loc_book_xpath_btn"))).click();

		Scrolling.scrollingDown();
		WebElement dateSelection = driver.findElement(By.xpath(property1.getProperty("loc_datearrow_xpath_slt")));
		dateSelection.click();
		dateSelection.click();
		
	
		 String expectedDate =
				  driver.findElement(By.xpath(property1.getProperty("loc_sltdate_xpath_slt"))).
				  getText(); System.out.println("Expected date :" + expectedDate);
		Wait.implicitWait(driver);
		 
		 
		driver.findElement(By.xpath(property1.getProperty("loc_time_xpath_btn"))).click();
		
		String expectedTime = driver.findElement(By.xpath(property1.getProperty("loc_time_xpath_btn"))).getText();
		System.out.println("Expected time :" + expectedTime);

		String actualDoctorName = driver.findElement(By.xpath(property1.getProperty("loc_actdocname_xpath_txt")))
				.getText();
		System.out.println("Actual doctor name:" + actualDoctorName);
		String actualDate = driver.findElement(By.xpath(property1.getProperty("loc_actdate_xpath_txt"))).getText();
		System.out.println("Actual date:" + actualDate);
		String actualTime = driver.findElement(By.xpath(property1.getProperty("loc_acttime_xpath_txt"))).getText();
		System.out.println("Actual time:" + actualTime);

	
		WebSiteValidation.pageValidation(actualDoctorName, expectedDoctorName);
		WebSiteValidation.pageValidation(actualDate, actualDate);
		WebSiteValidation.pageValidation(actualTime, expectedTime);

		
	}		
	

}
