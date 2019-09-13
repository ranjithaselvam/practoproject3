package com.atmecs.practo.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.atmecs.practo.constants.Constants;

import com.atmecs.practo.helper.Scrolling;
import com.atmecs.practo.helper.Wait;
import com.atmecs.practo.testbase.Browser;

import com.atmecs.practo.utils.ReadExcel;

public class BookingDoctorAppointment extends Browser {
	public static Properties property1 = new Properties();
	public static FileInputStream stream1;

	@DataProvider
	public Object[][] bookingDetails() throws Exception {
		Object data[][] = ReadExcel.getExcel(Constants.inputFile_path, "Sheet1");
		return data;
	}

	@Test(dataProvider = "bookingDetails")
	public void findAndBooking(String city, String specialist) throws IOException, InterruptedException {

		stream1 = new FileInputStream(Constants.identifier_path);
		property1.load(stream1);

		driver.findElement(By.xpath(property1.getProperty("loc_doctor_xpath_slt"))).click();
		driver.findElement(By.xpath(property1.getProperty("loc_city_xpath_txt"))).clear();
		Wait.implicitWait(driver);
		driver.findElement(By.xpath(property1.getProperty("loc_city_xpath_txt"))).sendKeys(city);
		driver.findElement(By.xpath(property1.getProperty("loc_chennai_xpath_slt"))).click();

		driver.findElement(By.xpath(property1.getProperty("loc_speciality_xpath_txt"))).sendKeys(specialist);

		Wait.explicitWait(driver, property1.getProperty("loc_dentist_xpath_slt"));

		String expectedDoctorName = driver.findElement(By.xpath(property1.getProperty("loc_docname_xpath_txt")))
				.getText();
		System.out.println("Expected Doctor name :" + expectedDoctorName);
		driver.findElement(By.xpath(property1.getProperty("loc_book_xpath_btn"))).click();

		Scrolling.scrollingDown();
		driver.findElement(By.xpath(property1.getProperty("loc_date_xpath_slt"))).click();
		String expectedDate = driver.findElement(By.xpath(property1.getProperty("loc_date_xpath_slt"))).getText();
		System.out.println("Expected date :" + expectedDate);

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

		driver.findElement(By.xpath(property1.getProperty("loc_changedateandtime_xpath_link"))).click();
		Wait.implicitWait(driver);

		String ChangeExpectedDoctorName = driver.findElement(By.xpath(property1.getProperty("loc_resltname_xpath_txt")))
				.getText();
		System.out.println("Reappointment Expected doctor :" + ChangeExpectedDoctorName);
		WebElement find = driver.findElement(By.xpath(property1.getProperty("loc_redate_xpath_slt")));
		find.click();
		find.click();
		String reappointmentExpectedDate = driver.findElement(By.xpath(property1.getProperty("loc_sltdate_xpath_txt")))
				.getText();
		System.out.println("Reappointment expected date :" + reappointmentExpectedDate);
		Wait.implicitWait(driver);
		driver.findElement(By.xpath(property1.getProperty("loc_retime_xpath_slt"))).click();
		String reappointmentExpectedTime = driver.findElement(By.xpath(property1.getProperty("loc_retime_xpath_slt")))
				.getText();
		System.out.println("Reappointment expected time :" + reappointmentExpectedTime);

		Wait.implicitWait(driver);
		String reappointmentActualDoctorName = driver
				.findElement(By.xpath(property1.getProperty("loc_actredocname_xpath_txt"))).getText();
		System.out.println("Reactual doctor name :" + reappointmentActualDoctorName);
		String reappointmentActualDate = driver.findElement(By.xpath(property1.getProperty("loc_actredate_xpath_txt")))
				.getText();
		System.out.println("Reappointment actual date :" + reappointmentActualDate);
		String reappointmentActualTime = driver.findElement(By.xpath(property1.getProperty("loc_actretime_xpath_txt")))
				.getText();
		System.out.println("Reappointment actual time :" + reappointmentActualTime);

		try {
			Assert.assertEquals(actualDoctorName, expectedDoctorName);
			System.out.println("true");
		} catch (AssertionError asserterror) {

			System.out.println("fail");
		}

		try {
			Assert.assertEquals(actualDate, expectedDate);
			System.out.println("true");
		} catch (AssertionError asserterror) {

			System.out.println("fail");
		}

		try {
			Assert.assertEquals(actualTime, expectedTime);
			System.out.println("true");
		} catch (AssertionError assertionError) {

			System.out.println("fail");
		}

		try {
			Assert.assertEquals(reappointmentActualDoctorName, ChangeExpectedDoctorName);
			System.out.println("true");
		} catch (AssertionError assertionError) {

			System.out.println("fail");
		}

		try {
			Assert.assertEquals(reappointmentExpectedDate, reappointmentExpectedDate);
			System.out.println("true");
		} catch (AssertionError assertionError) {

			System.out.println("fail");
		}

		try {
			Assert.assertEquals(reappointmentActualTime, reappointmentExpectedTime);
			System.out.println("true");
		} catch (AssertionError assertionError) {

			System.out.println("fail");
		}

	}

}
