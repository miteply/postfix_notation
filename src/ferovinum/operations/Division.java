package ferovinum.operations;

public class Division implements Operator{

	@Override
	public Double calculate(Double num1, Double num2) {

		if(num1 == 0) 
			throw new ArithmeticException("Devide by zero operation is not possible");
		
		return (double) (num2 / num1);
	}

}
