package md.utm.labs.gc.function;

import java.util.ArrayList;
import java.util.List;

import md.utm.labs.gc.Point;

public abstract class Function {
	private static final int EVALUATION_STEP = 1;
	
	public abstract double evaluate(double x);
	
	public List<Point> evaluate(Interval interval) {
		List<Point> functionPoints = new ArrayList<Point>();
		for (double x = interval.getStartingPoint(); interval.isWhithinBounds(x); x += EVALUATION_STEP) {
			Point point = Point.create(x, evaluate(x));
			functionPoints.add(point);
		}
		return functionPoints;
	}
}
