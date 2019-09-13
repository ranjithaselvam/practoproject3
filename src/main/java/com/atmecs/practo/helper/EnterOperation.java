package com.atmecs.practo.helper;




import org.openqa.selenium.interactions.Actions;

import com.atmecs.practo.testbase.Browser;

public class EnterOperation extends Browser {
	static Actions action;
	public static void pressEnter()
	{
	action=new Actions(driver);
	action.sendKeys().build().perform();
		
	}
	

}
