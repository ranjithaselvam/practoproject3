package com.atmecs.practo.helper;

import org.openqa.selenium.JavascriptExecutor;

import com.atmecs.practo.testbase.Browser;

public class Scrolling extends Browser{
	public static void scrollingDown()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)","");
	}

}
