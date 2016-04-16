package md.utm.labs.gc.function;

public class CosineFunction extends Function {

	protected CosineFunction() {
		super();
	}
	
	public static Function newInstance() {
		return new CosineFunction();
	}

	@Override
	public double evaluate(double x) {
		return 4 * Math.cos(2.0 * x);
	}
}
