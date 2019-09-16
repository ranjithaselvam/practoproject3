package com.atmecs.practo.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.atmecs.practo.constants.Constants;

public class PropertyReader {
	public static void propertiesReader() throws IOException
	
	{
		 Properties property1 = new Properties(); 
		  FileInputStream stream1;

		  stream1 = new FileInputStream(Constants.identifier_path);
		  property1.load(stream1);
	}
	
	 
	 


}