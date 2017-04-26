package com.market.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class MarketExceptionLog {

	static Logger Log = Logger.getLogger(MarketExceptionLog.class);

	public static void catchException(String exceptionStr) {

		Log.error(exceptionStr);
	}

	public static String getStackTraceAsString(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));

		return errors.toString();

	}
}
