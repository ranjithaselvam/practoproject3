package com.atmecs.practo.helper;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.practo.constants.PageGetText;
import com.atmecs.practo.report.LoggerReportInformation;
import com.atmecs.practo.testbase.Browser;
import com.atmecs.practo.testbase.propertyReader;
import com.atmecs.practo.validation.WebSiteValidation;

public class ChangingDateAndTime extends Browser {
	public static void reappointment() throws IOException
	{
		LoggerReportInformation.logReporter("changing date and time...");

		MouseOver.click(propertyReader.properties("loc_changedateandtime_xpath_link"));
		String ChangedExpectedDoctorName = PageGetText.text(propertyReader.properties("loc_resltname_xpath_txt"),
				"Changed expected doctor name");

		WebElement reDateSelection = driver.findElement(By.xpath(propertyReader.properties("loc_redate_xpath_slt")));
		reDateSelection.click();
		reDateSelection.click();

		reDateSelection.click();

		String reappointmentExpectedDate = PageGetText.text(propertyReader.properties("loc_resltdate_xpath_txt"),
				"Reappointment expected date");

		Wait.implicitWait(driver);

		MouseOver.click(propertyReader.properties("loc_retime_xpath_slt"));
		String reappointmentExpectedTime = PageGetText.text(propertyReader.properties("loc_retime_xpath_slt"),
				"Reappointment expected time");

		String reappointmentActualDoctorName = PageGetText.text(propertyReader.properties("loc_actredocname_xpath_txt"),
				"Reappointment actual doctor name");

		String reappointmentActualDate = PageGetText.text(propertyReader.properties("loc_actredate_xpath_txt"),
				"Reappointment actual date");

		String reappointmentActualTime = PageGetText.text(propertyReader.properties("loc_actretime_xpath_txt"),
				"Reappointment time");

		LoggerReportInformation.logReporter("reverify expected doctor details are same as expected");
		WebSiteValidation.pageValidation(reappointmentActualDoctorName, ChangedExpectedDoctorName);
		WebSiteValidation.pageValidation(reappointmentActualDate, reappointmentExpectedDate);
		WebSiteValidation.pageValidation(reappointmentActualTime, reappointmentExpectedTime);
	}

}
