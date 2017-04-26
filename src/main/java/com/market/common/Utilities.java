package com.market.common;

import java.util.Calendar;
import java.util.Random;

import com.market.logging.MarketExceptionLog;

public class Utilities {

	public static String generateRandom() {
		Random rndm = new Random();
		boolean flag = true;
		int random_1 = 10000000;
		int random_2 = 10000000;

		try {
			while (flag) {
				random_1 = Math.abs(rndm.nextInt());
				// The below validation is for the eight digit positive number.
				if (random_1 >= 10000000 && random_1 <= 99999999) {

					flag = false;
				}
			}
			flag = true;
			while (flag) {
				random_2 = Math.abs(rndm.nextInt());
				// The below validation is for the eight digit positive number.
				if (random_2 >= 10000000 && random_2 <= 99999999) {

					flag = false;
				}
			}
		} catch (Exception pe) {
			MarketExceptionLog.catchException(pe.toString());
		}
		return String.valueOf(random_1) + String.valueOf(random_2);
	}

	/**
	 * @param int
	 *            Digits No of digits random number to be generated
	 * @return Random number
	 */
	// This method generates eight digit positive random integer
	public static String generateRandom(int digits) {
		Random rndm = new Random();
		boolean flag = true;
		long random = 0;
		String minNumber = "";
		String maxNumber = "";

		try {
			if (digits > 16)
				digits = 16;
			if (digits <= 0)
				digits = 8;
			for (int i = 0; i < digits; i++) {
				minNumber += "1";
				maxNumber += "9";
			}

			while (flag) {
				random = Math.abs(rndm.nextInt());
				// The below validation is for the eight digit positive number.
				if (random >= Long.parseLong(minNumber) && random <= Long.parseLong(maxNumber)) {
					flag = false;
				}
			}
		} catch (Exception pe) {
			MarketExceptionLog.catchException(pe.toString());
		}

		return String.valueOf(random);
	}

}
