package com.atmecs.practo.testbase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.practo.constants.Constants;



public class propertyReader {
	public static String properties(String elements) throws IOException

	{

		Properties property = new Properties();
		FileInputStream stream;
			stream = new FileInputStream(Constants.identifier_path);
			property.load(stream);
		String data = property.getProperty(elements);
		return data;
		

	}
}

/*
 * List<String> propsFiles = Arrays.asList(Classpath.loc_file,
 * Classpath.url_file, Classpath.register_file, Classpath.search_file,
 * Classpath.datamanage_file)
 * 
 */
/*
 * public String readPropertiesFile(String elements) throws
 * FileNotFoundException { Properties prop=new Properties();
 * 
 * FileInputStream input=new FileInputStream(
 * "D:\\new\\eclipse-workspace\\AutomationTesting\\src\\test\\resources\\locator\\locators.properties"
 * ); try { prop.load(input);
 * 
 * }
 * 
 * }
 * 
 * }
 */
