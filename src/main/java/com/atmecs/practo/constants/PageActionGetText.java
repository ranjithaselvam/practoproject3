package com.atmecs.practo.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActionGetText {
	public static String text;
	public static void getText(WebDriver driver,final String xpath)
	{
		WebElement element=driver.findElement(By.xpath(xpath));
		text=element.getText();
		System.out.println(text);
		
		
	}

}
