package com.atmecs.practo.testscript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import com.atmecs.practo.constants.Constants;
import com.atmecs.practo.constants.PageGetText;
import com.atmecs.practo.helper.ChangingDateAndTime;
import com.atmecs.practo.helper.Enter;
import com.atmecs.practo.helper.MouseOver;
import com.atmecs.practo.helper.Scrolling;
import com.atmecs.practo.helper.ToClear;
import com.atmecs.practo.helper.Wait;
import com.atmecs.practo.report.LoggerReportInformation;
import com.atmecs.practo.testbase.Browser;
import com.atmecs.practo.testbase.propertyReader;
import com.atmecs.practo.utils.ReadExcel;
import com.atmecs.practo.validation.WebSiteValidation;
import com.relevantcodes.extentreports.LogStatus;

public class BookingDoctorAppointment extends Browser {
    @DataProvider
	public Object[][] bookingDetails() throws Exception {
		Object data[][] = ReadExcel.getExcel(Constants.inputFile_path, "Sheet1");
		return data;
		}
   @Test(dataProvider = "bookingDetails")
	public void findAndBooking(String city, String specialist) throws IOException, InterruptedException {
        Wait.implicitWait(driver);
		LoggerReportInformation.logReporter("Booking doctor appointment scenario started...");
        MouseOver.click(propertyReader.properties("loc_doctor_xpath_slt"));
		ToClear.text(propertyReader.properties("loc_city_xpath_txt"));
        LoggerReportInformation.logReporter("select city");
        Enter.value(propertyReader.properties("loc_city_xpath_txt"), city);
        MouseOver.click(propertyReader.properties("loc_chennai_xpath_slt"));
		logger.log(LogStatus.INFO, "location selected");
        LoggerReportInformation.logReporter("select specialist");
        MouseOver.click(propertyReader.properties("loc_dentist_xpath_slt"));
        String expectedDoctorName = PageGetText.text(propertyReader.properties("loc_docname_xpath_txt"),"Expected doctor name");
	    MouseOver.click(propertyReader.properties("loc_book_xpath_btn"));
		Scrolling.scrollingDown();
		WebElement dateSelection = driver.findElement(By.xpath(propertyReader.properties("loc_datearrow_xpath_slt")));
		dateSelection.click();
		dateSelection.click();
		LoggerReportInformation.logReporter("select date and time");
        String expectedDate = PageGetText.text(propertyReader.properties("loc_sltdate_xpath_slt"), "Expected date");
        MouseOver.click(propertyReader.properties("loc_time_xpath_btn"));
        String expectedTime = PageGetText.text(propertyReader.properties("loc_time_xpath_btn"), "Expected Time");
        String actualDoctorName = PageGetText.text(propertyReader.properties("loc_actdocname_xpath_txt"),
				"Actual doctor name");
        String actualDate = PageGetText.text(propertyReader.properties("loc_actdate_xpath_txt"), "Actual date");
        String actualTime = PageGetText.text(propertyReader.properties("loc_acttime_xpath_txt"), "Actual time");
        LoggerReportInformation.logReporter("verify  doctor details are same as expected ");
        WebSiteValidation.pageValidation(actualDoctorName, expectedDoctorName);
		WebSiteValidation.pageValidation(actualDate, expectedDate);
		WebSiteValidation.pageValidation(actualTime, expectedTime);
		ChangingDateAndTime.reappointment();
		LoggerReportInformation.logReporter("====pass=======");

	}

}
