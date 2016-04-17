package md.utm.labs.gc.draw;

import md.utm.labs.gc.algorithm.BresenhamLineAlgorithm;
import md.utm.labs.gc.function.CosineFunction;
import md.utm.labs.gc.function.CubeFunction;
import md.utm.labs.gc.function.Function;
import md.utm.labs.gc.function.Interval;
import md.utm.labs.gc.function.IntervalBuilder;
import md.utm.labs.gc.function.IntervalType;
import md.utm.labs.gc.function.SineFunction;

public class FunctionPlotterFactory {

	public static FunctionPlotter getSinePlotter() {
		return getFunctionPLotter(SineFunction.newInstance());
	}
	
	public static FunctionPlotter getSinePlotter(double functionCoefficient) {
		return getFunctionPLotter(SineFunction.newInstance(functionCoefficient));
	}

	public static FunctionPlotter getCosinePlotter() {
		return getFunctionPLotter(CosineFunction.newInstance());
	}
	
	public static FunctionPlotter getCosinePlotter(double functionCoefficient) {
		return getFunctionPLotter(CosineFunction.newInstance(functionCoefficient));
	}

	public static FunctionPlotter getCubePlotter() {
		return getFunctionPLotter(CubeFunction.newInstance());
	}

	protected static FunctionPlotter getFunctionPLotter(Function function) {
		Interval closedInterval = new IntervalBuilder(IntervalType.CLOSED).from(-4).to(4).build();
		return FunctionPlotter.newInstance(BresenhamLineAlgorithm.newInstance(), function, closedInterval);
	}
}
