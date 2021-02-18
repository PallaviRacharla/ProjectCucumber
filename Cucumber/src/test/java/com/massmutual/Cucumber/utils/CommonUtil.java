package com.massmutual.Cucumber.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CommonUtil {
	/**
	 * Method to convert String to double * 
	 	 */
	public static double getDouble(String text) {
		text = text.replaceAll("[^a-zA-Z0-9.]", "");
		double d = Double.parseDouble(text);
		return d;
	}

	/**
	 * Method will convert Double currency to Formatted currency with $ and , & .
	 	 */
	public static String stringToCurrency(double currencyAmount) {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
		String result = currencyFormatter.format(currencyAmount);
		return result;
	}
	
}
