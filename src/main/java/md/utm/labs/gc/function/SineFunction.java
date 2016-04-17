package md.utm.labs.gc.function;

public class SineFunction extends Function {
	
	protected SineFunction() {
		super();
	}

	public static Function newInstance() {
		return new SineFunction();
	}
	
	public static Function newInstance(double functionCoefficient) {
		Function function = new SineFunction();
		function.setFunctionCoefficient(functionCoefficient);
		return function;
	}

	@Override
	public double evaluate(double x) {
		return 1.3 * Math.sin(getFunctionCoefficient() * x);
	}
	
	public String toString() {
		return "1.3 sin(" + Math.round(getFunctionCoefficient()) + "x)";
	}
}
