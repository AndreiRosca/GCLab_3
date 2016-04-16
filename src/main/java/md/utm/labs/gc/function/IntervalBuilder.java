package md.utm.labs.gc.function;

public class IntervalBuilder {

	private double from;
	private double to;
	private IntervalType intervalType;

	public IntervalBuilder(IntervalType intervalType) {
		this.intervalType = intervalType;
	}

	public IntervalBuilder from(double from) {
		this.from = from;
		return this;
	}

	public IntervalBuilder to(double to) {
		this.to = to;
		return this;
	}

	public Interval build() {
		return new Interval(from, to, intervalType);
	}
}
