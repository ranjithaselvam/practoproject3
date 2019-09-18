package com.atmecs.practo.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.atmecs.practo.testbase.Browser;


public class ToClear extends Browser {
	public static void text(String xpath)
	{
	WebElement toClear = driver.findElement(By.xpath(xpath));
	toClear.sendKeys(Keys.CONTROL + "a");
	toClear.sendKeys(Keys.DELETE);

}
}