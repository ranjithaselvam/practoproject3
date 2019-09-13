package com.atmecs.practo.validation;

import org.testng.Assert;

public class WebSiteValidation {
	public static void pageValidation(String actualDetails,String expectedDetails ,String message)
	{
		try
	{
		
	
		Assert.assertEquals(actualDetails, expectedDetails);
		System.out.println(" Passed: " + message + " Expected: " + expectedDetails + " Actual: " + actualDetails);
	}catch(AssertionError assertionError)
	{
		System.out.println("Failed" + message + expectedDetails + actualDetails);
	}
		
	}
	
	public static void doctorDetails()
	{
		
	}

}
