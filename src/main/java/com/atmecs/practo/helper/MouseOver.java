package com.atmecs.practo.helper;

import org.openqa.selenium.By;


import com.atmecs.practo.testbase.Browser;

public class MouseOver extends Browser{
	public static void click(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
		
	}

}
