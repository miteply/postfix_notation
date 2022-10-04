package ferovinum.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Iterates through each file's row which is represented as an item in the list
 * 
 * @author T.Mykhaylo
 *
 */
public class ProcessDataList {

	PostFixHelper postFixHelper;

	List<Map<Character, String>> fileRowsList;

	public ProcessDataList(List<Map<Character, String>> fileRowsList) {
		this.postFixHelper = new PostFixHelper();
		this.fileRowsList = fileRowsList;
	}

	/**
	 * Iterate row files which are represented in a list
	 */
	public void processListItem() {
		for (int index = 0; index < fileRowsList.size(); index++) {
			processLineColumns(fileRowsList.get(index));
		}
	}

	/**
	 * Iterate row columns and prints the result of each column
	 * 
	 * @param columns
	 */
	private void processLineColumns(Map<Character, String> columns) {
		List<String> results = new ArrayList<>();

		for (Map.Entry<Character, String> entry : columns.entrySet()) {

			String value = entry.getValue();

			if (Util.isColumnNameAndRowName(value)) {
				value = findValueFromColumnAndRow(value);
			}

			String evaluated = !value.contains("#ERR") ? postFixHelper.evaluate(value) : value;

			columns.replace(entry.getKey(), evaluated);
			results.add(evaluated);
		}
		System.out.println(results.stream().collect(Collectors.joining(",")));
	}

	/**
	 * get result for the expression
	 * 
	 * @param exp
	 * @return
	 */
	private String findValueFromColumnAndRow(String exp) {
		String postFixWithNums = "";

		String operands[] = exp.split(" ");
		for (int i = 0; i < operands.length; i++) {
			String val = operands[i].trim();
			if (!val.isEmpty()) {
				if (Util.isOperator(val)) {
					postFixWithNums += val.charAt(0) + " ";
				} else {
					String string = getValueFromColumnAndRow(val);

					String res = postFixHelper.evaluate(string);
					postFixWithNums += res + " ";
				}
			}
		}

		return postFixWithNums.substring(0, postFixWithNums.length() - 1);
	}

	/**
	 * Find the value from the column and row name
	 * @param exp
	 * @return
	 */
	private String getValueFromColumnAndRow(String exp) {

		String columnName = exp.substring(0, 1);
		String rowName = exp.substring(1);
		int index = Integer.valueOf(rowName) - 1;
		Map<Character, String> map = fileRowsList.get(index);

		String string = map.get(columnName.charAt(0)).trim();
		if (string.equals(exp))
			return "#ERR";
		if (Util.isColumnNameAndRowName(string)) {
			return getValueFromColumnAndRow(string.trim());
		}
		return string;
	}

}
