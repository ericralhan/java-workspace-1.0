package com.eric.language.detector.client;

import org.apache.commons.lang.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eric.language.detector.LanguageDetector;
import com.eric.language.detector.util.PropertiesReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;

public class DetectorClient {
	private static final Logger LOGGER = LogManager.getLogger(DetectorClient.class);

	public static void main(String[] args) {

		LanguageDetector language = new LanguageDetector();
		run(language);

	}

	static void run(LanguageDetector language) {

		try {
			userInput(language, System.in);

			LOGGER.info("**************************** WELCOME TO LANGUAGE DETECTOR ****************************");
			LOGGER.info("You can modify {} in {} manually", language.getTextFileName(), language.getTextFileFolder());
			LOGGER.info("and Language Detector will detect the language");
			LOGGER.info("based on existing dictionary files in {}", language.getDictionaryFolder());
			LOGGER.info("**************************************************************************************");

			String languageStr = language.determineLanguage();
			LOGGER.info("Language is {}", languageStr);

		} catch (NoSuchFileException e) {
			LOGGER.error("Invalid folder", e);
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}

	static void userInput(LanguageDetector language, InputStream in) throws IOException {

		String defaultTextFileName = PropertiesReader.getProperty("text.file.name");
		String defaultTextFileFolder = PropertiesReader.getProperty("text.file.folder");
		String defaultDictionaryFolder = PropertiesReader.getProperty("dictionary.folder");

		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		System.out.println("********************** USER INPUT **********************");
		System.out.print("Enter text file name (default is " + defaultTextFileName + "):");
		String textFileName = br.readLine();

		System.out.print("Enter text file folder (default is " + defaultTextFileFolder + "):");
		String textFileFolder = br.readLine();

		System.out.print("Enter dictionary folder (default is " + defaultDictionaryFolder + "):");
		String dictionaryFolder = br.readLine();

		language.setTextFileName(StringUtils.isBlank(textFileName) ? defaultTextFileName : textFileName);
		language.setTextFileFolder(StringUtils.isBlank(textFileFolder) ? defaultTextFileFolder : textFileFolder);
		language.setDictionaryFolder(
				StringUtils.isBlank(dictionaryFolder) ? defaultDictionaryFolder : dictionaryFolder);
		System.out.println("********************************************************");
	}
}
