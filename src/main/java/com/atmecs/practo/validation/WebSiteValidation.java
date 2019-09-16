package com.atmecs.practo.validation;

import org.testng.Assert;

public class WebSiteValidation {
	public static void pageValidation(String actualDetails,String expectedDetails )
	{
		try
	{
		
	
		Assert.assertEquals(actualDetails, expectedDetails);
		System.out.println(" Passed: " + " Expected: " + expectedDetails + " Actual: " + actualDetails);
	}catch(AssertionError assertionError)
	{
		System.out.println("Failed" +  expectedDetails + actualDetails);
	}
		
	}
	
	

}
