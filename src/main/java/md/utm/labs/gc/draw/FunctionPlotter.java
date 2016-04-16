package md.utm.labs.gc.draw;

import java.util.ArrayList;
import java.util.List;

import md.utm.labs.gc.Point;
import md.utm.labs.gc.algorithm.LineDrawingAlgorithm;
import md.utm.labs.gc.function.Function;
import md.utm.labs.gc.function.Interval;

public class FunctionPlotter {

	private LineDrawingAlgorithm lineAlgorithm;
	private Function function;
	private Interval interval;

	protected FunctionPlotter(LineDrawingAlgorithm lineAlgorithm, Function function, Interval interval) {
		this.lineAlgorithm = lineAlgorithm;
		this.function = function;
		this.interval = interval;
	}

	static FunctionPlotter newInstance(LineDrawingAlgorithm bresenhamLineAlgorithm, Function function,
			Interval interval) {
		return new FunctionPlotter(bresenhamLineAlgorithm, function, interval);
	}

	public List<Point> plot() {
		List<Point> functionPoints = function.evaluate(interval);
		List<Point> curvePoints = new ArrayList<Point>();
		for (int i = 0; i < functionPoints.size() - 1; ++i) {
			Point segmentStart = functionPoints.get(i);
			Point segmentEnd = functionPoints.get(i + 1);
			curvePoints.addAll(lineAlgorithm.getLinePoints(segmentStart, segmentEnd));
		}
		return curvePoints;
	}

	public static class FunctionPlotterBuilder {

		private LineDrawingAlgorithm lineAlgorithm;
		private Function function;
		private Interval interval;

		public FunctionPlotterBuilder(Function function) {
			this.function = function;
		}

		public FunctionPlotterBuilder setLineAlgorithm(LineDrawingAlgorithm lineAlgorithm) {
			this.lineAlgorithm = lineAlgorithm;
			return this;
		}

		public FunctionPlotterBuilder setInterval(Interval interval) {
			this.interval = interval;
			return this;
		}

		public FunctionPlotter build() {
			return FunctionPlotter.newInstance(lineAlgorithm, function, interval);
		}
	}
}
