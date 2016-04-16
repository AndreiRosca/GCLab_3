package md.utm.labs.gc.function;

public class SineFunction extends Function {
	
	protected SineFunction() {
		super();
	}

	public static Function newInstance() {
		return new SineFunction();
	}

	@Override
	public double evaluate(double x) {
		return 1.3 * Math.sin(2.0 * x);
	}
}
