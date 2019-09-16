package com.atmecs.practo.screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ScreenShot  {

	public static WebDriver driver;
	@AfterMethod
	public void tearDown(ITestResult result) {
	if (ITestResult.SUCCESS == result.getStatus()) {
	try {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("/screenshot/" + result.getName() + ".png")); //this will save the screenshot in screenshot folder with failed "methodname.png"
	System.out.println("Screenshot taken");
	} catch (Exception e) {
	System.out.println("Exception while taking screenshot " + e.getMessage());
	}
	}
	}


}
