package com.market.logging;

import org.apache.log4j.Logger;

public class MarketLogInfo {

	Logger log = null;

	public MarketLogInfo(Class<?> clsName) {
		log = Logger.getLogger(clsName);
	}

	public MarketLogInfo(String clsName) {
		log = Logger.getLogger(clsName);
	}

	public void info(String infoStr) {
		log.info(infoStr);
	}

}
