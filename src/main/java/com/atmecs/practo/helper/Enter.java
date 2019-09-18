package com.atmecs.practo.helper;

import org.openqa.selenium.By;

import com.atmecs.practo.testbase.Browser;

public class Enter extends Browser {
	public static void value(String xpath,String key)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(key);
	}

}
