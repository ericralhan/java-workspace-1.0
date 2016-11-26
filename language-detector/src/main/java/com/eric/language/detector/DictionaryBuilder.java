package com.eric.language.detector;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DictionaryBuilder {
	private static final Logger LOGGER = LogManager.getLogger(DictionaryBuilder.class);

	public static final String NON_ALPHABET_AND_SPACE_REGEX = "[^a-zA-Z ]";
	private Map<String, Set<String>> dictionary = new ConcurrentHashMap<>();

	public DictionaryBuilder() {
	}

	public void readAndStore(File dictionaryFile) {
		dictionaryFile.getLines().forEach(line -> {
			if (StringUtils.isNotBlank(line)) {
				storeLineInDictionary(line, dictionaryFile.getLanguage());
			}
		});
	}

	public void storeLineInDictionary(String line, String language) {
		if (StringUtils.isBlank(line)) {
			throw new IllegalStateException();
		}
		line = StringUtils.lowerCase(line.replaceAll(DictionaryBuilder.NON_ALPHABET_AND_SPACE_REGEX, ""));

		String[] wordArray = StringUtils.split(line);
		if (wordArray == null)
			return;

		Set<String> newWords = new HashSet<>(Arrays.asList(wordArray));

		Set<String> currentWords = dictionary.get(language);
		if (currentWords == null) {
			dictionary.put(language, newWords);
		} else {
			currentWords.addAll(newWords);
		}

		LOGGER.trace("dictionary {}", dictionary);
	}

	public Map<String, Set<String>> getDictionary() {
		return dictionary;
	}
}
