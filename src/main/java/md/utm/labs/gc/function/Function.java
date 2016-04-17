package md.utm.labs.gc.function;

import java.util.ArrayList;
import java.util.List;

import md.utm.labs.gc.draw.Point;

public abstract class Function {
	private static final double EVALUATION_STEP = 0.05;
	private double functionCoefficient = 2.0;

	public abstract double evaluate(double x);

	public List<Point> evaluate(Interval interval) {
		List<Point> functionPoints = new ArrayList<Point>();
		for (double x = interval.getStartingPoint(); interval.isWhithinBounds(x); x += EVALUATION_STEP) {
			Point point = Point.create(x, evaluate(x));
			functionPoints.add(point);
		}
		return functionPoints;
	}

	public double getFunctionCoefficient() {
		return functionCoefficient;
	}

	public void setFunctionCoefficient(double functionCoefficient) {
		this.functionCoefficient = functionCoefficient;
	}
}
