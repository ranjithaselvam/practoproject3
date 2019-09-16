package com.atmecs.practo.report;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.atmecs.practo.constants.Constants;

public class LoggerReportInformation {
	static Logger logger = null;

	public static void logReporter(String message) {
		PropertyConfigurator.configure(Constants.log_path);
		logger = Logger.getLogger(LoggerReportInformation.class.getName());
        logger.info(message);
	}
}