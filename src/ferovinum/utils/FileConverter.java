package ferovinum.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Maps data file into rows and columns
 * 
 * @author T.Mykhaylo
 *
 */
public class FileConverter {

	char[] charArray = IntStream.rangeClosed('a', 'z').mapToObj(c -> "" + (char) c).collect(Collectors.joining())
			.toCharArray();

	private List<Map<Character, String>> fileRowsList = new ArrayList<>();
	private Map<Character, String> columnsNameAndValue;

	/**
	 * Add file rows into a list and column's row into a map
	 * 
	 * @param br
	 * @return
	 */
	public List<Map<Character, String>> mapFileRowsIntoList(BufferedReader br) {
		String line;
		try {
			while ((line = br.readLine()) != null) {
				fileRowsList.add(mapColumnNameWithValue(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileRowsList;
	}

	/**
	 * Add columns into the map which contains the key as the column name identified
	 * by in Alphabetical chars
	 * 
	 * @param line
	 * @return
	 */
	private Map<Character, String> mapColumnNameWithValue(String line) {
		columnsNameAndValue = new HashMap<>();
		String[] columnsLine = getColumnsFromLine(line);

		for (int index = 0; index < columnsLine.length; index++) {
			char columnName = charArray[index];
			String columnValue = columnsLine[index];
			columnsNameAndValue.put(columnName, columnValue);
		}

		return columnsNameAndValue;

	}

	/**
	 * Splits the row by delimiter
	 * 
	 * @param line
	 * @return
	 */
	private String[] getColumnsFromLine(String line) {
		return line.split(Util.COLUMN_DELIMITER);
	}

}
