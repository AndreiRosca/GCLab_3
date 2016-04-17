package md.utm.labs.gc.draw;

public class Point {
	private static final double EQUALITY_PRECISION = 0.1;
	private double x;
	private double y;

	protected Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static Point create(double x, double y) {
		return new Point(x, y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Math.abs(x - other.x) > EQUALITY_PRECISION)
			return false;
		if (Math.abs(y - other.y) > EQUALITY_PRECISION)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
