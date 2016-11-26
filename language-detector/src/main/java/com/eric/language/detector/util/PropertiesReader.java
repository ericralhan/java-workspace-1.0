package com.eric.language.detector.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	static InputStream inputStream;
	static Properties prop = new Properties();
	static String propFileName = "config.properties";

	public static String getProperty(String propName) throws IOException {

		try {

			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file {} not found" + propFileName);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop.getProperty(propName);
	}
}
