package md.utm.labs.gc.function;

public class CosineFunction extends Function {

	protected CosineFunction() {
		super();
	}
	
	public static Function newInstance() {
		return new CosineFunction();
	}
	
	public static Function newInstance(double functionCoefficient) {
		Function function = new CosineFunction();
		function.setFunctionCoefficient(functionCoefficient);
		return function;
	}

	@Override
	public double evaluate(double x) {
		return 4 * Math.cos(getFunctionCoefficient() * x);
	}
	
	public String toString() {
		return "4 cos(" + getFunctionCoefficient() + "x)";
	}
}
