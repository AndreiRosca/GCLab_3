package md.utm.labs.gc.function;

public class CubeFunction extends Function {

	protected CubeFunction() {
		super();
	}
	
	public static Function newInstance() {
		return new CubeFunction();
	}

	@Override
	public double evaluate(double x) {
		return x * x * x;
	}
}
