package com.eric.language.detector;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eric.language.detector.exception.UnsupportedFileException;
import com.eric.language.detector.util.FileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LanguageDetector {
	private static final Logger LOGGER = LogManager.getLogger(LanguageDetector.class);

	private static final String UNKNOWN = "UNKNOWN";
	private FileReader fileReader;
	private DictionaryBuilder dictionary;
	private String textFileName;
	private String textFileFolder;
	private String dictionaryFolder;

	public LanguageDetector() {
	}

	public LanguageDetector(FileReader fileReader, DictionaryBuilder dictionary, String textFileName,
			String textFileFolder, String dictionaryFolder) {
		this.fileReader = fileReader;
		this.dictionary = dictionary;
		this.textFileName = textFileName;
		this.textFileFolder = textFileFolder;
		this.dictionaryFolder = dictionaryFolder;
	}

	public String determineLanguage() {
		String pathStr = textFileFolder + "/" + textFileName;
		String pathDictionaryStr = dictionaryFolder;

		fileReader = new FileReader();
		dictionary = new DictionaryBuilder();

		try {
			List<File> dictionaryFiles = fileReader.readDirectory(pathDictionaryStr);
			dictionaryFiles.forEach(dictionaryFile -> dictionary.readAndStore(dictionaryFile));

			String language = determineLanguage(pathStr, dictionaryFiles);
			LOGGER.debug("Language is: {}", language);
			return language;
		} catch (IOException ex) {
			return UNKNOWN;
		}
	}

	private String determineLanguage(String pathStr, List<File> dictionaryFiles) throws IOException {
		File inputFile;
		try {
			inputFile = fileReader.readAllLinesWithCharacterCheck(pathStr);
			if (inputFile == null)
				return UNKNOWN;
		} catch (UnsupportedFileException e) {
			return UNKNOWN;
		}

		Map<String, Integer> languageScore = calculateScore(dictionaryFiles, inputFile);

		Map.Entry<String, Integer> maxEntry = null;
		int totalScore = 0;
		for (Map.Entry<String, Integer> scoreEntry : languageScore.entrySet()) {
			if (maxEntry == null || scoreEntry.getValue() > maxEntry.getValue()) {
				maxEntry = scoreEntry;
			}
			totalScore += scoreEntry.getValue();
		}

		if (maxEntry == null || totalScore == 0) {
			return UNKNOWN;
		}
		return maxEntry.getKey();
	}

	Map<String, Integer> calculateScore(List<File> dictionaryFiles, File inputFile) {
		Map<String, Integer> languageScore = new HashMap<>();
		dictionaryFiles.forEach(dictionaryFile -> languageScore.put(dictionaryFile.getLanguage(), 0));

		Set<String> allWords = new HashSet<>();
		inputFile.getLines().forEach(line -> {
			LOGGER.debug("line = {}", line);
			line = StringUtils.lowerCase(line.replaceAll(DictionaryBuilder.NON_ALPHABET_AND_SPACE_REGEX, ""));
			String[] wordArray = StringUtils.split(line);
			allWords.addAll(Arrays.asList(wordArray));
		});

		dictionary.getDictionary().forEach((language, dictionaryWords) -> {
			LOGGER.debug("Checking {}", language);

			allWords.forEach(word -> {
				if (dictionaryWords.contains(word)) {
					LOGGER.debug("dictionary contains word {} for com.eric.language.detector {}", word, language);
					languageScore.put(language, languageScore.get(language) + 1);
				}
			});
		});

		LOGGER.info("Language Scores: {}", languageScore);
		return languageScore;
	}

	public String getTextFileName() {
		return textFileName;
	}

	public String getTextFileFolder() {
		return textFileFolder;
	}

	public String getDictionaryFolder() {
		return dictionaryFolder;
	}

	public DictionaryBuilder getDictionary() {
		return dictionary;
	}

	public void setTextFileName(String textFileName) {
		this.textFileName = textFileName;
	}

	public void setTextFileFolder(String textFileFolder) {
		this.textFileFolder = textFileFolder;
	}

	public void setDictionaryFolder(String dictionaryFolder) {
		this.dictionaryFolder = dictionaryFolder;
	}
}
