package md.utm.labs.gc.algorithm;

import java.util.ArrayList;
import java.util.List;

import md.utm.labs.gc.draw.Point;

public class BresenhamLineAlgorithm implements LineDrawingAlgorithm {

	protected BresenhamLineAlgorithm() {
		super();
	}

	public static BresenhamLineAlgorithm newInstance() {
		return new BresenhamLineAlgorithm();
	}

	public List<Point> getLinePoints(Point start, Point end) {
		return new BresenhamLineGenerator(start, end).generate();
	}

	private static class BresenhamLineGenerator {
		@SuppressWarnings("unused")
		private Point start;
		private Point end;
		private double deltaX;
		private double deltaY;
		private double eps;
		private double x;
		private double y;
		private List<Point> linePoints = new ArrayList<Point>();

		public BresenhamLineGenerator(Point start, Point end) {
			this.start = start;
			this.end = end;
			deltaX = end.getX() - start.getX();
			deltaY = end.getY() - start.getY();
			x = start.getX();
			y = start.getY();
		}

		public List<Point> generate() {
			for (; x <= end.getX(); ++x) {
				linePoints.add(Point.create(x, y));
				eps += deltaY;
				if (eps * 2 >= deltaX) {
					++y;
					eps -= deltaX;
				}
			}
			return linePoints;
		}
	}
}
