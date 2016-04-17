package md.utm.labs.gc.algorithm;

import java.util.List;

import md.utm.labs.gc.draw.Point;

public interface LineDrawingAlgorithm {
	public List<Point> getLinePoints(Point start, Point end);
}
