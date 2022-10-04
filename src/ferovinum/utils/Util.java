package ferovinum.utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ferovinum.operations.Addition;
import ferovinum.operations.Division;
import ferovinum.operations.Multiplication;
import ferovinum.operations.Operator;
import ferovinum.operations.Substraction;

public class Util {

	public static final String COLUMN_DELIMITER = ",";

	public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.#");

	public static final char[] CHAR_ARRAY = IntStream.rangeClosed('a', 'z').mapToObj(c -> "" + (char) c)
			.collect(Collectors.joining()).toCharArray();

	public static Map<String, Operator> MATH_OPERATIONS = new HashMap<String, Operator>() {
		{
			put("+", new Addition());
			put("-", new Substraction());
			put("*", new Multiplication());
			put("/", new Division());
		}
	};

	public static boolean isOnlyNumber(String s) {
		try {
			int i = Integer.parseInt(s);
			return true;
		}

		catch (NumberFormatException er) {
			return false;
		}
	}

	public static boolean isColumnNameAndRowName(String expression) {
		return expression.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*");
	}

	public static boolean isOperator(String exp) {
		return exp.matches(".*([+]|[-]|[*]|[\\/]).*");
	}

}
