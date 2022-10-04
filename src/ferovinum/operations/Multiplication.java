package ferovinum.operations;

public class Multiplication implements Operator{

	@Override
	public Double calculate(Double num1, Double num2) {
	 return (double) (num2*num1);
	}

}
