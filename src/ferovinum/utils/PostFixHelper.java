package ferovinum.utils;

import java.util.Stack;

/**
 * Performs mathematical operations from expression
 * @author T.Mykhaylo
 *
 */
public class PostFixHelper {

	public String evaluate(String exp) {

		if (Util.isOnlyNumber(exp))
			return exp;
		if (exp.contains(" ") && Util.isOperator(exp)) {
			return calculatePostfixNotation(exp);
		}
		return "#ERR";

	}

	private static String calculatePostfixNotation(String exp) {
		String[] columns = exp.split(" ");
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < columns.length; i++) {
			
			if (!columns[i].isEmpty())
				
				if (Util.isOnlyNumber(columns[i])) {
					stack.push(Double.valueOf(columns[i]));
				} else {
					Double op1 = stack.pop();
					Double op2 = stack.pop();
			
					stack.push(Util.MATH_OPERATIONS.get(columns[i]).calculate(Double.valueOf(op1),
							Double.valueOf(op2)));
				}
		}
		return Util.DECIMAL_FORMAT.format(stack.pop());
	}

}