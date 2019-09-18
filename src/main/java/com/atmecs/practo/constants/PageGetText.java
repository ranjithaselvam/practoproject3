package com.atmecs.practo.constants;

import org.openqa.selenium.By;

import com.atmecs.practo.testbase.Browser;

public class PageGetText extends Browser {
	public static String text(String properties,String message)
	{
		String data = driver.findElement(By.xpath(properties)).getText();
		System.out.println(message +":"+ data);
		return data;
		
	}

	

}
