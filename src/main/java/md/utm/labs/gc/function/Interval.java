package md.utm.labs.gc.function;

public class Interval {
	
	private static final int EVALUATION_STEP = 1;
	private double from;
	private double to;
	private IntervalType intervalType;

	public Interval(double from, double to, IntervalType intervalType) {
		this.from = from;
		this.to = to;
		this.intervalType = intervalType;
	}

	public double getFrom() {
		return from;
	}

	public double getTo() {
		return to;
	}

	public IntervalType getIntervalType() {
		return intervalType;
	}

	public double getStartingPoint() {
		return intervalType == IntervalType.CLOSED ? from : from + EVALUATION_STEP;
	}

	public boolean isWhithinBounds(double point) {
		return point >= getStartingPoint() && point <= getEndingPoint();
	}

	public double getEndingPoint() {
		return intervalType == IntervalType.CLOSED ? to : to - EVALUATION_STEP;
	}
}
