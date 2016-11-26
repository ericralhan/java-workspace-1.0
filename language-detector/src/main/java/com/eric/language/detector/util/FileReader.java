package com.eric.language.detector.util;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eric.language.detector.File;
import com.eric.language.detector.exception.UnsupportedFileException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {
	private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

	public static final String LEGAL_CHARACTERS_REGEX = "^[a-zA-Z \\.\\,\\;\\:]+$";

	public FileReader() {
	}

	public List<File> readDirectory(String directory) throws IOException {
		List<String> fileNames = new ArrayList<>();
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
			directoryStream.forEach(path -> fileNames.add(path.toString()));
		}

		LOGGER.trace("fileNames: {}", fileNames);
		List<File> dictionaryFiles = new ArrayList<>();

		fileNames.forEach(fileName -> {
			try {
				File file = readAllLinesWithCharacterCheck(fileName);
				dictionaryFiles.add(file);
			} catch (UnsupportedFileException | IOException e) {
				// no worries
			}
		});

		return dictionaryFiles;
	}

	public File readAllLinesWithCharacterCheck(String pathStr) throws IOException, UnsupportedFileException {
		Path path = Paths.get(pathStr);
		List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
		LOGGER.debug("Reading file {}", path.getFileName().toString());

		String parent = path.getParent().toString();
		String fileName = path.getFileName().toString();
		Pattern pattern = Pattern.compile(LEGAL_CHARACTERS_REGEX);

		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
			LOGGER.trace("line = {}", line);
			LOGGER.trace("matches {}", matcher.matches());

			if (StringUtils.isNotBlank(line) && !matcher.matches()) {
				LOGGER.error("File {} has illegal character(s)", path.getFileName().toString());
			}
		}
		return new File(lines, parent, fileName);
	}
}
